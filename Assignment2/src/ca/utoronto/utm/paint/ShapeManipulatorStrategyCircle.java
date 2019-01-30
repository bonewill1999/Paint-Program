package ca.utoronto.utm.paint;

import javafx.scene.input.MouseEvent;

/**
 * This class implements the interface ShapeManipulatorStrategy. It is used when
 * the PaintPanel "selects" this algorithm to use. This means that when "Circle"
 * is selected as the current shape in ShapePanel, all mouse events will use the
 * algorithms in this class.
 *
 */
public class ShapeManipulatorStrategyCircle implements ShapeManipulatorStrategy {

	PaintPanel panel;

	public ShapeManipulatorStrategyCircle(PaintPanel panel) {
		this.panel = panel;
	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		int x_Value = Math.abs((int) panel.circle.getCentre().getX() - (int) e.getX());
		int y_Value = Math.abs((int) panel.circle.getCentre().getY() - (int) e.getY());
		int radius = (int) Math.sqrt(Math.pow(x_Value, 2) + Math.pow(y_Value, 2));
		panel.circle.setRadius(radius);
		panel.circle.setLineThickness(panel.lineThickness.getThickness());
		panel.model.addDrawable(panel.circle);
	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// Problematic notion of radius and centre!!
		// is fixed when we repaint. when drawing the oval, we must subtract the radius
		// from x and y since drawing and oval starts from the top left corner. just
		// also
		// mutiply radius by 2 since again it is the full x value and full y value and
		// not the acutal radius.
		// Point centre = new Point((int) e.getX(), (int) e.getY());

		Point centre = new Point((int) e.getX(), (int) e.getY(), panel.color);
		int radius = 0;
		panel.circle = new Circle(centre, radius, panel.fill.getFill(), panel.color);
	}

	@Override
	public void mouseReleased(MouseEvent e) {

		if (panel.circle != null) {
			int x_Value = Math.abs((int) panel.circle.getCentre().getX() - (int) e.getX());
			int y_Value = Math.abs((int) panel.circle.getCentre().getY() - (int) e.getY());
			int radius = (int) Math.sqrt(Math.pow(x_Value, 2) + Math.pow(y_Value, 2));
			panel.circle.setRadius(radius);
			panel.circle.setLineThickness(panel.lineThickness.getThickness());
			panel.model.addDrawable(panel.circle);
			panel.circle = null;

		}

	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public String getName() {
		return "Circle";
	}

}
