package unittests.geometries;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import geometries.Tube;
import primitives.*;


/**
 * Unit tests for primitives.Tube class
 * 
 * @author Tomer and Nitay
 *
 */
class TubeTests {
//	@Test
//	void testGetNormal() {
//		// ============ Equivalence Partitions Tests ==============
//		// TC01: There is a simple single test here
//		Tube t = new Tube(new Ray(new Point(0, 0, -1), new Vector(0, 0, 1)), 1);
//		Vector v  = new Point(1, 0, 2).subtract(new Point(0, 0, 1));
//		Vector normal = v.normalize();
//		assertEquals(normal, t.getNormal(new Point(1, 0, 2)), "Bad normal to tube");
//	
//		// ============ Boundary Values Tests ==============
//		// TC10: Test normal when connecting the head of the axis ray and the point
//		// creates a 90 degrees angle with the axis ray
//		Vector v2 = new Point(0, 1, 1).subtract(new Point(0, 0, 1)).normalize();
//		assertEquals(t.getNormal(new Point(0, 1, 1)),v2, "Bad normal to tube (orthogonal)");
//	}
    /**
     * Test method for {@link geometries.Tube#getNormal(primitives.Point3D)}.
     */
    @Test
    void testGetNormal() {
        // ============ Equivalence Partitions Tests ==============
        //test normal for point on tube
        Tube tb = new Tube(new Ray(new Point(1,0,0),new Vector(0,1,0)), 1);
        Vector temp=tb.getNormal(new Point(2,1,0));
        assertEquals(temp,new Vector(1,0,0),"getNormal() is bad");

        // =============== Boundary Values Tests ==================
        tb = new Tube(new Ray(new Point(1,0,0),new Vector(0,1,0)), 1);
        temp=tb.getNormal(new Point(2,0,0));
        assertEquals(temp,new Vector(1,0,0),"getNormal() for point on base rim is bad");
    }
}
