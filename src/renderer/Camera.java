/**
 * 
 */
package renderer;

import primitives.*;
import static primitives.Util.*;

/**
 * Camera class represents a camera and provides necessary fields and methods
 * 
 * @author tomer and nitay
 */
public class Camera {
	private Point p0;
	private Vector vTo;
	private Vector vUp;
	private Vector vRight;
	private double width;
	private double height;
	private double distance;

	/**
	 * Constructor to initialize camera
	 * 
	 * @param myP0  camera's location
	 * @param myVto direction vector
	 * @param myVup direction vector
	 */
	public Camera(Point myP0, Vector myVto, Vector myVup) {

		if (!isZero(myVto.dotProduct(myVup)))
			throw new IllegalArgumentException("ERROR: vectors aren't orthogonal");

		p0 = myP0;
		vTo = myVto.normalize();
		vUp = myVup.normalize();
		vRight = vTo.crossProduct(vUp).normalize();
	}

	/**
	 * get location point of camera
	 * 
	 * @return location point
	 */
	public Point getP0() {
		return p0;
	}

	/**
	 * get direction vector of camera (to)
	 * 
	 * @return direction vector (to)
	 */
	public Vector getvTo() {
		return vTo;
	}

	/**
	 * get direction vector of camera (up)
	 * 
	 * @return direction vector (up)
	 */
	public Vector getvUp() {
		return vUp;
	}

	/**
	 * get direction vector of camera (right)
	 * 
	 * @return direction vector (right)
	 */
	public Vector getvRight() {
		return vRight;
	}

	/**
	 * get view plane distance from camera (width)
	 * 
	 * @return distance from camera (width)
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * get view plane distance from camera (height)
	 * 
	 * @return distance from camera (height)
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * get view plane distance from camera (distance)
	 * 
	 * @return distance from camera (distance)
	 */
	public double getDistance() {
		return distance;
	}

	/**
	 * set plane's location (width and height)
	 * 
	 * @param myWidth  - plane's width
	 * @param myHeight - plane's height
	 * @return this camera
	 */
	public Camera setVPSize(double myWidth, double myHeight) {
		width = myWidth;
		height = myHeight;
		return this;
	}

	/**
	 * set plane's location (distance)
	 * 
	 * @param myDistance - plane's distance
	 * @return this camera
	 */
	public Camera setVPDistance(double myDistance) {
		distance = myDistance;
		return this;
	}

	/**
	 * get view plane distance from camera (distance)
	 * 
	 * @param nX number of pixel (width)
	 * @param nY number of pixels (height)
	 * @param j  pixel coordinate
	 * @param i  pixel coordinate
	 * 
	 * @return ray through pixel
	 */
	public Ray constructRay(int nX, int nY, int j, int i) {

		Point Pc = p0.add(vTo.scale(distance));

		double Ry = height / nY;
		double Rx = height / nX;

		double Yi = -(i - (nY - 1) / 2d) * Ry;
		double Xj = (j - (nX - 1) / 2d) * Rx;

		Point Pij = Pc;

		if (Yi == 0 && Xj == 0) {
			return new Ray(p0, Pij.subtract(p0));
		}

		if (Xj == 0) {
			Pij = Pc.add(vUp.scale(Yi));
			return new Ray(p0, Pij.subtract(p0));
		}
		
		if (Yi == 0) {
			Pij = Pc.add(vRight.scale(Xj));
			return new Ray(p0, Pij.subtract(p0));
		}

		Pij = Pc.add(vRight.scale(Xj).add(vUp.scale(Yi)));
		return new Ray(p0, Pij.subtract(p0));
	}
}
