package primitives;

import static primitives.Util.*;


import java.util.List;

import geometries.Intersectable.GeoPoint;

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
	 * finds the closest point to ray's starting
	 * point from a list of points
	 * 
	 * @param  pointsList - list of points
	 * @return closest point to ray's starting point
	 */
	public Point findClosestPoint(List<Point> pointsList) {
		return pointsList == null || pointsList.isEmpty() ? null :
			findClosestGeoPoint(pointsList.stream().map(
					p -> new GeoPoint(null, p)).toList()).point;
	}
	
	/**
	 * TODO: documentation
	 * 
	 * @param  pointsList - list of geo-points
	 * @return closest geo-point
	 */
	public GeoPoint findClosestGeoPoint(List<GeoPoint> pointsList) {
		
		if (pointsList == null)
			return null;
		
		double myDistance = Double.POSITIVE_INFINITY;
		GeoPoint retPoint = null;
		
		for (GeoPoint myPoint : pointsList) {
			if(myPoint.point.distance(p0) < myDistance) {
				retPoint = myPoint;
				myDistance = myPoint.point.distance(p0);
			}
		}
		return retPoint;
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