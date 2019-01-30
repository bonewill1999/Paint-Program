package ca.utoronto.utm.paint;

import java.util.ArrayList;
import java.util.Observable;

import javafx.scene.canvas.GraphicsContext;

/*
 * The Main Model for Paint Program
 */
public class PaintModel extends Observable {

	private ArrayList<Drawable> drawables = new ArrayList<Drawable>();

	/*
	 * Clears the whole Paint Panel including shapes
	 */
	public void clearDrawable() {
		this.drawables.clear();
		this.setChanged();
		this.notifyObservers();

	}

	/**
	 * Adds a drawable to the list of drawables maintained in the current model
	 * 
	 * @param d the drawable to be added to the array list of drawables
	 */
	public void addDrawable(Drawable d) {
		this.drawables.add(d);
		this.setChanged();
		this.notifyObservers();
	}

	/**
	 * Gets the list of drawables maintained in the current model
	 * 
	 * @return returns the arraylist of drawables
	 */
	public ArrayList<Drawable> getDrawables() {
		return drawables;
	}

	/**
	 * Commands the given drawable to be drawn on the given graphics context
	 * 
	 * @param d the drawable to be commanded
	 * @param g the graphics context to be drawn on
	 */
	public void commandDraw(Drawable d, GraphicsContext g) {
		d.draw(g);
	}

}
