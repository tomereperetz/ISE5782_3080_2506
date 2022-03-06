package primitives;

/**
 * Class Vector is the basic class representing vector of Euclidean geometry in Cartesian
 * 3-Dimensional coordinate system.
 * @author Nitay Kazimirsky and Tomer Peretz
*/
public class Vector extends Point {
	
	/**
	 * Constructor to initialize Vector based object with its values
	 * 
	 * @param myXyz
	 */
	public Vector(Double3 myXyz) throws IllegalArgumentException {
		super(myXyz);
		if(myXyz.equals(Double3.ZERO))
			throw new IllegalArgumentException("zero vector is not allowed");
	}
	
	/**
	 * Constructor to initialize Vector based object with its values
	 * @param c1
	 * @param c2
	 * @param c3
	 */
	public Vector(double c1, double c2, double c3) throws IllegalArgumentException {
		super(c1,c2,c3);
		Double3 tmpXyz = new Double3(c1, c2, c3);
		if(tmpXyz.equals(Double3.ZERO))
			throw new IllegalArgumentException("zero vector is not allowed");
	}
	
	/**
	 * get vector's head point
	 * @return Double3 class performance 
	 */
	public Double3 getXyz() {
		return xyz;
	}
	
	@Override
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	@Override
	public String toString() {
		return "(" + getXyz().d1 + ", " + getXyz().d2 + ", " + getXyz().d3 + ")";
	}
	
	/**
	 * adds two vectors and returns the result
	 * @return vector
	 */
	@Override
	public Vector add(Vector v) {
		Vector myVector = new Vector(v.getXyz().add(this.getXyz()));
		return myVector;
	}
	
	/**
	 * receives a scalar and multiplies the scalar by each coordinate of the vector
	 * 
	 * @param scalar
	 * @return
	 */
	public Vector scale(double scalar) {
		return new Vector(this.getXyz().scale(scalar));
	}
	
	/**
	 * receives vector and multiples it with our vector.
	 * @param v vector 
	 * @return new vector
	 */
	public Vector crossProduct(Vector v) {
		Double3 myXyz = new Double3(this.getXyz().d2 * v.getXyz().d3 - this.getXyz().d3 * v.getXyz().d2,
									this.getXyz().d3 * v.getXyz().d1 - this.getXyz().d1 * v.getXyz().d3,
									this.getXyz().d1 * v.getXyz().d2 - this.getXyz().d2 * v.getXyz().d1);
		return new Vector(myXyz);
	}
	
	/**
	 * calculates vector's length squared
	 * @return
	 */
	public double lengthSquared() {
		return this.getXyz().d1 * this.getXyz().d1 +
			   this.getXyz().d2 * this.getXyz().d2 +
			   this.getXyz().d3 * this.getXyz().d3;
	}
	
	/**
	 * calculates vector's length
	 * @return
	 */
	public double length() {
		return Math.sqrt(this.lengthSquared());
	}
	
	/**
	 * receives vector and normalizes it.
	 * @return normalizes Vector
	 */
	public Vector normalize() {
		return new Vector(this.getXyz().reduce(this.length()));
	}
	
	/**
	 * receives vector and returns the scalar multiply operator result
	 * @param v
	 * @return double
	 */
	public double dotProduct(Vector v) {
		Vector myVector = new Vector(this.getXyz().product(v.getXyz()));
		return myVector.getXyz().d1 + myVector.getXyz().d2 + myVector.getXyz().d3;
	}
	
}
