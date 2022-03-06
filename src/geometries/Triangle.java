package geometries;

import primitives.Point;

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
}
