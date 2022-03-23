package geometries;

import java.util.List;
import static primitives.Util.*;
import primitives.*;

/**
 * This class will declare and implement necessary functionality of Sphere*
 * 
 * @author Nitay Kazimirsky and Tomer Peretz
 */
public class Sphere implements Geometry {
	final private Point center;
	final private double radius;
	final private double radiusSqr;
	
	/**
	 * Constructor to initialize Sphere based object with its values
	 * 
	 * @param p        point
	 * @param myRadius radius
	 */
	public Sphere(Point p, double myRadius) {
		center = p;
		radius = myRadius;
		radiusSqr = myRadius * myRadius;
	}


	@Override
	public Vector getNormal(Point p) {
		return p.subtract(center).normalize();
	}

	@Override
	public List<Point> findIntersections(Ray ray) {
		Vector u;
		try {
			u = center.subtract(ray.getP0());
		} catch (IllegalArgumentException ignore) {
			return List.of(ray.getPoint(radius));
		}

		double tm = alignZero(ray.getDir().dotProduct(u));
		double dSqr = alignZero(u.lengthSquared() - tm * tm);
		double thSqr = radiusSqr - dSqr;

		if (alignZero(thSqr) <= 0)
			// The ray's line is either out of the sphere
			// or it is tangent to the sphere
			return null;

		double th = alignZero(Math.sqrt(thSqr));

		double t2 = alignZero(tm + th);
		if (t2 <= 0)
			// the sphere is behind the ray head point
			return null;

		double t1 = alignZero(tm - th);
		return t1 <= 0 //
				? List.of(ray.getPoint(t2)) //
				: List.of(ray.getPoint(t1), ray.getPoint(t2));
	}


	/**
	 * get center if sphere point
	 * 
	 * @return center point
	 */
	public Point getCenter() {
		return center;
	}

	/**
	 * get sphere's radius
	 * 
	 * @return radius
	 */
	public double getRadius() {
		return radius;
	}

	@Override
	public String toString() {
		return "center point: " + center.toString() + "\nradius: " + radius;
	}

}
