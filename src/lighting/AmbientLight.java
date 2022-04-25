/**
 * 
 */
package lighting;

import primitives.Color;
import primitives.Double3;

/**
 * Class AmbientLoght is a class representing the ambient light
 * of our scene
 * 
 * @author Nitay Kazimirsky and Tomer Peretz
*/
public class AmbientLight extends Light {
	
	/**
	 * Constructor to initialize color 
	 * according to given formula
	 * 
	 * @param iA original light
	 * @param kA discount factor
	 */
	public AmbientLight(Color iA, Double3 kA){
		super(iA.scale(kA));
	}

	/**
	 * Constructs ambient light with complete darkness
	 */	
	AmbientLight() {
		super(Color.BLACK);
	}

}
