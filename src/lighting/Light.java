/**
 * 
 */
package lighting;

import primitives.*;

/**
 * @author tomer and nitay
 *
 */
abstract class Light {
	protected final Color intensity;

	/**
	 * @param intensity
	 */
	protected Light(Color myIntensity) {
		intensity = myIntensity;
	}

	/**
	 * @return the intensity
	 */
	public Color getIntensity() {
		return intensity;
	}
	
}
