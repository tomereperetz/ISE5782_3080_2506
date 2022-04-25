/**
 * 
 */
package lighting;

import primitives.*;

/**
 * Interface LightSource includes necessary functionality for light source 
 * 
 * @author Nitay and Tomer
 */
public interface LightSource {
	/**
	 * getter for intensity
	 * @param p point
	 * @return Color intensity of color
	 */
	public Color getIntensity(Point p);
	
	/**
	 * getter for vector 
	 * @param  p point
	 * @return Vector 
	 */
	public Vector getL(Point p);
}
