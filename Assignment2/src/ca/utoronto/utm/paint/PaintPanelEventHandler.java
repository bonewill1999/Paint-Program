package ca.utoronto.utm.paint;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/*
 * EventHandler for PaintPanel
 */
public class PaintPanelEventHandler implements EventHandler<MouseEvent> {

	/*
	 * For accessing paintPanel and their attributes
	 */
	PaintPanel paintPanel;

	/*
	 * Initializes paintPanel so that we can access paintPanel
	 */
	public PaintPanelEventHandler(PaintPanel paintPanel) {
		this.paintPanel = paintPanel;
	}
	
	/*
	 * Handles the events for the PaintPanel.
	 * Based on what mouse even is done, our handler will decide what should be done
	 */
	@Override
	public void handle(MouseEvent event) {

		if (event.getEventType() == MouseEvent.MOUSE_DRAGGED) {
			this.paintPanel.shapeStrat.mouseDragged(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_PRESSED) {
			this.paintPanel.shapeStrat.mousePressed(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_MOVED) {
			this.paintPanel.shapeStrat.mouseMoved(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_CLICKED) {
			this.paintPanel.shapeStrat.mouseClicked(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_RELEASED) {
			this.paintPanel.shapeStrat.mouseReleased(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_ENTERED) {
			this.paintPanel.shapeStrat.mouseEntered(event);
		} else if (event.getEventType() == MouseEvent.MOUSE_EXITED) {
			this.paintPanel.shapeStrat.mouseExited(event);
		}
	}

}
