package ca.utoronto.utm.paint;

import javafx.application.Application;
import javafx.stage.Stage;

/*
 * Initilizers for model and view for the entire program
 */
public class Paint extends Application {

	PaintModel model; // Model
	View view; // View + Controller

	/*
	 * Main execution method to allow us to use the UI
	 */
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		this.model = new PaintModel();

		// View + Controller
		this.view = new View(model, stage);
	}
}
