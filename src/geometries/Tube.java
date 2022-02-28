package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

/**
* This class will declare and implement necessary functionality of Tube* 
* @author Nitay Kazimirsky and Tomer Peretz
*/
public class Tube implements Geometry {
	
	protected Ray axisRay;
	protected double radius;
	
	/**
	 * Constructor to initialize Tube based object with its values
	 * 
	 * @param myAxisRay
	 * @param myRadius 
	 */
	public Tube(Ray myAxisRay, double myRadius) {
		axisRay = myAxisRay;
		radius = myRadius;
	}
	
	/**
	 * get axis ray of tube
	 * 
	 * @return Ray
	 */
	public Ray getAxisRay() {
		return axisRay;
	}
	
	/**
	 * get radius of tube
	 * 
	 * @return double
	 */
	public double getRadius() {
		return radius;
	}

	@Override
	public Vector getNormal(Point p) {
		return null;
	}
	
	@Override
	public String toString() {
		return "axis ray: " + axisRay.toString() + "\nradius " + radius;
	}

}
