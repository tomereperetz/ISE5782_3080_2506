package primitives;

/**
 * Class Material includes representation and 
 * necessary functionality for different materials
 */
public class Material {
	public Double3 kD = Double3.ZERO;
	public Double3 kS = Double3.ZERO;
	public int nShininess = 0;

	/**
	 * Setter for scalar Kd
	 * 
	 * @param kD the kD to set
	 * @return this material
	 */
	public Material setkd(Double3 kD) {
		this.kD = kD;
		return this;

	}

	/**
	 * Setter for scalar Ks
	 * @param kS the kS to 
	 * @return this material
	 */
	public Material setKs(Double3 kS) {
		this.kS = kS;
		return this;
	}

	/**
	 * Setter for shininess
	 * @param nShininess the nShininess to set
	 * @return this material
	 */
	public Material setShininess(int nShininess) {
		this.nShininess = nShininess;
		return this;
	}

	/**
	 * Setter for scalar Kd
	 * @param kD the kD to set
	 * @return this material
	 */
	public Material setKd(Double kD) {
		this.kD = new Double3(kD);
		return this;

	}

	/**
	 * Setter for scalar Ks 
	 * @param kS the kS to set
	 * @return this material
	 */
	public Material setKs(Double kS) {
		this.kS = new Double3(kS);
		return this;
	}
}
