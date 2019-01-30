package ca.utoronto.utm.paint;

import javafx.scene.paint.Color;

public class Point {
	int x, y;
	double xx, yy;
	Color color;

	Point(int x, int y, Color color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}

	Point(double x, double y, Color color) {
		this.xx = x;
		this.yy = y;
		this.color = color;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

}
