/**
 * 
 */
package renderer;

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

		Point p = myRay.findClosestPoint(scene.geometries.findIntersections(myRay));

		return calcColor(p);

	}

	/**
	 * receives a point and calculate and returns
	 * it's color
	 * 
	 * @param  p point
	 * @return color of point
	 */
	private Color calcColor(Point p) {
		return scene.ambientLight.getIntensity();
	}

}