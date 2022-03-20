/**
 * 
 */
package unittests.geometries;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import geometries.Triangle;
import primitives.Point;
import primitives.Ray;
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
	
	//Test method for {@link geometries.Triangle#findIntersectiona(primitives.Point)}.
	@Test
	void testFindIntersections() {
		Triangle triangle = new Triangle(new Point(2, 0, 0), new Point(0, 2, 0),
				new Point(2, 2, 2));
		// ============ Equivalence Partitions Tests ==============	
		//TC01: ray intersects plane in triangle
        //assertEquals(new Point(0.25, 0.25, 0.5), triangle.findIntersections(
        		//new Ray(new Point(2, 2, 0), new Vector(-1.5, -1.5, 1))), 
        		//"intersection point is in the triangle");
        
        //TC02: ray intersects plane outside the triangle, against edge
        assertNull(triangle.findIntersections(
        		new Ray(new Point(1, 1, -1), new Vector(1, 3, 2))),
        		"wrong number of points");
        
        //TC03: ray intersects plane outside the triangle, against vertex
        assertNull(triangle.findIntersections
        		(new Ray(new Point(2, 1, -1), new Vector(0, 2, 1))), 
        		"intersection point is outside the triangle, against vertex");   
        
		// ============ Boundary Values Partitions Tests ==============	
        //TC10: ray intersects plane on edge
        assertNull(triangle.findIntersections(
        		new Ray(new Point(2, 0, -1), new Vector(0, 1, 1))),
        		"WRONG NUMBER OF POINTS");
        
        //TC11: ray intersects plane in vertex
        //assertEquals(triangle.findIntersections(
        		//new Ray(new Point(1, 0, -1), new Vector(0, 1, 1))), 
        		//"WRONG NUMBER OF POINTS"); 
        
        //TC12: ray intersects plane on edge's continuation
        assertNull(triangle.findIntersections(
        		new Ray(new Point(0, 0, -1), new Vector(0, 1, 1))), 
        		"intersection point is in the triangle"); 
	}
}
