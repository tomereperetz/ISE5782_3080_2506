/**
 * 
 */
package unittests.primitives;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import primitives.*;

/**
 * 
 * Unit tests for primitives.Ray class
 * 
 * @author nitay and tomer
 *
 */
public class RayTests {
	/**
	 * Test method for {@link primitives.Ray#getPoint(double)}.
	 */
	@Test
	public void testGetPoint() {
		Ray ray = new Ray(new Point(1, 1, 1), new Vector(0, 3, 4));
		// ============= Equivalence Partitions Tests ==============

		// TC01: scalar t is positive
		assertEquals(new Point(1,1.3,1.4), ray.getPoint(0.5), "get ray isn't proper");
		
		// TC02: scalar t is positive
		assertEquals(new Point(1,0.7,0.6), ray.getPoint(-0.5), "get ray isn't proper");


		// ============= Boundary Values Tests ==============

		// TC10: scalar t is zero
		assertEquals(new Point(1, 1, 1), ray.getPoint(0), "get ray isn't proper");
	}

}
