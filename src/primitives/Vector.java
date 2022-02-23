package primitives;

/**
 * Class Vector is the basic class representing vector of Euclidean geometry in Cartesian
 * 3-Dimensional coordinate system.
 * @author Nitay Kazimirsky and Tomer Peretz
*/
public class Vector extends Point {
	
	public Vector(Double3 myXyz) {
		//if(myXyz.d1 != 0 && myXyz.d2 != 0 && myXyz.d3 != 0)
			super(myXyz);
		//else
			//throw new IllegalArgumentException("zero vector is not allowed");
	}
	
	public Vector(double c1, double c2, double c3) {
		super(c1,c2,c3);
	}

	public Double3 getXyz() {
		return xyz;
	}
		
	public boolean equals(Object obj) {
		return super.equals(obj);
	}
	
	@Override
	public String toString() {
		return "(" + getXyz().d1 + ", " + getXyz().d2 + ", " + getXyz().d3 + ")";
	}
	
	public Vector add(Vector v) {
		Vector myVector = new Vector(v.getXyz().add(this.getXyz()));
		return myVector;
	}
	
	public Vector substruct(double scalar) {
		return new Vector(this.getXyz().scale(scalar));
	}
	
	public Vector crossProduct(Vector v) {
		Double3 myXyz = new Double3(this.getXyz().d2 * v.getXyz().d3 - this.getXyz().d3 * v.getXyz().d2,
				this.getXyz().d3 * v.getXyz().d1 - this.getXyz().d1 * v.getXyz().d3, this.getXyz().d1 * v.getXyz().d2 - this.getXyz().d2 * v.getXyz().d1);
		return new Vector(myXyz);
	}
	
	public double lengthSquared() {
		return this.getXyz().d1 * this.getXyz().d1 + this.getXyz().d2 * this.getXyz().d2 + this.getXyz().d3 * this.getXyz().d3;
	}
	
	public double length() {
		return Math.sqrt(this.lengthSquared());
	}
	
	public Vector normalize() {
		return new Vector(this.getXyz().reduce(this.length()));
	}
	
	public double dotProduct(Vector v) {
		Vector myVector = new Vector(this.getXyz().product(v.getXyz()));
		return myVector.getXyz().d1 + myVector.getXyz().d2 + myVector.getXyz().d3;
	}
	
}
