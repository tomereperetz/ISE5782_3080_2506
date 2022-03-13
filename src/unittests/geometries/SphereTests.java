/**
 * 
 */
package unittests.geometries;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import geometries.Sphere;
import primitives.Point;
import primitives.Vector;

/**
 * Unit tests for primitives.Sphere class
 * 
 * @author Tomer and Nitay
 *
 */
class SphereTests {

	/**
	 * Test method for {@link geometries.Sphere#getNormal(primitives.Point)}.
	 */
	@Test
	void testGetNormal() {
		// ============ Equivalence Partitions Tests ==============
		// TC01: There is a simple single test here
		Sphere s = new Sphere(new Point(0, 0, 0), 1);
		// the normal vector should be (0,0,1) - self calculation
		assertEquals(new Vector(0,0,1).normalize(), 
					 s.getNormal(new Point(0, 0, 1)),
				     "Bad normal to sphere");
	}

}
