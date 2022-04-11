/**
 * 
 */
package renderer;

import geometries.Geometry;
import geometries.Intersectable;
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
		
		if (scene.geometries.findIntersections(myRay) == null)
			return scene.backGround;

		GeoPoint p = myRay.findClosestGeoPoint(scene.geometries.findGeoIntersections(myRay));

		return calcColor(p);

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
