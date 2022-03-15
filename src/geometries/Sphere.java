package geometries;

import java.util.List;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

/**
* This class will declare and implement necessary functionality of Sphere* 
* @author Nitay Kazimirsky and Tomer Peretz
*/
public class Sphere implements Geometry {
	final private Point center;
	final private double radius;

	@Override
	public Vector getNormal(Point p) {
		return p.subtract(center).normalize();
	}
	
	@Override
	public List<Point> findIntersections(Ray ray) {
		return null;
	}
	
	/**
	 * Constructor to initialize Sphere based object with its values
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
	 * @return center point
	 */
	public Point getCenter() {
		return center;
	}
	
	/**
	 * get sphere's radius
	 * @return radius
	 */
	public double getRadius() {
		return radius;
	}
	
	@Override
	public String toString() {
		return "center point: " + center.toString() + "\nradius: " + radius;
	}

}
