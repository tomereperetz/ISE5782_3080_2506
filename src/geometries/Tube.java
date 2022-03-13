package geometries;

import primitives.*;

/**
* This class will declare and implement necessary functionality of Tube* 
* @author Nitay Kazimirsky and Tomer Peretz
*/
public class Tube implements Geometry {
	
	final protected Ray axisRay;
	final protected double radius;
	
	/**
	 * Constructor to initialize Tube based object with its values
	 * 
	 * @param myAxisRay axis ray
	 * @param myRadius radius
	 */
	public Tube(Ray myAxisRay, double myRadius) {
		axisRay = myAxisRay;
		radius = myRadius;
	}
	
	/**
	 * get axis ray of tube
	 * 
	 * @return axis ray
	 */
	public Ray getAxisRay() {
		return axisRay;
	}
	
	/**
	 * get radius of tube
	 * 
	 * @return radius
	 */
	public double getRadius() {
		return radius;
	}

	@Override
	public Vector getNormal(Point p) {
		double u = axisRay.getDir().dotProduct(p.subtract(axisRay.getP0()));
		Point o = axisRay.getP0().add(axisRay.getDir().scale(u));
		return p.subtract(o).normalize();
	}
	
	@Override
	public String toString() {
		return "axis ray: " + axisRay.toString() + "\nradius " + radius;
	}

}
