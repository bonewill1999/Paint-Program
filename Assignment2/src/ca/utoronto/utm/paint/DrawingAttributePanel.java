package ca.utoronto.utm.paint;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Slider;

/*
 * Creates a bottom panel that has a set of presets colors that a user can click from
 */
public class DrawingAttributePanel extends GridPane {

	/*
	 * View of the current canvas
	 */
	private View view;

	/*
	 * The constructor for color selector panel. Creates a set of buttons defined in
	 * this constructor and puts it on the bottom of the canvas
	 * 
	 * @param view Takes in the current canvas
	 */
	public DrawingAttributePanel(View view) {

		this.view = view;

		String[][] colors = { { "WHITE", "#FFFFFF" }, { "BLACK", "#111111" }, { "SILVER", "#DDDDDD" },
				{ "GRAY", "#AAAAAA" }, { "ORANGE", "#FF851B" }, { "YELLOW", "#FFDC00" }, { "LIME", "#01FF70" },
				{ "GREEN", "#2ECC40" }, { "FUCHSIA", "#F012BE" }, { "PURPLE", "#B10DC9" }, { "RED", "#FF4136" },
				{ "MAROON", "#85144b" }, { "BLUE", "#0074D9" }, { "NAVY", "#001f3f" }, { "AQUA", "#7FDBFF" },
				{ "TEAL", "#39CCCC" }, { "OLIVE", "#3D9970" }, { "SALEM", "#008751" } };

		int row = 0;
		int col = 1;
		this.setVgap(-2);
		for (String[] color : colors) {
			Button button = new Button();
			button.setMinWidth(50);
			button.setStyle("-fx-background-color:" + color[1] + "; -fx-border-color:" + color[1]
					+ ";-fx-border-radius: 0, 0, 0, 0;");
			button.setLineSpacing(1);
			button.setId(color[1]);
			button.setPrefHeight(35);
			this.add(button, col, row);
			if (row == 1) {
				col++;
				row--;
			} else {
				row++;
			}
			button.setOnAction(new DrawingAttributePanelEventHandler(view));
		}
		col++;
		Label label = new Label("Thickness:");
		label.setStyle("-fx-padding: 0, 0, 0, 10");
		Slider slider = new Slider(1, 10, 1);
		this.add(label, col, 0);
		slider.setShowTickLabels(true);

		slider.setShowTickMarks(true);
		slider.setMajorTickUnit(1);
		slider.setBlockIncrement(0.5);
		slider.setStyle("-fx-padding: 0, 0, 0, 10");
		this.add(slider, col, 1);
		slider.valueProperty().addListener((observable, oldValue, newValue) -> {
			this.view.getPaintPanel().lineThickness.setThickness(newValue.doubleValue());
		});

		col++;
		CheckBox fill = new CheckBox();
		fill.setText("Fill");
		fill.setSelected(false);
		fill.setId("Fill");

		this.add(fill, col, 0);
		fill.selectedProperty().addListener((observable, oldValue, newValue) -> {
			this.view.getPaintPanel().fill.changeState();
		});

		Button clear = new Button("Clear");
		clear.setId("Clear");
		clear.setMinWidth(50);
		clear.setOnAction(new DrawingAttributePanelEventHandler(view));
		this.add(clear, col, 1);

	}
	
	/**
	 * Returns the current instance of the GridPane
	 * @return the current instance of the pane
	 */
	public GridPane getGridPanel() {
		return this;
	}

}
