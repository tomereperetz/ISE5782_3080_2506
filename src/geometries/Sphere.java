package geometries;

import primitives.Point;
import primitives.Vector;

public class Sphere {
	private Point center;
	private double radius;
	
	public Vector getNormal(Point p) {
		return null;
	}
	
	public Sphere(Point p, double myRadius) {
		center = p;
		radius = myRadius;
	}

	public Point getCenter() {
		return center;
	}

	public double getRadius() {
		return radius;
	}
	
	@Override
	public String toString() {
		return "center point: " + center.toString() + "\nradius: " + radius;
	}

}
