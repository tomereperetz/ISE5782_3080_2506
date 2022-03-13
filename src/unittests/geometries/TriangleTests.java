/**
 * 
 */
package unittests.geometries;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import geometries.Triangle;
import primitives.Point;
import primitives.Vector;

/**
 * Unit tests for primitives.Triangle class
 * 
 * @author Tomer and Nitay
 *
 */
class TriangleTests {

	//Test method for {@link geometries.Triangle#getNormal(primitives.Point)}.
	@Test
	void testGetNormal() {
		// ============ Equivalence Partitions Tests ==============
		// TC01: There is a simple single test here
		double sqrt3 = Math.sqrt(1d / 3);
		Triangle t = new Triangle(new Point(0, 0, 1),
								  new Point(1, 0, 0),
								  new Point(0, 1, 0));
		assertEquals(new Vector(sqrt3,sqrt3,sqrt3), t.getNormal(new Point(0, 0, 1)), "Bad normal to trinagle");
	}

}
