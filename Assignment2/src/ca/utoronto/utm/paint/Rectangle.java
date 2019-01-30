package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Represents the class for a rectangle shape Implements the Drawable interface
 * Rectangles are created with a width and height for their sizing They are also
 * given a color and linThickness for more detailed drawing They are also
 * created with a fill boolean to represent whether the rectangle is filled in
 * Rectangles are also given a point to represent the corner at which the
 * rectangle starts from
 * 
 * @author Facebook Paint LLC
 *
 */

public class Rectangle implements Drawable {

	private Point bottomcorner;
	private int width;
	private int height;
	private Color color;
	private boolean fill;
	private double lineThickness;

	/**
	 * Initializes the created rectangle with its height, width, color, fill and
	 * bottom corner
	 * 
	 * @param bottomcorner the point at which the rectangle starts
	 * @param width        the value of the width for the rectangle
	 * @param height       the value of the height for the rectangle
	 * @param color        the color of the rectangle
	 * @param fill         whether or not the rectangle is filled in
	 */

	public Rectangle(Point bottomcorner, int width, int height, Color color, boolean fill) {
		this.bottomcorner = bottomcorner;
		this.width = width;
		this.height = height;
		this.color = color;
		this.fill = fill;
	}


	/**
	 * Gets the bottom corner point at which the rectangle starts
	 * 
	 * @return returns the point at which the rectangle starts
	 */
	public Point getBottomCorner() {
		return bottomcorner;
	}


	/**
	 * Sets the bottom corner point at which the rectangle starts
	 * 
	 * @param bottomcorner the point at which the bottom corner of the rectangle
	 *                     will be set to
	 */
	public void setBottomCorner(Point bottomcorner) {
		this.bottomcorner = bottomcorner;
	}

	
	/**
	 * Gets the value of the width of the rectangle
	 * 
	 * @return returns the integer value of the width of the rectangle
	 */
	public int getwidth() {
		return width;
	}

	
	/**
	 * Sets the value of the width of the rectangle
	 * 
	 * @param width the integer value of the width to assign to the rectangle
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	
	/**
	 * Gets the value of the height of the rectangle
	 * 
	 * @return returns the integer value of the height of the rectangle
	 */
	public int getHeight() {
		return height;
	}

	
	/**
	 * Sets the value of the height of the rectangle
	 * 
	 * @param height the integer value of the height to assign to the rectangle
	 */
	public void setHeight(int height) {
		this.height = height;
	}

	
	/**
	 * Sets the value of the line thickness of the rectangle
	 * 
	 * @param lineThickness the integer value of the line Thickness to assign to the
	 *                      rectangle
	 */
	public void setLineThickness(double lineThickness) {
		this.lineThickness = lineThickness;
	}

	
	/**
	 * Gets the color of the rectangle
	 * 
	 * @return returns the color of the rectangle
	 */
	public Color getColor() {
		return color;
	}

	
	/**
	 * Gets whether or not the rectangle is filled in
	 * 
	 * @return returns a boolean value for whether or not the rectangle is filled
	 */
	public boolean getFill() {
		return fill;
	}

	/**
	 * Gets the value of the line thickness of the rectangle
	 * 
	 * @return returns the integer value of the line Thickness of the rectangle
	 */
	public double getLineThickness() {
		return lineThickness;
	}

	
	/**
	 * Draws the rectangle based on its various specifications
	 * 
	 * @param g the graphics context in which the rectangle is drawn in
	 */
	@Override
	public void draw(GraphicsContext g) {
		int x = this.getBottomCorner().getX();
		int y = this.getBottomCorner().getY();
		int w = this.getwidth();
		int h = this.getHeight();
		if (w < 0) {
			w = Math.abs(w);
			x = x - w;
		}
		;
		if (h < 0) {
			h = Math.abs(h);
			y = y - h;
		}
		;
		g.setLineWidth(this.getLineThickness());

		if (this.getFill() == false) {
			g.strokeRect(x, y, w, h);

		} else if (this.getFill() == true) {
			g.setFill(this.getColor());
			g.fillRect(x, y, w, h);
		}

		g.setStroke(this.getColor());
		g.strokeRect(x, y, w, h);
	}


}
