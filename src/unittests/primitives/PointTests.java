package unittests.primitives;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import primitives.Point;
import primitives.Vector;

/**
 * Unit tests for primitives.Point class
 * 
 * @author Tomer and Nitay
 *
 */
class PointTests {
	
	/**
	 * Test method for {@link primitives.Point#squaresDistance(primitives.Point)}.
	 */
	@Test
	public void testDistancesquared() {
		// ============= Equivalence Partitions Tests ==============
		// TC01: Only one simple test
		Point p1 = new Point(1, 2, 3);
		Point p2 = new Point(4, 5, 6);
		assertEquals("ERROR: squared distance isn't proper", p1.distanceSquared(p2),
				27, 0.00001);
		
	}
	
	/**
	 * Test method for {@link primitives.Point#add(primitives.Point)}.
	 */
	@Test
	public void testAdd() {
		// ============= Equivalence Partitions Tests ==============
		// TC01: Only one simple test
		Point p1 = new Point(1, 2, 3);
		Vector v1 = new Vector(-1, -2, -3);
		assertEquals("ERROR: add point to vector isn't proper", p1.add(v1), new Point(0, 0, 0));
		
	}

	/**
	 * Test method for {@link primitives.Point#subtract(primitives.Point)}.
	 */
	@Test
	public void testSubtract() {
		// ============= Equivalence Partitions Tests ==============
		// TC01: Only one simple test
		Point p1 = new Point(1, 2, 3);
		Point p2 = new Point(0, 1, 2);
		assertEquals("ERROR: subtruct point from vector isn't proper", p1.subtract(p2), new Vector(1, 1, 1));
	}
	
}
