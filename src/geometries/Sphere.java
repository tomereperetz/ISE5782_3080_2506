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

	@Override
	public Vector getNormal(Point p) {
		return p.subtract(center).normalize();
	}

	@Override
	public List<Point> findIntersections(Ray ray) {
		Point p0 = ray.getP0();
		Vector v = ray.getDir();
		
		if (p0.equals(center)) {
            return List.of(center.add(v.scale(radius)));
        }
		
		Vector u = center.subtract(p0);
		double tm = alignZero(v.dotProduct(u));

		double d = alignZero(Math.sqrt(u.lengthSquared() - tm * tm));
		
		if (d >= radius)
			return null;

		double th = alignZero(Math.sqrt(radius * radius - d * d));

		double t1 = alignZero(tm + th);
		double t2 = alignZero(tm - th);

		if (t1 > 0 && t2 > 0) {
			Point p1 = p0.add(v.scale(t1));
			Point p2 = p0.add(v.scale(t2));
			return List.of(p1, p2);
		}
		if(t1 > 0) {
			Point p1 = p0.add(v.scale(t1));
			return List.of(p1);
		}
		if(t2 > 0) {
			Point p2 = p0.add(v.scale(t2));
			return List.of(p2);
		}	
		return null;
	}

	/**
	 * Constructor to initialize Sphere based object with its values
	 * 
	 * @param p        point
	 * @param myRadius radius
	 */
	public Sphere(Point p, double myRadius) {
		center = p;
		radius = myRadius;
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