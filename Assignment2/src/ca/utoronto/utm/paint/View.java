package ca.utoronto.utm.paint;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class View {

	protected PaintModel model;

	protected PaintPanel paintPanel;
	private ShapeChooserPanel shapeChooserPanel;
	private DrawingAttributePanel drawingAttributePanel;

	public View(PaintModel model, Stage stage) {

		this.model = model;
		initUI(stage);
	}

	private void initUI(Stage stage) {

		this.paintPanel = new PaintPanel(this.model, this);
		this.shapeChooserPanel = new ShapeChooserPanel(this);
		this.drawingAttributePanel = new DrawingAttributePanel(this);

		BorderPane root = new BorderPane();
		root.setTop(createMenuBar());
		root.setCenter(this.paintPanel);
		root.setLeft(this.shapeChooserPanel);
		root.setBottom(this.drawingAttributePanel);

		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Paint");
		stage.setResizable(false);
		stage.show();

	}

	public PaintPanel getPaintPanel() {
		return paintPanel;
	}

	public ShapeChooserPanel getShapeChooserPanel() {
		return shapeChooserPanel;
	}

	public DrawingAttributePanel getDrawingAttributePanel() {
		return drawingAttributePanel;
	}

	private MenuBar createMenuBar() {

		MenuBar menuBar = new MenuBar();
		Menu menu;
		MenuItem menuItem;

		// A menu for File

		menu = new Menu("File");

		menuItem = new MenuItem("New");
		menuItem.setId("New");
		menuItem.setDisable(true); // disables button
		menuItem.setOnAction(new ViewEventHandler(this));
		menu.getItems().add(menuItem);

		menuItem = new MenuItem("Open");
		menuItem.setId("Open");
		menuItem.setDisable(true); // disables button
		menuItem.setOnAction(new ViewEventHandler(this));
		menu.getItems().add(menuItem);

		menuItem = new MenuItem("Save");
		menuItem.setId("Save");
		menuItem.setDisable(true); // disables button
		menuItem.setOnAction(new ViewEventHandler(this));
		menu.getItems().add(menuItem);

		menu.getItems().add(new SeparatorMenuItem());

		menuItem = new MenuItem("Exit");
		menuItem.setId("Exit");
		menuItem.setOnAction(new ViewEventHandler(this));
		menu.getItems().add(menuItem);

		menuBar.getMenus().add(menu);

		// Another menu for Edit

		menu = new Menu("Edit");

		menuItem = new MenuItem("Cut");
		menuItem.setId("Cut");
		menuItem.setDisable(true); // disables button
		menuItem.setOnAction(new ViewEventHandler(this));
		menu.getItems().add(menuItem);

		menuItem = new MenuItem("Copy");
		menuItem.setId("Copy");
		menuItem.setDisable(true); // disables button
		menuItem.setOnAction(new ViewEventHandler(this));
		menu.getItems().add(menuItem);

		menuItem = new MenuItem("Paste");
		menuItem.setId("Paste");
		menuItem.setDisable(true); // disables button
		menuItem.setOnAction(new ViewEventHandler(this));
		menu.getItems().add(menuItem);

		menu.getItems().add(new SeparatorMenuItem());

		menuItem = new MenuItem("Undo");
		menuItem.setId("Undo");
		menuItem.setDisable(true); // disables button
		menuItem.setOnAction(new ViewEventHandler(this));
		menu.getItems().add(menuItem);

		menuItem = new MenuItem("Redo");
		menuItem.setId("Redo");
		menuItem.setDisable(true); // disables button
		menuItem.setOnAction(new ViewEventHandler(this));
		menu.getItems().add(menuItem);

		menuBar.getMenus().add(menu);

		// Another menu for BACKGROUND

		String[][] colors = { { "BLACK", "#111111" }, { "WHITE", "#FFFFFF" }, { "GRAY", "#AAAAAA" },
				{ "ORANGE", "#FF851B" }, { "YELLOW", "#FFDC00" }, { "LIME", "#01FF70" }, { "FUCHSIA", "#F012BE" },
				{ "PURPLE", "#B10DC9" }, { "RED", "#FF4136" }, { "BLUE", "#0074D9" }, { "AQUA", "#7FDBFF" },
				{ "TEAL", "#39CCCC" }, { "SALEM", "#008751" } };

		menu = new Menu("BACKGROUND");

		for (String[] color : colors) {
			menuItem = new MenuItem();
			menuItem.setOnAction(new ViewEventHandler(this));
			menuItem.setStyle("-fx-background-color:" + color[1] + "; -fx-border-color:" + color[1]
					+ ";-fx-border-radius: 0, 0, 0, 0;");
			menuItem.setId(color[1]);
			menu.getItems().add(menuItem);
			menuItem.setOnAction(new ViewEventHandler(this));
		}

		menuBar.getMenus().add(menu);

		return menuBar;
	}
}
