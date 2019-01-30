package ca.utoronto.utm.paint;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;

/*
 * EventHandler for ViewEventHandler
 */
public class ViewEventHandler implements EventHandler<ActionEvent> {

	/*
	 * View of the current canvas
	 */
	View view;

	/*
	 * Initializes view so that it can access getPainePanel
	 */
	public ViewEventHandler(View view) {
		this.view = view;
	}

	@Override
	public void handle(ActionEvent event) {
		String command = ((MenuItem) event.getSource()).getId();
		if (command == "Exit") {
			System.exit(0);
		} else {
			this.view.getPaintPanel().setBackGroundColor(command);
			
		}
	}

}
