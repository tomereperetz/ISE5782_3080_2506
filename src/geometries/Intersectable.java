/**
 * 
 */
package geometries;

import primitives.Point;
import primitives.Ray;

import java.util.List;

/**
 * Class Intersectable finds intersections between rays and geometries
 * 
 * @author Tomer and Nitay
 */
public abstract class Intersectable {

	/**
	 * receives a ray and returns all intersections between ray and different
	 * geometries
	 * 
	 * @param ray to intersect the geometry by
	 * @return list of intersections
	 */
	public List<Point> findIntersections(Ray ray) {
		var geoList = findGeoIntersections(ray);
		return geoList == null ? null : geoList.stream().map(gp -> gp.point).toList();
	}

	/**
	 * finds intersections between ray and geometry
	 * 
	 * @param myRay ray
	 * @return intersections
	 */
	public List<GeoPoint> findGeoIntersections(Ray myRay) {
		return findGeoIntersectionsHelper(myRay);
	}

	/**
	 * finds intersections between ray and geometry
	 * 
	 * @param myRay ray
	 * @return intersections
	 */
	protected abstract List<GeoPoint> findGeoIntersectionsHelper(Ray myRay);

	/**
	 * An internal auxiliary class GeoPoint containing a point on the surface of a
	 * geometry and the geometry itself
	 * 
	 * @authors Tomer and Nitay
	 */
	public static class GeoPoint {
		public Geometry geometry;
		public Point point;

		/**
		 * Constructor to initialize class's fields
		 * 
		 * @param myGeometry geometry
		 * @param myPoint    point
		 */
		public GeoPoint(Geometry myGeometry, Point myPoint) {
			geometry = myGeometry;
			point = myPoint;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (!(obj instanceof GeoPoint other))
				return false;
			return geometry == other.geometry && point.equals(other.point);
		}

		@Override
		public String toString() {
			return "GeoPoint [geometry=" + geometry + ", point=" + point + "]";
		}

	}
}
