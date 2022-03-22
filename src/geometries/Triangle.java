package geometries;

import java.util.List;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;
import java.util.List;
import static primitives.Util.*;
import primitives.*;


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
		//if plane isn't intersected, obviously triangle too
		List<Point> intersections = plane.findIntersections(ray);
		if (intersections == null)
			return null;
		
		Point point = ray.getP0();
		Vector vector = ray.getDir();
		
		Vector v1 = vertices.get(0).subtract(point);
		Vector v2 = vertices.get(1).subtract(point);
		Vector v3 = vertices.get(2).subtract(point);
		
		Vector n1 = (v1.crossProduct(v2)).normalize();
		Vector n2 = (v2.crossProduct(v3)).normalize();
		Vector n3 = (v3.crossProduct(v1)).normalize();
		
		double t1 = vector.dotProduct(n1);
		if (isZero(t1))
			return null;
		
		double t2 = vector.dotProduct(n2);
		if (isZero(t2))
			return null;
		double t3 = vector.dotProduct(n3);
		if (isZero(t3))
			return null;
		
		if((t1 > 0 && t2 > 0 && t3 > 0) || (t1 < 0 && t2 < 0 && t3 < 0))
			return this.plane.findIntersections(ray);
		
		return null;
	}
}
