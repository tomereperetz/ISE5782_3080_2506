/**
 * 
 */
package renderer;

import geometries.Intersectable.GeoPoint;
import lighting.LightSource;
import primitives.*;
import scene.Scene;

import static primitives.Util.*;

import java.util.List;

/**
 * RayTracerBasic class inherits RayTracerBase abstract class and implements
 * it's abstract method
 * 
 * @author Tomer and Nitay
 *
 */
public class RayTracerBasic extends RayTracerBase {
	/*
	 * Constant variable DELTA for size of movement of rays head
	 */
	private static final double DELTA = 0.1;
	
	private static final int MAX_CALC_COLOR_LEVEL = 10;
	private static final double MIN_CALC_COLOR_K = 0.001;
	private static final double INITIAL_K = 1.0;

	/**
	 * Constructor which enables father constructor
	 * 
	 * @param myScene scene
	 */
	public RayTracerBasic(Scene myScene) {
		super(myScene);
	}

	@Override
	public Color traceRay(Ray myRay) {
		var intersections = scene.geometries.findGeoIntersections(myRay);
		return intersections == null ? scene.backGround //
				: calcColor(myRay.findClosestGeoPoint(intersections), myRay);
	}

	/**
	 * TODO: add description
	 * @param intersection point
	 * @param ray of light source
	 * @param level TODO: add description
	 * @param k TODO: add description
	 * @return calculated color
	 * */
	private Color calcColor(GeoPoint intersection, Ray ray, int level, Double3 k) {
//		if (scene.ambientLight == null)
//			return intersection.geometry.getEmission().add(calcLocalEffects(intersection, ray));
//		return scene.ambientLight.getIntensity(). // Phong lighting model: ambient light +
//				add(intersection.geometry.getEmission()). // emission light +
//				add(calcLocalEffects(intersection, ray)); // local effects (diffusion + specular)
		Color color = intersection.geometry.getEmission().add(calcLocalEffects(intersection, ray));
	    return 1 == level ? color : color.add(calcGlobalEffects(intersection, ray, level, k));
	}
	
	/**
	 * TODO: add description
	 * @param gp intersection point
	 * @param ray of light source
	 * @return calculated color
	 */
	private Color calcColor(GeoPoint gp, Ray ray) {
		return calcColor(gp, ray, MAX_CALC_COLOR_LEVEL, new Double3(INITIAL_K)).add(scene.ambientLight.getIntensity());
	}

	
	/**
	 * TODO: Calculates global effects of Phong lighting model 
	 * @param intersection point
	 * @param ray of source light
	 * @param level TODO: add description
	 * @param k TODO: add description
	 * @return calculated color
	 */
	private Color calcGlobalEffects(GeoPoint intersection, Ray ray, int level, Double3 k) {
		Color color = Color.BLACK;
		
		Double3 kR = intersection.geometry.getMaterial().kR;
		Double3 kkr = k.scale(kR);	
		Ray reflectedRay = constructReflectedRay(intersection.point, ray.getDir(),
				intersection.geometry.getNormal(intersection.point));
		GeoPoint reflectedPoint = findClosestIntersection(reflectedRay);
		if(kkr.lowerThan(MIN_CALC_COLOR_K) && reflectedPoint != null) {
			color = color.add(calcColor(reflectedPoint, reflectedRay, level - 1, kkr).scale(kR));
		}
		
		Double3 kT = intersection.geometry.getMaterial().kT;
		Double3 kkt = k.scale(kT);
		Ray refractedRay = constructRefractedRay(intersection.point, ray.getDir(),
				intersection.geometry.getNormal(intersection.point));
		GeoPoint refractedPoint = findClosestIntersection(refractedRay);
		if(kkt.lowerThan(MIN_CALC_COLOR_K) && refractedPoint != null) {
			color = color.add(calcColor(refractedPoint, refractedRay, level - 1, kkt).scale(kT));
		}
		
		return color;
	}


