/**
 * 
 */
package lighting;

import primitives.*;

/**
 * 
 * 
 * @author nitay and tomer
 */
public interface LightSource {
	/**
	 * 
	 * @param p
	 * @return
	 */
	public Color getIntensity(Point p);
	
	/**
	 * 
	 * @param p
	 * @return
	 */
	public Vector getL(Point p);
}
