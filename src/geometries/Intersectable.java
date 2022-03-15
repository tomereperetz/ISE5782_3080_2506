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

/**
 * receives a ray and returns all intersections between ray and different geometries
 * 
 * @param ray
 * @return list of intersections
 */
public interface Intersectable {
	public List<Point> findIntersections(Ray ray);
}