	/**
	 * Auxiliary method to calculate local effects
	 * 
	 * @param intersection intersection point
	 * @param ray          ray through pixel
	 * @return color updated color
	 */
	private Color calcLocalEffects(GeoPoint intersection, Ray ray) {
		Vector v = ray.getDir();
		Vector n = intersection.geometry.getNormal(intersection.point);
		double nv = alignZero(n.dotProduct(v));
		if (nv == 0)
			return Color.BLACK;
		Material material = intersection.geometry.getMaterial();
		int nShininess = material.nShininess;
		Double3 kd = material.kD;
		Double3 ks = material.kS;

		Color color = Color.BLACK;
		for (LightSource lightSource : scene.lights) {
			Vector l = lightSource.getL(intersection.point);
			double nl = alignZero(n.dotProduct(l));
			if (nl * nv > 0) {
				if (unShaded(intersection, l, n, nv, lightSource)) {
					Color lightIntensity = lightSource.getIntensity(intersection.point);
					color = color.add(calcDiffusive(kd, l, n, lightIntensity),
							calcSpecular(ks, l, n, v, nShininess, lightIntensity));
				}
			}
		}
		return color;
	}

	/**
	 * Calculates the diffusive factor of light
	 * 
	 * @param kd
	 * @param l
	 * @param lightIntensity
	 * @return color the calculated color (after diffusion)
	 */
	private Color calcDiffusive(Double3 kd, Vector l, Vector n, Color lightIntensity) {
		Double3 factor = kd.scale(Math.abs(l.normalize().dotProduct(n.normalize())));
		return lightIntensity.scale(factor);
	}

	/**
	 * Calculates the specular factor of light
	 * 
	 * @param ks
	 * @param l
	 * @param n
	 * @param v
	 * @param nShininess
	 * @param lightIntensity
	 * @return color the calculated color (after speculation)
	 */
	private Color calcSpecular(Double3 ks, Vector l, Vector n, Vector v, int nShininess, Color lightIntensity) {
		Vector r = l.normalize().subtract(n.normalize().scale(2 * l.dotProduct(n))).normalize();
		double minusVr = v.normalize().dotProduct(r.normalize()) * -1;
		return lightIntensity.scale(ks.scale(Math.pow(Math.max(0, minusVr), nShininess)));
	}

	/**
	 * Calculates and determines if a point is shaded by light source
	 * 
	 * @param gp point to be determined
	 * @param l  vector from light to point
	 * @param n  normal vector
	 * @param nv result of scaling vectors n, v
	 * @param ls light source
	 * @return is shaded (boolean)
	 */
	private boolean unShaded(GeoPoint gp, Vector l, Vector n, double nv, LightSource ls) {
		Point point = gp.point.add(n.scale(nv < 0 ? DELTA : -DELTA));
		Ray lightRay = new Ray(point, l.scale(-1));
		List<GeoPoint> intersections = scene.geometries.findGeoIntersections(lightRay);
		
		if (intersections == null) {
			return true;
		}
		
		for (GeoPoint intersection : intersections) {
			if (intersection.point.distance(lightRay.getP0()) < ls.getDistance(gp.point) &&
					gp.geometry.getMaterial().kT == Double3.ZERO) {
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Calculates the refracted ray
	 * @param p intersection point
	 * @param v in vector
	 * @param n normal vector
	 * @return refracted ray
	 */
	private Ray constructRefractedRay(Point p, Vector v, Vector n) {
		return new Ray(p.add(n.scale(-DELTA)), v);
	}
	
	/**
	 * Calculates the reflected ray
	 * @param p intersection point
	 * @param v in vector
	 * @param n normal vector
	 * @return reflected ray
	 */
	private Ray constructReflectedRay(Point p, Vector v, Vector n) {
		return new Ray(p.add(n.scale(DELTA)), v.subtract(n.scale(2*v.dotProduct(n))));
	}
	
	/**
	 * Finding closest intersection point to head of ray
	 * @param ray to find closest point to
	 * @return closest point
	 */
	private GeoPoint findClosestIntersection(Ray ray) {
		List<GeoPoint> intersections = scene.geometries.findGeoIntersections(ray);	
		if (intersections == null) {
			return null;
		}	
		return ray.findClosestGeoPoint(intersections);	
	}
}
