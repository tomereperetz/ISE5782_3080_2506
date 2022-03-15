package geometries;

import primitives.Point;
import primitives.Vector;

/**
 * Geometry interface includes all unprimitives geometries 
 * @author Tomer Peretz and Nitay Kazimirsky
 */
public interface Geometry extends Intersectable {
	
	/**
	 * receives a point and returns the vertical vector of the geometry at that point
	 * @param p point on the surface of geometry
	 * @return normal vector
	 */
	public Vector getNormal(Point p);
}
