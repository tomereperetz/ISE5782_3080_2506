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
	 * @param p0 point
	 * @param p1 point
	 * @param p2 point
	 */
	public Triangle(Point p0, Point p1, Point p2) {
		super(p0,p1,p2);
	}
}
