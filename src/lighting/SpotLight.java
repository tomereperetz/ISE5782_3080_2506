/**
 * 
 */
package lighting;

import primitives.*;
import static primitives.Util.*;

/**
 * @author tomer
 *
 */
public class SpotLight extends PointLight {
	private final Vector direction;

	/**
	 * @param myIntensity
	 * @param position
	 * @param direction
	 */
	public SpotLight(Color myIntensity, Point position, Vector direction) {
		super(myIntensity, position);
		this.direction = direction.normalize();
	}

	/**
	 * Calculates the intensity at the point where the light arrived
	 * 
	 * @param p the point of the shape
	 * @return intensity at the point
	 */
	public Color getIntensity(Point p) {
		double cosTheta = alignZero(direction.dotProduct(getL(p)));
		return cosTheta <= 0 ? Color.BLACK : super.getIntensity(p).scale(cosTheta);
	}
}
