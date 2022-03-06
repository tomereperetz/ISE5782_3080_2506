package primitives;

/**
 * Class Point is the basic class representing 3D point of Euclidean geometry in Cartesian
 * 3-Dimensional coordinate system.
 * @author Nitay Kazimirsky and Tomer Peretz
*/

public class Point {
	
	/*protected*/ final Double3 xyz;
	
	/**
	 * Constructor to initialize Point based object with its values
	 * 
	 * @param c1 
	 * @param c2
	 * @param c3
	 */
	public Point(double c1, double c2, double c3) {
		this.xyz = new Double3(c1, c2, c3);
	}
	
	/**
	 * Constructor to initialize Point based object with its values
	 * 
	 * @param myXyz class performance
	 */
	Point(Double3 myXyz) {
		this.xyz = myXyz;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
	    if (obj == null) return false;
	    if (!(obj instanceof Point)) return false;
	    Point other = (Point)obj;
	    return this.xyz.equals(other.xyz);
	}
	
	@Override
	public String toString() {
		return "(" + xyz.d1 + ", " + xyz.d2 + ", " + xyz.d3 + ")";
	}
	
	/**
	 * adds point to vector and returns head point of new vector
	 * @param v
	 * @return Point
	 */
	public Point add(Vector v) {
		return new Point(this.xyz.add(v.xyz));
	}
	
	/**
	 * receives point and returns head point of new vector, created
	 * by subtracting point from vector
	 * @param p
	 * @return
	 */
	public Vector subtract(Point p) {
		return new Vector(this.xyz.subtract(p.xyz));
	}

}
