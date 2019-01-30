package ca.utoronto.utm.paint;

import javafx.scene.input.MouseEvent;

/**
 * This interface is used as our "Strategy interface" for selecting a shape.
 * Each Shape that has mouse events will implement this interface so that our
 * paint panel will know what to do when a mouse event is done with that
 * specific shape selected.
 * 
 * @author Facebook Paint LLC
 *
 */
public interface ShapeManipulatorStrategy {

	public void mouseMoved(MouseEvent e);

	public void mouseDragged(MouseEvent e);

	public void mouseClicked(MouseEvent e);

	public void mousePressed(MouseEvent e);

	public void mouseReleased(MouseEvent e);

	public void mouseEntered(MouseEvent e);

	public void mouseExited(MouseEvent e);

	public String getName();

}
