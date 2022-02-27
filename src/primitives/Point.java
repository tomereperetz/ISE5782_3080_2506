package primitives;

/**
 * Class Point is the basic class representing 3D point of Euclidean geometry in Cartesian
 * 3-Dimensional coordinate system.
 * @author Nitay Kazimirsky and Tomer Peretz
*/

public class Point {
	
	final Double3 xyz;
	
	public Point(double c1, double c2, double c3) {
		this.xyz = new Double3(c1, c2, c3);
	}
	
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
	
	public Point add(Vector v) {
		return new Point(this.xyz.add(v.getXyz()));
	}
	
	public Vector substruct(Point p) {
		return new Vector(this.xyz.subtract(p.xyz));
	}

}
