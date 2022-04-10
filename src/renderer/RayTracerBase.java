/**
 * 
 */
package renderer;

import primitives.Color;

import primitives.Ray;
import scene.Scene;

/**
 * Class RayTracerBase is an abstract class which
 * traces rays through pixels 
 * 
 * @authors tomer and nitay
 */
public abstract class RayTracerBase {
	protected Scene scene; 
	
	/**
	 * Constructor to initialize scene
	 * 
	 * @param p1 scene
	 */
	RayTracerBase(Scene myScene) {
		scene = myScene;
	}
	

	/**
	 * receives a ray and returns the color
	 * of the pixel it's intersecting
	 * 
	 * @param  myRay - ray through pixel
	 * @return color of pixel
	 */
	public abstract Color traceRay(Ray myRay);
}
