package ca.utoronto.utm.paint;

import javafx.scene.canvas.GraphicsContext;

/**
 * Represents the interface for all drawable shapes
 * 
 * @author Facebook Paint LLC
 */

public interface Drawable {
	/**
	 * Draws the given drawable
	 * 
	 * @param g the graphics context in which the drawable is drawn in
	 */
	public void draw(GraphicsContext g);

}
