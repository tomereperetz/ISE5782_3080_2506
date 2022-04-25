/**
 * 
 */
package renderer;

import geometries.Intersectable.GeoPoint;
import primitives.*;
import primitives.Ray;
import scene.Scene;

/**
 * RayTracerBasic class inherits RayTracerBase abstract class
 * and implements it's abstract method  
 * 
 * @author tomer and nitay
 *
 */
public class RayTracerBasic extends RayTracerBase {

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
				: calcColor(myRay.findClosestGeoPoint(intersections));
	}

	/**
	 * receives a point and calculate and returns
	 * it's color
	 * 
	 * @param  p geo-point
	 * @return color of pixel
	 */
	private Color calcColor(GeoPoint p) {
		return scene.ambientLight.getIntensity().add(p.geometry.getEmission());
	}

}
