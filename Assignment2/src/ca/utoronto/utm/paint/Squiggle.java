package ca.utoronto.utm.paint;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Squiggle implements Drawable {

	private ArrayList<Point> squiggle = new ArrayList<Point>();
	private Color colour;
	private double lineThickness;

	public Squiggle(Color colour, Point start) {
		this.colour = colour;
		this.squiggle.add(start);
	}

	public void extendSquiggle(Point point) {
		this.squiggle.add(point);
	}

	public void setLineThickness(double lineThickness) {
		this.lineThickness = lineThickness;
	}

	public ArrayList<Point> getSquiggle() {
		return this.squiggle;
	}

	public Color getColour() {
		return this.colour;
	}

	public double getLineThickness() {
		return lineThickness;
	}

	public void draw(GraphicsContext g) {
		int i = 0;
		while (i < this.getSquiggle().size() - 1) {
			Point p1 = this.getSquiggle().get(i);
			Point p2 = this.getSquiggle().get(i + 1);
			g.setStroke(p1.getColor());
			g.setLineWidth(this.getLineThickness());
			g.strokeLine(p1.getX(), p1.getY(), p2.getX(), p2.getY());

			i++;

		}
	}

}
