package geometries;

import java.util.LinkedList;
import java.util.List;

import primitives.Ray;

import java.util.Collections;

/**
 * Geometries class includes a list of different geometries
 * 
 * @author Tomer Peretz and Nitay Kazimirsky
 */
public class Geometries extends Intersectable {
	private List<Intersectable> myGeometries = new LinkedList<>();

	/**
	 * Constructs composite object of intersectable geometries
	 * 
	 * @param list of geometries
	 */
	public Geometries(Intersectable... geometries) {
		add(geometries);
	}

	/**
	 * add item to list of geometries
	 * 
	 * @param geometry
	 */
	public void add(Intersectable... geometries) {
		if (geometries.length != 0) Collections.addAll(myGeometries, geometries);
	}

	@Override
	public List<GeoPoint> findGeoIntersectionsHelper(Ray ray) {
		List<GeoPoint> result = null;
		for (Intersectable geometry : myGeometries) {
			List<GeoPoint> geoPoints = geometry.findGeoIntersectionsHelper(ray);
			if (geoPoints != null) {
				if (result == null) {
					result = new LinkedList<>();
				}
				result.addAll(geoPoints);
			}
		}
		return result;
	}

}
