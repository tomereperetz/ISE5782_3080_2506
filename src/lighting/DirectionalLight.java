/**
 * 
 */
package lighting;

import primitives.*;

/**
 * Class DirectionalLight includes necessary functionality for directional light  
 * 
 * @author Tomer and Nitay
 */
public class DirectionalLight extends Light implements LightSource {
	private final Vector direction;

	/**
	 * @param myIntensity
	 * @param direction
	 */
	public DirectionalLight(Color myIntensity, Vector direction) {
		super(myIntensity);
		this.direction = direction.normalize();
	}
	
	@Override
	public Vector getL(Point p) {
		return direction.normalize();
	}
	
	@Override
	public Color getIntensity(Point p) {
        return intensity;
	}
	
}
