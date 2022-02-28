package geometries;

import primitives.Point;
import primitives.Vector;

/**
* This class will declare and implement necessary functionality of Plane* 
* @author Nitay Kazimirsky and Tomer Peretz
*/
public class Plane implements Geometry {
	/*final*/ private Point p0;
	/*final*/ private Vector normal;
	
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
		normal = null;
	}
	
	/**
	 * get plane's defining point
	 * 
	 * @return Point
	 */
	public Point getP0() {
		return p0;
	}
	
	/**
	 * get plane's defining vector
	 * 
	 * @return Vector
	 */
	public Vector getNormal() {
		return normal;
	}
	
	/**
	 * get plane's defining vector
	 * 
	 * @return Vector
	 */
	@Override
	public Vector getNormal(Point p) {
		return null;
	}
	
	@Override
	public String toString() {
		return "point: " + p0.toString() + "\nnormal vector: " + normal.toString();
	}

}
