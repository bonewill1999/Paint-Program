package ca.utoronto.utm.paint;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/*
 * EventHandler for DrawingAttributePanel
 */
public class DrawingAttributePanelEventHandler implements EventHandler<ActionEvent> {
	/*
	 * View of the current canvas
	 */
	View view;

	/*
	 * Initializes view so that it can access getPainePanel
	 */
	public DrawingAttributePanelEventHandler(View view) {
		this.view = view;
	}


	/*
	 * Handles the events for the DrawingAttributePanel.
	 * If the clear button is pressed, the canvas will be cleared.
	 * If a color button is pressed the next shape drawn will be that color.
	 */
	@Override
	public void handle(ActionEvent event) {
		String command = ((Button) event.getSource()).getId();

		if (command == "Clear") {
			this.view.model.clearDrawable();
			if (this.view.getPaintPanel().shapeStrat.getName() == "Polyline") {
				this.view.getPaintPanel().setStrategy(new ShapeManipulatorStrategyCircle(this.view.getPaintPanel()));
				this.view.getPaintPanel().setStrategy(new ShapeManipulatorStrategyPolyline(this.view.getPaintPanel()));
			}
		} else {
			this.view.getPaintPanel().setColor(command);
		}

	}

}
