package geometries;

import primitives.Color;
import primitives.Point;
import primitives.Vector;

/**
 * Geometry class includes all non-primitives geometries
 *  
 * @authors Tomer Peretz and Nitay Kazimirsky
 */
public abstract class Geometry extends Intersectable {

	protected Color emission = Color.BLACK;
	
	/**
	 * receives a point and returns the vertical
	 * vector of the geometry at that point
	 * 
	 * @param p point on the surface of geometry
	 * @return normal vector
	 */
	public abstract Vector getNormal(Point p);
	
	/**
	 * Get geometry's emission
	 * 
	 * @return geometry's emission
	 */
	public Color getEmission() {
		return emission;
	}

	/**
	 * Setter function for emission
	 * 
	 * @param  emmision - geometry's emission
	 * @return this object
	 */
	public Geometry setEmission(Color emmision) {
		this.emission = emmision;
		return this;
	}

}
