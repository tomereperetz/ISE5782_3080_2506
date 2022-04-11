/**
 * 
 */
package geometries;

import primitives.Point;
import primitives.Ray;

import java.awt.peer.DialogPeer;
import java.util.List;
import java.util.Objects;

/**
 * Intersectable interface finds intersections between rays and geometries
 * 
 * @author Tomer and Nitay
 *
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
		return geoList == null ? null :
			geoList.stream().map(gp -> gp.point).toList();
	}
	
	/**
	 * TODO: documentation
	 * @return
	 */
	public List<GeoPoint> findGeoIntersections(Ray myRay) {
		return null;
	}
	
	/**
	 * TODO: documentation
	 * @param myRay
	 * @return
	 */
	protected List<GeoPoint> findGeoIntersectionsHelper(Ray myRay) {
		return null;
	}

	/**
	 * An internal auxiliary class GeoPoint
	 * 
	 * @author tomer and nitay
	 *
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
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			GeoPoint other = (GeoPoint) obj;
			return Objects.equals(geometry, other.geometry) && //
				   Objects.equals(point, other.point);
		}

		@Override
		public String toString() {
			return "GeoPoint [geometry=" + geometry + ", point=" + point + "]";
		}

	}
}
