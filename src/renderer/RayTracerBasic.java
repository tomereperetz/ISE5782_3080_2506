/**
 * 
 */
package renderer;

import geometries.Triangle;
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

	/**
	 * Constructor which enables father constructor
	 * 
	 * @param myScene - scene
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
	 * receives a point and calculate and returns it's color
	 * 
	 * @param intersection geoPoint
	 * @return color of pixel
	 */
	private Color calcColor(GeoPoint intersection, Ray ray) {
		if (scene.ambientLight == null)
			return intersection.geometry.getEmission().add(calcLocalEffects(intersection, ray));
		return scene.ambientLight.getIntensity(). // Phong lighting model: ambient light +
				add(intersection.geometry.getEmission()). // emission light +
				add(calcLocalEffects(intersection, ray)); // local effects (diffusion + specular)
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
		Vector lightDirection = l.scale(-1);
		Vector delVector = n.scale(nv < 0 ? DELTA : -DELTA);
		Point point = gp.point.add(delVector);
		Ray lightRay = new Ray(point, lightDirection);
		List<GeoPoint> intersections = scene.geometries.findGeoIntersections(lightRay);
		
		if (intersections == null) {
			return true;
		}
		
		for (GeoPoint intersection : intersections) {
			if (intersection.point.distance(lightRay.getP0()) < ls.getDistance(gp.point)) {
				return false;
			}
		}
		
		return true;
	}
}