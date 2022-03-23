package primitives;

import static primitives.Util.*;

/**
 * Class Ray is the basic class representing ray of Euclidean geometry in Cartesian
 * 3-Dimensional coordinate system.
 * @author Nitay Kazimirsky and Tomer Peretz
*/
public class Ray {
	final private Point p0;
	final private Vector dir;
	
	/**
	 * Constructor to initialize Ray based object with its values
	 * 
	 * @param p point
	 * @param v vector
	 */
	public Ray(Point p, Vector v) {
		p0 = p;
		dir = v.normalize();
	}
	
	/**
	 * get ray's starting point
	 * @return starting point
	 */
	public Point getP0() {
		return p0;
	}
	
	/**
	 * get ray's starting vector
	 * @return starting vector
	 */
	public Vector getDir() {
		return dir;
	}

	/**
	 * get point on ray
	 * 
	 * @param t scalar
	 * @return requested point
	 */
	public Point getPoint(double t) {
		return isZero(t) ? p0 : p0.add(dir.scale(t));
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
	    if (obj == null) return false;
	    if (!(obj instanceof Ray)) return false;
	    Ray other = (Ray)obj;
	    return this.p0.equals(other.p0) && this.dir.equals(other.dir);
	}
	
	@Override
	public String toString() {
		return "point: " + p0.toString() + "\ndirection: " + dir.toString();
	}
	
}