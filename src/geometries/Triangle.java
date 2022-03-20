package geometries;

import java.util.List;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

/**
* This class will declare and implement necessary functionality of Triangle* 
* @author Nitay Kazimirsky and Tomer Peretz
*/
public class Triangle extends Polygon {
	
	/**
	 * Constructor to initialize Triangle based object with its values
	 * 
	 * @param p1 point
	 * @param p2 point
	 * @param p3 point
	 */
	public Triangle(Point p1, Point p2, Point p3) {
		super(p1,p2,p3);
	}
	
	@Override
	public List<Point> findIntersections(Ray ray) {
		Vector v1 = vertices.get(0).subtract(ray.getP0());
		Vector v2 = vertices.get(1).subtract(ray.getP0());
		Vector v3 = vertices.get(2).subtract(ray.getP0());
		Vector n1 = (v1.crossProduct(v2)).normalize();
		Vector n2 = (v2.crossProduct(v3)).normalize();
		Vector n3 = (v3.crossProduct(v1)).normalize();
		if((ray.getDir().dotProduct(n1) > 0 &&
		    ray.getDir().dotProduct(n2) > 0 &&
		    ray.getDir().dotProduct(n3) > 0)
		    || 
		   (ray.getDir().dotProduct(n1) < 0 &&
		    ray.getDir().dotProduct(n2) < 0 &&
		    ray.getDir().dotProduct(n3) < 0))
				return null;
		return this.plane.findIntersections(ray);
	}
}
