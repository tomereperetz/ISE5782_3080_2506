/**
 * 
 */
package lighting;

import java.awt.Color;
import java.awt.Point;

import primitives.Vector;

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
