/**
 * 
 */
package geometries;

import java.util.LinkedList;
import java.util.List;

import primitives.Point;
import primitives.Ray;

import java.util.Collections;

/**
 * Geometries class includes a list of different geometries
 *  
 * @author Tomer Peretz and Nitay Kazimirsky
 */
public class Geometries implements Intersectable {
	private List<Intersectable> myGeometries;
	
	/**
	 * Default constructor to initialize Geometries class
	 */
	public Geometries() {
		myGeometries = new LinkedList<>();
	}
	
	/**
	 * params constructor to initialize Geometries class
	 * 
	 * @param list of geometries
	 */
	public Geometries(Intersectable... geometries) {
		myGeometries = new LinkedList<>();
		add(geometries);
	}
	
	/**
	 * add item to list of geometries
	 * 
	 * @param geometry
	 */
	public void add(Intersectable... geometries) {
		 Collections.addAll(myGeometries, geometries);
	     }
	
	@Override
	public List<Point> findIntersections(Ray ray) {
        List<Point> result = null;
		for (Intersectable geometry : myGeometries) {
			List<Point> geoPoints = geometry.findIntersections(ray);
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
