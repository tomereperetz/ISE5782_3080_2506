/**
 * 
 */
package unittests.renderer;

import static java.awt.Color.*;
import primitives.*;

import org.junit.jupiter.api.Test;

/**
* Testing basic image building
* 
* @author Nitay and Tomer
* 
*/
public class ImageWriterTests {	
	/**
	 * Test method for {@link renderer.ImageWriter#WriteToImage(int, int, Color)}.
	 */
	@Test
	public void testWriteToImage() {
		renderer.ImageWriter myIW = new renderer.ImageWriter(
				"test image", 800, 500);
	
		Color color1 = new Color(BLUE);
		Color color2 = new Color(GREEN);
		for (int i = 0; i < 800; ++i)
			for (int j = 0; j < 500; ++j)
				if (i % 10 == 0)
					myIW.writePixel(i, j, color2);
				else
					myIW.writePixel(i, j, color1);
		myIW.writeToImage();
	}
}