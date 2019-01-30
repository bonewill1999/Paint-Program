package ca.utoronto.utm.paint;

import javafx.scene.input.MouseEvent;

/**
 * This class implements the interface ShapeManipulatorStrategy. It is used when
 * the PaintPanel "selects" this algorithm to use. This means that when "Square"
 * is selected as the current shape in ShapePanel, all mouse events will use the
 * algorithms in this class.
 * 
 * @author Facebook Paint LLC
 *
 */
public class ShapeManipulatorStrategySquare implements ShapeManipulatorStrategy {

	PaintPanel panel;

	public ShapeManipulatorStrategySquare(PaintPanel panel) {
		this.panel = panel;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		int width = ((int) e.getX() - panel.square.getCornorInit().getX());
		int height = ((int) e.getY() - panel.square.getCornorInit().getY());
//		double diagonal = Math.sqrt(width^2+height^2)/Math.sqrt(2);

		panel.square.setWidth(width);
		panel.square.setHeight(height);
		panel.square.setLineThickness(panel.lineThickness.getThickness());
		panel.model.addDrawable(panel.square);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		Point cornerInitial = new Point((int) e.getX(), (int) e.getY(), panel.color);
		panel.square = new Square(cornerInitial, 20, panel.color, panel.fill.getFill());

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		int width = ((int) e.getX() - panel.square.getCornorInit().getX());
		int height = ((int) e.getY() - panel.square.getCornorInit().getY());
		panel.square.setWidth(width);
		panel.square.setHeight(height);
		panel.square.setLineThickness(panel.lineThickness.getThickness());
		panel.model.addDrawable(panel.square);
		panel.square = null;

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
		return "Square";
	}

}
