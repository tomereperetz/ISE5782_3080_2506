package unittests.geometries;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import geometries.Plane;
import primitives.Point;
import primitives.Vector;

/**
 * Unit tests for primitives.Plane class
 * 
 * @author Tomer and Nitay
 *
 */
class PlaneTests {
	
	 /**
     * Test method for {@link geometries.Plane#Plane(Point p1, Point p2, Point p3)}.
     */
    @Test
    void testPlane(){
        // =============== Boundary Values Tests ==================
        // Test 01: test 2 point on same spot
        assertThrows(IllegalArgumentException.class,()->new Plane(
                new Point(0, 0, 1),
                new Point(0, 0, 1),
                new Point(0, 1, 0)),
                "constructor for 3 points does not throw an exception in case of 2 identical points");

        // Test 02: test all points on same line
        assertThrows(IllegalArgumentException.class,()->new Plane(
                new Point(1, 1, 1),
                new Point(2, 2, 2),
                new Point(3, 3, 3)),
                "constructor for 3 points does not throw an exception in case of all points on same line");
    }

	//Test method for {@link geometries.Plane#getNormal(primitives.Point)}.
		@Test
		void testGetNormal() {
			// ============ Equivalence Partitions Tests ==============
			// TC01: There is a simple single test here
			double sqrt3 = Math.sqrt(1d / 3);
			Plane p = new Plane(new Point(0, 0, 1),
								new Point(1, 0, 0),
								new Point(0, 1, 0));
			assertEquals(new Vector(sqrt3,sqrt3,sqrt3), p.getNormal(new Point(0, 0, 1)), "Bad normal to plane");
		}
}
