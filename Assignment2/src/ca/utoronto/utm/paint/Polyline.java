package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/*
 * Class for creating a Polyline and accessing polyline's variable
 */
public class Polyline implements Drawable {

	double[] x;
	double[] y;
	int n = 0;
	Color color;
	double lineThickness;

	/*
	 * Constructor for Polyline
	 * 
	 * @param x Takes an Array of double of where mouse was clicked
	 * 
	 * @param y Takes an Array of double of where mouse was clicked
	 * 
	 * @param amount Takes how many points there are total
	 * 
	 * @param color Takes the current user selected color
	 */
	public Polyline(double[] x, double[] y, int amount, Color color) {
		this.x = x;
		this.y = y;
		this.n = amount;
		this.color = color;
	}

	/*
	 * Return the current selected color for Polyline
	 * 
	 * @return The current color of Polyline
	 */
	public Color getColor() {
		return color;
	}

	/*
	 * Sets the lineThickness of the current Polyline
	 * 
	 * @param lineThickness Takes in a double value of how thick the line shouild be
	 */
	public void setLineWidth(double lineThickness) {
		this.lineThickness = lineThickness;
	}

	/*
	 * Return the double Array of x-coordinates
	 */
	public double[] getX() {
		return x;
	}

	/*
	 * Return the double Array of y-coordinates
	 */
	public double[] getY() {
		return y;
	}

	/*
	 * Get the current set Linethickness of the Polyline
	 * 
	 * @return The double value of the current linethickness
	 */
	public double getLineThickness() {
		return lineThickness;
	}

	/**
	 * Draws a polyline based on its various specifications
	 */
	@Override
	public void draw(GraphicsContext g) {
		g.setLineWidth(this.getLineThickness());
		g.setStroke(this.getColor());
		g.strokePolyline(x, y, n);
	}
}
