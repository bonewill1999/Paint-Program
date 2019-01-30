package ca.utoronto.utm.paint;

import javafx.scene.input.MouseEvent;

/**
 * This class implements the interface ShapeManipulatorStrategy. It is used when
 * the PaintPanel "selects" this algorithm to use. This means that when
 * "Rectangle" is selected as the current shape in ShapePanel, all mouse events
 * will use the algorithms in this class.
 * 
 * @author Facebook Paint LLC
 *
 */
public class ShapeManipulatorStrategyRectangle implements ShapeManipulatorStrategy {

	PaintPanel panel;

	public ShapeManipulatorStrategyRectangle(PaintPanel panel) {
		this.panel = panel;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		int width = ((int) e.getX() - panel.rectangle.getBottomCorner().getX());
		int height = ((int) e.getY() - panel.rectangle.getBottomCorner().getY());
		panel.rectangle.setHeight(height);
		panel.rectangle.setWidth(width);
		panel.rectangle.setLineThickness(panel.lineThickness.getThickness());
		panel.model.addDrawable(panel.rectangle);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		Point bottomcorner = new Point((int) e.getX(), (int) e.getY(), panel.color);
		panel.rectangle = new Rectangle(bottomcorner, 20, 20, panel.color, panel.fill.getFill());

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		int width = ((int) e.getX() - panel.rectangle.getBottomCorner().getX());
		int height = ((int) e.getY() - panel.rectangle.getBottomCorner().getY());
		panel.rectangle.setHeight(height);
		panel.rectangle.setWidth(width);
		panel.rectangle.setLineThickness(panel.lineThickness.getThickness());
		panel.model.addDrawable(panel.rectangle);
		panel.rectangle = null;

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public String getName() {
		return "Rectangle";
	}

}
