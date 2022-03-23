/**
 * 
 */
package geometries;

import primitives.Point;
import primitives.Ray;

import java.util.List;

/**
 * Intersectable interface finds intersections between rays and geometries
 * 
 * @author Tomer and Nitay
 *
 */
public interface Intersectable {

	/**
	 * receives a ray and returns all intersections between ray and different
	 * geometries
	 * 
	 * @param ray to intersect the geometry by
	 * @return list of intersections
	 */
	public List<Point> findIntersections(Ray ray);
}
