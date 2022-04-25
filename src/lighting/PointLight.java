/**
 * 
 */
package lighting;

import primitives.Color;
import primitives.Point;
import primitives.Vector;

/**
 * Class PointLight includes necessary functionality for point light
 * 
 * @author Tomer and Nitay
 */
public class PointLight extends Light implements LightSource {
	private final Point position;
	private double kC = 1;
	private double kL = 0;
	private double kQ = 0;
	
	/**
	 * Constructs point light's intensity and position
	 * 
	 * @param myIntensity
	 * @param position
	 */
	public PointLight(Color myIntensity, Point position) {
		super(myIntensity);
		this.position = position;
	}
	
	@Override
	public Vector getL(Point p) {
        return p.subtract(position).normalize();
	}
	
	@Override
	public Color getIntensity(Point p) {
		double denominator, distance;
		distance = position.distance(p);
		denominator = kC + kL * distance + kQ * distance * distance;
		return getIntensity().reduce(denominator);
	}
	
	/**
	 * Setter for scalar Kc
	 * 
	 * @param kC the kC to set
	 * @return updated point light itself
	 */
	public PointLight setKc(double kC) {
		this.kC = kC;
		return this;
	}
	
	/**
	 * Setter for scalar Kl
	 * 
	 * @param kL the kL to set
	 * @return updated point light itself
	 */
	public PointLight setKl(double kL) {
		this.kL = kL;
		return this;
	}
	
	/**
	 * Setter for scalar Kq
	 * 
	 * @param kQ the kQ to set
	 * @return updated point light itself
	 */
	public PointLight setKq(double kQ) {
		this.kQ = kQ;
		return this;
	}

}
