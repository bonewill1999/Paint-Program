package ca.utoronto.utm.paint;


/*
 * This is an object that represents whether a shape should be filled 
 */
public class Fill {

	private boolean state;

	/*
	 * Constructor for creating a new fill object for a shape 
	 */
	public Fill() {
		this.state = false;
	}

	/**
	 * When called on, it changes if the it is filled or not.
	 * Meaning if it was filled from before, it will no longer be filled
	 * and if it was not filled from before, it will now be filled.
	 */
	public void changeState() {
		this.state ^= true;
	}

	/**
	 * Returns if the shape will be filled or not.
	 * 
	 * @return true if it is filled, false if it is not. 
	 */
	public boolean getFill() {
		return this.state;
	}

}
