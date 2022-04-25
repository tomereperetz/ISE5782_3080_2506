/**
 * 
 */
package renderer;

import primitives.*;

import static primitives.Util.*;

import java.util.MissingResourceException;

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
	private ImageWriter imageWriter;
	private RayTracerBase rayTracerBase;

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
	 * set RayTracerBase
	 * 
	 * @param rayTracerBase
	 * @return this camera
	 */
	public Camera setRayTracer(RayTracerBase myRayTracerBase) {
		rayTracerBase = myRayTracerBase;
		return this;
	}

	/**
	 * set imageWriter
	 * 
	 * @param imageWriter
	 * @return this camera
	 */
	public Camera setImageWriter(ImageWriter myImageWriter) {
		imageWriter = myImageWriter;
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

		Point pC = p0.add(vTo.scale(distance));

		double rY = height / nY;
		double rX = height / nX;

		double yI = -(i - (nY - 1) / 2d) * rY;
		double xJ = (j - (nX - 1) / 2d) * rX;

		Point pIJ = pC;
		if (xJ != 0)
			pIJ = pIJ.add(vRight.scale(xJ));
		if (yI != 0)
			pIJ = pIJ.add(vUp.scale(yI));

		return new Ray(p0, pIJ.subtract(p0));
	}

	/*
	 * Check that all fields were properly initialized,
	 * then create picture. 
	 */
	public Camera renderImage() {
		
		if (width == 0)
			throw new MissingResourceException(
					"fields aren't properly initialized", "Camera", "width");
		if (height == 0)
			throw new MissingResourceException(
					"fields aren't properly initialized", "Camera", "height");
		if (distance == 0)
			throw new MissingResourceException(
					"fields aren't properly initialized", "Camera", "distance");
		if (imageWriter == null)
			throw new MissingResourceException(
					"fields aren't properly initialized", "Camera", "imageWriter");
		if (rayTracerBase == null)
			throw new MissingResourceException(
					"fields aren't properly initialized", "Camera", "rayTracerBase");
		
		int nX = imageWriter.getNx();
		int nY = imageWriter.getNy();
		
		for (int i = 0; i < nY; ++i)
			for (int j = 0; j < nX; ++j)
				imageWriter.writePixel(j, i, castRay(nX, nY, j, i));

		return this;
	}

	/**
	 * create ray and calculate color using ray tracer
	 * 
	 * @param  nX number of pixels (width)
	 * @param  nY number of pixels (length)
	 * @param  j  this pixel(row)
	 * @param  i  this pixel (colomn)
	 * @return color of pixel
	 */
	private Color castRay(int nX, int nY, int j, int i) {	
		Ray ray = constructRay(nX, nY, j, i);
		return rayTracerBase.traceRay(ray);
	}

	public void printGrid(int interval, Color color) {

		if (imageWriter == null)
			throw new MissingResourceException("fields aren't properly initialized", "Camera", "imageWriter");

		int nX = imageWriter.getNx();
		int nY = imageWriter.getNy();

		for (int i = 0; i < nY; ++i)
			for (int j = 0; j < nX; ++j)
				if (j % interval == 0 || i % interval == 0)
					imageWriter.writePixel(j, i, color);
	}

	/*
	 * Activate image writer proper function
	 */
	public void writeToImage() {
		if (imageWriter == null)
			throw new MissingResourceException("image writer is empty", "Camera", "imageWriter");
		imageWriter.writeToImage();
	}

}
