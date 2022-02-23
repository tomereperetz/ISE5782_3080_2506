package primitives;

/**
 * Class Ray is the basic class representing ray of Euclidean geometry in Cartesian
 * 3-Dimensional coordinate system.
 * @author Nitay Kazimirsky and Tomer Peretz
*/
public class Ray {
	private final Point p0 = null;
	private final Vector dir = null;
	
	public Ray(Point p, Vector v) {
		getP0().xyz = p.xyz;
		dir.normalize();
		getDir().xyz = v.xyz;
		//further changes...
	}
	
	public Point getP0() {
		return p0;
	}
	
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