package geometries;

import java.util.List;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

/**
* This class will declare and implement necessary functionality of Plane* 
* @author Nitay Kazimirsky and Tomer Peretz
*/
public class Plane implements Geometry {
	final private Point p0;
	final private Vector normal;
	
	/**
	 * Constructor to initialize Cylinder based object with its values
	 * 
	 * @param p point
	 * @param v vector
	 */
	public Plane (Point p, Vector v) {
		p0 = p;
		normal = v.normalize();
	}
	
	/**
	 * Constructor to initialize Plane based object with its values
	 * 
	 * @param p1 point
	 * @param p2 point
	 * @param p3 point
	 */
	public Plane(Point p1, Point p2, Point p3) {
		p0 = p1;
		Vector v1 = p1.subtract(p2);
		Vector v2 = p2.subtract(p3);
		normal = v1.crossProduct(v2).normalize();
	}
	
	/**
	 * get plane's starting point
	 * 
	 * @return starting point
	 */
	public Point getP0() {
		return p0;
	}
	
	/**
	 * get plane's defining vector
	 * 
	 * @return normal vector
	 */
	public Vector getNormal() {
		return normal;
	}
	
	@Override
	public List<Point> findIntersections(Ray ray) {
		Vector tmp = p0.subtract(ray.getP0());
		double t = normal.dotProduct(tmp) / (normal.dotProduct(ray.getDir()));
		if(t <= 0)
			return null;
		Point point = ray.getP0().add(ray.getDir().scale(t));
		return List.of(point);
	}
	
	@Override
	public Vector getNormal(Point p) {
		return normal;
	}
	
	@Override
	public String toString() {
		return "point: " + p0.toString() + "\nnormal vector: " + normal.toString();
	}

}
