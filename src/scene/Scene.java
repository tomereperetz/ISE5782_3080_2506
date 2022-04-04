/**
 * 
 */
package scene;

import elements.AmbientLight;
import geometries.Geometries;
import primitives.Color;

/**
 * Class Scene is a class representing the scene
 * 
 * @author Nitay Kazimirsky and Tomer Peretz
*/
public class Scene {
	public String name;
	public AmbientLight ambientLight;
	public Geometries geometries = new Geometries();
	
	/**
	 * Constructor to build an empty collection
	 * of geometries
	 * 
	 * @param name of scene 
	 */
	Scene(String name) {
		geometries = new Geometries();
	}
	
	public Color backGround = Color.BLACK;
	/**
	 * @param backGround the backGround to set
	 * @return this scene
	 */
	public Scene setBackGround(Color backGround) {
		this.backGround = backGround;
		return this;
	}

	/**
	 * @param ambientLight the ambientLight to set
	 * @return this scene
	 */
	public Scene setAmbientLight(AmbientLight ambientLight) {
		this.ambientLight = ambientLight;
		return this;
	}

	/**
	 * @param geometries the geometries to set
	 * @return this scene
	 */
	public Scene setGeometries(Geometries geometries) {
		this.geometries = geometries;
		return this;
	}

}
