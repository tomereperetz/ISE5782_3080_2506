package geometries;

import primitives.*;


/**
* This class will declare and implement necessary functionality of Cylinder* 
* @author Nitay Kazimirsky and Tomer Peretz
*/
public class Cylinder extends Tube {
	
	final private double height;
	
	/**
	 * Constructor to initialize Cylinder based object with its values
	 * 
	 * @param myAxisRay axis ray
	 * @param myRadius radius of circle
	 */
	public Cylinder(Ray myAxisRay, double myRadius, double myHeight) {
		super(myAxisRay, myRadius);
		height = myHeight;
	}
	
	/**
	 * get height of Cylinder
	 * 
	 * @return height
	 */
	public double getHeight() {
		return height;
	}

	@Override
	public Vector getNormal(Point p) {
		return null;
	}
	
	@Override
	public String toString() {
		return super.toString() + "height: " + height;
	}

}
