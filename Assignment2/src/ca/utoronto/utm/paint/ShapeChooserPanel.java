package ca.utoronto.utm.paint;

import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/*
 * Creates a left side panel that has a set of preset shapes that a user can click from
 */
public class ShapeChooserPanel extends GridPane {
	/*
	 * View of the current canvas
	 */
	View view; // So we can talk to our parent or other components of the view

	/*
	 * The constructor for shape chooser panel. Creates a set of buttons defined in
	 * this constructor and puts it on the side of the canvas
	 * 
	 * @param view Takes in the current canvas
	 */
	public ShapeChooserPanel(View view) {

		this.view = view;

		String[] buttonLabels = { "Circle", "Rectangle", "Square", "Squiggle", "Polyline" };

		/// Adding the images to our program

		Image circlePic = new Image(getClass().getResourceAsStream("shape_circle.png"));
		Image rectanglePic = new Image(getClass().getResourceAsStream("shape_rectangle.png"));
		Image squarePic = new Image(getClass().getResourceAsStream("shape_square.png"));
		Image squigglePic = new Image(getClass().getResourceAsStream("shape_squiggle.png"));
		Image polylinePic = new Image(getClass().getResourceAsStream("shape_polyline.png"));

		int row = 0;
		for (String label : buttonLabels) {
			Button button = new Button();
			button.setMinWidth(35);
			button.setId(label); // sets the button's ID to that specific shapes name.
			this.add(button, 0, row);
			row++;
			button.setOnAction(new ShapeChooserPanelEventHandler(view));

			// Depending on the shape, it is assigned the correct image
			if (label == "Circle") {
				button.setGraphic(new ImageView(circlePic));
				button.setTooltip(new Tooltip("Circle tool"));
			} else if (label == "Rectangle") {
				button.setGraphic(new ImageView(rectanglePic));
				button.setTooltip(new Tooltip("Rectangle tool"));
			} else if (label == "Square") {
				button.setGraphic(new ImageView(squarePic));
				button.setTooltip(new Tooltip("Square tool"));
			} else if (label == "Squiggle") {
				button.setGraphic(new ImageView(squigglePic));
				button.setTooltip(new Tooltip("Squiggle tool"));
			} else if (label == "Polyline") {
				button.setGraphic(new ImageView(polylinePic));
				button.setTooltip(new Tooltip(
						"Polyline Tool \nTo create a new polyline, click the button \nIf you want another one, click again"));
			}

		}

	}

	/**
	 * Returns the current instance of the gridpane
	 * 
	 * @return the current instance of the gridpane
	 */
	public GridPane getGridPanel() {
		return this;
	}

}
