package ca.utoronto.utm.paint;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;

/*
 * EventHandler for ShapeChooserPanel
 */
public class ShapeChooserPanelEventHandler implements EventHandler<ActionEvent> {

	/*
	 * View of the current canvas
	 */
	View view;

	/*
	 * Initializes view so that it can access getPainePanel
	 */
	public ShapeChooserPanelEventHandler(View view) {
		this.view = view;
	}

	/**
	 * Depending on the button pressed, the correct strategy will be selected. A
	 * factory design pattern is used here. When a button is pressed, we get the id
	 * of that button so that we can decide which strategy to choose. For example,
	 * if we press a button and the id of the button selected is "Circle" we will
	 * set the strategy to use in in PaintPanel to be
	 * ShapeManipulatorStrategyCircle. This means that all the mouse events used
	 * will reflect the ones necessary for circles.
	 */
	@Override
	public void handle(ActionEvent event) {
		String command = ((Button) event.getSource()).getId();
		ObservableList<Node> gp = this.view.getDrawingAttributePanel().getGridPanel().getChildren();
		ObservableList<Node> shapes = this.view.getShapeChooserPanel().getGridPanel().getChildren();
		String selectedColor = "#bdc3c7";

		// Selects which strategy to use based on what shape is chosen.
		if (command == "Circle" || command == "Rectangle" || command == "Square") {
			for (Node node : gp) {
				if (node.getId() == "Fill") {
					node.setDisable(false);
				}
			}
		} else if (command == "Polyline" || command == "Squiggle") {
			for (Node node : gp) {
				if (node.getId() == "Fill") {
					node.setDisable(true);
				}
			}
		}
		if (command == "Circle") {
			this.view.getPaintPanel().setStrategy(new ShapeManipulatorStrategyCircle(this.view.getPaintPanel()));
			for (Node node : shapes) {
				if (node.getId() == "Circle") {
					node.setStyle("-fx-background-color:" + selectedColor);
				} else
					node.setStyle("");
			}
		} else if (command == "Rectangle") {
			this.view.getPaintPanel().setStrategy(new ShapeManipulatorStrategyRectangle(this.view.getPaintPanel()));
			for (Node node : shapes) {
				if (node.getId() == "Rectangle") {
					node.setStyle("-fx-background-color:" + selectedColor);
				} else
					node.setStyle("");
			}
		} else if (command == "Square") {
			this.view.getPaintPanel().setStrategy(new ShapeManipulatorStrategySquare(this.view.getPaintPanel()));
			for (Node node : shapes) {
				if (node.getId() == "Square") {
					node.setStyle("-fx-background-color:" + selectedColor);
				} else
					node.setStyle("");
			}
		} else if (command == "Squiggle") {
			this.view.getPaintPanel().setStrategy(new ShapeManipulatorStrategySquiggle(this.view.getPaintPanel()));
			for (Node node : shapes) {
				if (node.getId() == "Squiggle") {
					node.setStyle("-fx-background-color:" + selectedColor);
				} else
					node.setStyle("");
			}
		} else if (command == "Polyline") {
			this.view.getPaintPanel().setStrategy(new ShapeManipulatorStrategyPolyline(this.view.getPaintPanel()));
			for (Node node : shapes) {
				if (node.getId() == "Polyline") {
					node.setStyle("-fx-background-color:" + selectedColor);
				} else
					node.setStyle("");
			}
		}
		
	}

}
