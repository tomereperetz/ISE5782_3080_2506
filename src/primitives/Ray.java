package primitives;

/**
 * Class Ray is the basic class representing ray of Euclidean geometry in Cartesian
 * 3-Dimensional coordinate system.
 * @author Nitay Kazimirsky and Tomer Peretz
*/
public class Ray {
	private final Point p0;
	private final Vector dir;
	
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
	 * get ray's defining point
	 * @return Point
	 */
	public Point getP0() {
		return p0;
	}
	
	/**
	 * get ray's defining vector
	 * @return Vector
	 */
	public Vector getDir() {
		return dir;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
	    if (obj == null) return false;
	    if (!(obj instanceof Ray)) return false;
	    Ray other = (Ray)obj;
	    return this.getP0().equals(other.getP0()) && this.getDir().equals(other.getDir());
	}
	
	@Override
	public String toString() {
		return "point: " + getP0().toString() + "\ndirection: " + getDir().toString();
	}
	
}