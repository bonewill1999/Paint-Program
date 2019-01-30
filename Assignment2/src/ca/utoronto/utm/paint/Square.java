package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/*
 * A square class that are used to create Square and access some of its properties
 */
public class Square implements Drawable {

	private Point cornorInit;
	private double width;
	private Color color;
	private boolean fill;
	private double lineThickness;
	private double height;

	/*
	 * Square's constructor for initializing a square
	 * 
	 * @param CornorInitial Takes in a Point of the first mouse click
	 * 
	 * @param width Takes in the width from initial point to where the mouse dragged
	 * 
	 * @param color Takes in the color that user desire
	 * 
	 * @param fill Either true or false to indicate whether or not to fill the
	 * square
	 */
	public Square(Point CornorInitial, double width, Color color, boolean fill) {
		this.cornorInit = CornorInitial;
		this.width = width;
		this.color = color;
		this.fill = fill;
	}

	/*
	 * Returns the point of the first click
	 * 
	 * @return The initial point of the square that a user clicked on
	 */
	public Point getCornorInit() {
		return cornorInit;
	}

	/*
	 * Set the corner with Point
	 *
	 * @param CornorInit Takes a Point
	 */
	public void setCornorInit(Point CornorInit) {
		this.cornorInit = CornorInit;
	}

	/*
	 * Return the width from initial mouse click to user dragged
	 * 
	 * @return Return the current width of the square
	 */
	public double getwidth() {
		return width;
	}

	/*
	 * Return the height from initial mouse click to user dragged
	 * 
	 * @return Return the current height of the square
	 */
	public double getHeight() {
		return height;
	}

	/*
	 * Sets the height for the current square
	 * 
	 * @param height Takes in an integer value
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	/*
	 * Sets the width for the current square
	 * 
	 * @param width Takes in a double value
	 */
	public void setWidth(double width) {
		this.width = width;
	}

	/*
	 * Sets the linethickness of the current square
	 * 
	 * @param lineThickness Takes in a double value
	 */
	public void setLineThickness(double lineThickness) {
		this.lineThickness = lineThickness;
	}

	/*
	 * Gives the current color that the user selected
	 * 
	 * @return The current color selected
	 */
	public Color getColor() {
		return color;
	}

	/*
	 * Gives the boolean of whether to fill or not
	 * 
	 * @return A boolean value of whether to fill or not
	 */
	public boolean getFill() {
		return fill;
	}

	/*
	 * Return the current selected linethickness for the square
	 * 
	 * @return The lineThickness for the square
	 */
	public double getLineThickness() {
		return lineThickness;
	}

	
	/**
	 * Draws the square based on its various specifications
	 */
	@Override
	public void draw(GraphicsContext g) {
		double x = this.getCornorInit().getX();
		double y = this.getCornorInit().getY();
		double w = this.getwidth();
		double h = this.getHeight();
		if (h < 0) {
			h = Math.abs(h);
			y = y - h;
		}
		;
		if (w < 0) {
			x = x - h;
		}
		;
		g.setLineWidth(this.getLineThickness());

		if (this.getFill() == false) {
			g.strokeRect(x, y, h, h);

		} else if (this.getFill() == true) {
			// g.fillOval(x, y, radius, radius);
			g.setFill(this.getColor());
			g.fillRect(x, y, h, h);
		}

		g.setStroke(this.getColor());
		g.strokeRect(x, y, h, h);
	}

}
