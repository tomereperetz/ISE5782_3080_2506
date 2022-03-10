/**
 * 
 */
package unittests.primitives;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static primitives.Util.isZero;

import org.junit.jupiter.api.Test;

import primitives.Vector;

/**
 * Unit tests for primitives.Vector class
 * 
 * @author Tomer and Nitay
 *
 */
public class VectorTests {

	/**
	 * Test method for {@link primitives.Vector#scale(double)}.
	 */
	@Test
	public void testScale() {
        // ============ Equivalence Partitions Tests ==============
		Vector v1 = new Vector(1, 2, 3);
		double scalar = 3.5;
		Vector v2 = new Vector(3.5,7,10.5);
        // TC01: Test that vector scale is proper
		assertEquals("ERROR: vector scale wrong value", v1.scale(scalar), v2);
	}

	/**
	 * Test method for {@link primitives.Vector#crossProduct(primitives.Vector)}.
	 */
	@Test
	public void testCrossProduct() {
		Vector v1 = new Vector(1, 2, 3);
		
        // ============ Equivalence Partitions Tests ==============
        Vector v2 = new Vector(0, 3, -2);
        Vector vr = v1.crossProduct(v2);

        // TC01: Test that length of cross-product is proper (orthogonal vectors taken
        // for simplicity)
        assertEquals("crossProduct() wrong result length", v1.length() * v2.length(), vr.length(), 0.00001);

        // TC02: Test cross-product result orthogonality to its operands
        assertTrue("crossProduct() result is not orthogonal to 1st operand", isZero(vr.dotProduct(v1)));
        assertTrue("crossProduct() result is not orthogonal to 2nd operand", isZero(vr.dotProduct(v2)));

        // =============== Boundary Values Tests ==================
        // TC11: test zero vector from cross-product of co-lined vectors
        Vector v3 = new Vector(-2, -4, -6);
        assertThrows("crossProduct() for parallel vectors does not throw an exception",
                IllegalArgumentException.class, () -> v1.crossProduct(v3));
    }

	/**
	 * Test method for {@link primitives.Vector#lengthSquared()}.
	 */
	@Test
	public void testLengthSquared() {	
		// ============ Equivalence Partitions Tests ==============
		Vector v = new Vector(1, 2, 3);
		// TC01: Test that squared length of vector is proper
		assertEquals("ERROR: lengthSquared() wrong value", v.lengthSquared(), 14, 0.00001);
	}

	/**
	 * Test method for {@link primitives.Vector#length()}.
	 */
	@Test
	public void testLength() {
		// ============ Equivalence Partitions Tests ==============
		Vector v = new Vector(0, 3, 4);
		// TC01: Test that length of vector is proper
		assertTrue("ERROR: lengthSquared() wrong value", !isZero(v.length() - 5));
	}

	/**
	 * Test method for {@link primitives.Vector#normalize()}.
	 */
	@Test
	public void testNormalize() {
		// ============= Equivalence Partitions Tests ==============
		Vector v1 = new Vector(1, 2, 3);
		Vector v2 = v1.normalize();
		
		// TC01: Test if normalized vector's length is 1
		assertTrue("ERROR: the normalized vector is not a unit vector", isZero(v2.length() - 1));
	
		// TC02: Test if normalized vector and original vector are parallel
		assertThrows(IllegalArgumentException.class, () -> v1.crossProduct(v2),
			"ERROR: the normalized vector is not parallel to the original one");
		
		// TC03: Test if both vectors are at the same direction
		assertTrue("ERROR: the normalized vector is opposite to the original one", v1.dotProduct(v2) < 0);
	}

	/**
	 * Test method for {@link primitives.Vector#dotProduct(primitives.Vector)}.
	 */
	@Test
	public void testDotProduct() {
		// ============ Equivalence Partitions Tests ==============
		Vector v1 = new Vector(1, 2, 3);
		Vector v2 = new Vector(-2, -4, -6);
		Vector v3 = new Vector(0, 3, -2);
		// TC01: Test that dot product is proper for orthogonal vectors
		assertTrue("ERROR: dotProduct() for orthogonal vectors is not zero", !isZero(v1.dotProduct(v3)));
		
		// TC02: Test that dot product is proper for not orthogonal vectors
		assertTrue("ERROR: dotProduct() wrong value", !isZero(v1.dotProduct(v2) + 28));
	}

}
