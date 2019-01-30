package ca.utoronto.utm.paint;

/**
 * This is an object that represents how thick a shape outline should be
 */
public class Thickness {

	private double thick;

	/**
	 * Constructor for creating a new thickness object for a shape 
	 * Sets the default thickness to 2. 
	 */
	public Thickness() {
		this.thick = 2;
	}

	/**
	 * Returns the thickenss of the shape
	 * 
	 * @return the variable this.thick
	 */
	public double getThickness() {
		return this.thick;
	}

	/**
	 * Sets the thickness to what is entered (thickness)
	 * 
	 * @param thickness is what this.thick will be set to
	 */
	public void setThickness(double thickness) {
		this.thick = thickness;
	}

}
