package geometries;

import primitives.Point;
import primitives.Vector;

/**
 * Geometry interface includes all geometry unprimitives polygons 
 * @author Tomer Peretz and Nitay Kazimirsky
 */
public interface Geometry {
	
	/**
	 * receives a point and returns the vertical vector of the polygon at that point
	 * @param p point of polygon
	 * @return Vector
	 */
	public Vector getNormal(Point p);
}
