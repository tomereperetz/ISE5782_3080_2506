package geometries;

import primitives.Point;
import primitives.Vector;

/**
* This class will declare and implement necessary functionality of Sphere* 
* @author Nitay Kazimirsky and Tomer Peretz
*/
public class Sphere implements Geometry {
	private Point center;
	private double radius;

	@Override
	public Vector getNormal(Point p) {
		return null;
	}
	
	/**
	 * Constructor to initialize Cylinder based object with its values
	 * 
	 * @param p point
	 * @param myRadius radius
	 */
	public Sphere(Point p, double myRadius) {
		center = p;
		radius = myRadius;
	}
	
	/**
	 * get center if sphere point
	 * @return Point
	 */
	public Point getCenter() {
		return center;
	}
	
	/**
	 * get sphere's radius
	 * @return double
	 */
	public double getRadius() {
		return radius;
	}
	
	@Override
	public String toString() {
		return "center point: " + center.toString() + "\nradius: " + radius;
	}

}
