package ca.utoronto.utm.paint;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/*
 * The main class for the Paint Panel
 */
class PaintPanel extends StackPane implements Observer {

	ShapeManipulatorStrategy shapeStrat;
	protected int i = 0;
	protected PaintModel model; // slight departure from MVC, because of the way painting works
	protected View view; // So we can talk to our parent or other components of the view

	protected Canvas canvas;
	protected Color color;
	protected Fill fill;
	protected Thickness lineThickness;

	protected Circle circle; // the circle we are building
	protected Rectangle rectangle;
	protected Squiggle squiggle;
	protected Polyline polyline;
	protected Square square;

	/*
	 * Initializer for the paintPanel
	 * 
	 * @param model Takes in PaintModel
	 * @param view Takes in the current view
	 */
	public PaintPanel(PaintModel model, View view) {

		this.canvas = new Canvas(800, 300);
		this.getChildren().add(this.canvas);
		// The canvas is transparent, so the background color of the
		// containing pane serves as the background color of the canvas.
		this.setStyle("-fx-background-color: #7FDBFF");

		this.addEventHandler(MouseEvent.ANY, new PaintPanelEventHandler(this));

		// Sets default mode as circle
		this.setStrategy(new ShapeManipulatorStrategyCircle(this));
		this.color = Color.BLACK; // Default color black
		this.lineThickness = new Thickness();
		this.fill = new Fill();
		

		this.canvas.widthProperty().addListener(observable -> repaint());
		this.canvas.heightProperty().addListener(observable -> repaint());

		this.model = model;
		this.model.addObserver(this);

		this.view = view;

	}

	/*
	 * When shapes are updated, the whole canvas gets repaint
	 */
	public void repaint() {

		GraphicsContext g = this.canvas.getGraphicsContext2D();
		g.clearRect(0, 0, this.getWidth(), this.getHeight());

		ArrayList<Drawable> drawables = this.model.getDrawables();
		for (Drawable d : drawables) {
			model.commandDraw(d, g);
		}

	}

	@Override
	public void update(Observable o, Object arg) {

		// Not exactly how MVC works, but similar.

		this.repaint();
	}

	/*
	 * Set the current shape to use
	 * 
	 * @param shapeStrat Takes in ShapeManipulatorStrategy which indicates which shape to use
	 */
	public void setStrategy(ShapeManipulatorStrategy shapeStrat) {
		this.shapeStrat = shapeStrat;
	}

	/*
	 * Set the current desired color
	 * 
	 * @param color (String) name of the current selected color
	 */
	public void setColor(String color) {
		this.color = Color.web(color);
	}

	/*
	 * Set the current Background color
	 * 
	 * @param color (String) name of the current selected color
	 */
	public void setBackGroundColor(String color) {
		this.setStyle("-fx-background-color: " + color);
	}
	
	

}
