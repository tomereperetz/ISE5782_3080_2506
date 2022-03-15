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
		Triangle triangle = new Triangle(new Point(1, 1, 1), new Point(2, -2, 1),
				new Point(3, 1, 1));
		// ============ Equivalence Partitions Tests ==============	
		//TC01: ray intersects plane in triangle
        assertEquals(new Point(2, 0, 1), triangle.findIntersections(
        		new Ray(new Point(2, 0, 2), new Vector(2, 0, 0))), 
        		"intersection point is in the triangle");
        
        //TC02: ray intersects plane outside the triangle, against edge
        assertEquals(new Point(2, 3, 1), triangle.findIntersections(
        		new Ray(new Point(2, 3, 2), new Vector(2, 3, 0))),
        		"intersection point is outside the triangle, against edge");
        
        //TC03: ray intersects plane outside the triangle, against vertex
        assertEquals(new Point(2, -3, 1), triangle.findIntersections
        		(new Ray(new Point(2, -3, 2), new Vector(2, -3, 0))), 
        		"intersection point is outside the triangle, against vertex");   
        
		// ============ Boundary Values Partitions Tests ==============	
        //TC10: ray intersects plane on edge
        assertEquals(new Point(2, 1, 1), triangle.findIntersections(
        		new Ray(new Point(2, 1, 2), new Vector(2, 1, 0))),
        		"intersection point is on edge");
        
        //TC11: ray intersects plane on vertex
        assertEquals(new Point(3, 1, 1), triangle.findIntersections(
        		new Ray(new Point(3, 1, 2), new Vector(3, 1, 0))), 
        		"intersection point is in the triangle"); 
        
        //TC12: ray intersects plane on edge's continuation
        assertEquals(new Point(3, -5, 1), triangle.findIntersections(
        		new Ray(new Point(3, -5, 0), new Vector(3, -5, 2))), 
        		"intersection point is in the triangle"); 
	}
}
