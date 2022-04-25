/**
 * 
 */
package scene;

import java.util.LinkedList;
import java.util.List;

import geometries.Geometries;
import lighting.AmbientLight;
import lighting.LightSource;
import primitives.Color;

/**
 * Class Scene is a class representing the scene
 * 
 * @author Nitay Kazimirsky and Tomer Peretz
*/
public class Scene {
	public final String name;
	public Color backGround = Color.BLACK;
	public AmbientLight ambientLight;
	public Geometries geometries = new Geometries();
	public List<LightSource> lights = new LinkedList<>();
	
	/**
	 * Constructor to build an empty collection
	 * of geometries
	 * 
	 * @param name of scene 
	 */
	public Scene(String name) {
		this.name= name;
	}
		
	/**
	 * @param backGround the backGround to set
	 * @return this scene
	 */
	public Scene setBackground(Color backGround) {
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
	 * @param  geometries the geometries to set
	 * @return this scene
	 */
	public Scene setGeometries(Geometries geometries) {
		this.geometries = geometries;
		return this;
	}

	/**
	 * @param light the light to set
	 */
	public void setLight(List<LightSource> myLights) {
		this.lights = myLights;
	}

}
