/**
 * 
 */
package elements;

import primitives.Color;
import primitives.Double3;

/**
 * Class AmbientLoght is a class representing the ambient light
 * of our scene
 * 
 * @author Nitay Kazimirsky and Tomer Peretz
*/
public class AmbientLight {
	
	private Color intensity;

	/**
	 * Constructor to initialize intensity field
	 * according to given formula
	 * 
	 * @param iA original light
	 * @param kA discount factor
	 */
	AmbientLight(Color iA, Double3 kA){
		intensity = iA.scale(kA);
	}
	
	/**
	 * Default constructor to initialize intensity field
	 * to black
	 * 
	 */	
	AmbientLight() {
		intensity = Color.BLACK;
	}
	
	/**
	 * get intensity of light
	 * 
	 * @return intensity
	 */
	public Color getIntensity() {
		return intensity;
	}
}
