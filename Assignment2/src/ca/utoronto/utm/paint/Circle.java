package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/*
 * A circle class that are used to create circle and access some of its properties
 */
public class Circle implements Drawable {

	private Point centre;
	private int radius;
	private Color color;
	private boolean fill;
	private double lineThickness;

	/**
	 * Circle's constructor for initializing a circle 
	 * 
	 * @param centre Where the centre of the circle is
	 * 
	 * @param radius Takes in the radius that the user desires 
	 * 
	 * @param fill Either true or false to indicate whether or not to fill the circle
	 * 
	 * @param color Takes in the color that user desire
	 */
	public Circle(Point centre, int radius, boolean fill, Color color) {
		this.centre = centre;
		this.radius = radius;
		this.fill = fill;
		this.color = color;
	}
	/**
	 * Returns the center of the circle 
	 * 
	 * @return the variable this.centre
	 */
	public Point getCentre() {
		return centre;
	}

	/**
	 * Changes the centre to the centre entered
	 * 
	 * @param centre will be what this.centre is set to
	 */
	public void setCentre(Point centre) {
		this.centre = centre;
	}
   
	/**
	 * Returns the radius of the circle. 
	 * 
	 * @return the variable this.radius
	 */
	public int getRadius() {
		return radius;
	}

	/**
	 * Changes the radius of the circle to the radius entered
	 * 
	 * @param radius will be what this.radius will be set to.
	 */
	public void setRadius(int radius) {
		this.radius = radius;
	}


	public void setColor(Color c) {
		this.color = c;
	}

	/**
	 * Sets the thickness of the circle to the lineThickness entered
	 * 
	 * @param lineThickness will be what this.lineThickness will be set to.
	 */

	public void setLineThickness(double lineThickness) {
		this.lineThickness = lineThickness;
	}

	/**
	 * Returns the color of the circle
	 * 
	 * @return the variable this.color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Returns whether or not the circle is filled
	 * 
	 * @return true if fill, false otherwise
	 */
	public boolean getFill() {
		return fill;
	}

	/**
	 * Returns how thick the circle is 
	 * 
	 * @return the variable this.lineThickness
	 */
	public double getLineThickness() {
		return lineThickness;
	}

	/**
	 * Draws the circle based on its various specifications
	 */
	@Override
	public void draw(GraphicsContext g) {
		int x = this.getCentre().getX();
		int y = this.getCentre().getY();
		int radius = this.getRadius();
		g.setStroke(this.getColor());
		g.setLineWidth(this.getLineThickness());

		if (this.getFill() == false) {
			g.strokeOval(x - radius, y - radius, radius * 2, radius * 2);
		} else if (this.getFill() == true) {
			g.setFill(this.getColor());
			g.fillOval(x - radius, y - radius, radius * 2, radius * 2);
		}
	}
}
