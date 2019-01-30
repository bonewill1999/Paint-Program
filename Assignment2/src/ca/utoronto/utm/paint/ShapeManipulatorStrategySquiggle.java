package ca.utoronto.utm.paint;

import javafx.scene.input.MouseEvent;

/**
 * This class implements the interface ShapeManipulatorStrategy. It is used when
 * the PaintPanel "selects" this algorithm to use. This means that when
 * "Squiggle" is selected as the current shape in ShapePanel, all mouse events
 * will use the algorithms in this class.
 * 
 * @author Facebook Paint LLC
 *
 */
public class ShapeManipulatorStrategySquiggle implements ShapeManipulatorStrategy {

	PaintPanel panel;

	public ShapeManipulatorStrategySquiggle(PaintPanel panel) {
		this.panel = panel;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		Point point = new Point((int) e.getX(), (int) e.getY(), panel.color);

		panel.squiggle.extendSquiggle(point);
		panel.squiggle.setLineThickness(panel.lineThickness.getThickness());
		panel.model.addDrawable(panel.squiggle);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		Point start = new Point((int) e.getX(), (int) e.getY(), panel.color);
		panel.squiggle = new Squiggle(panel.color, start);
		panel.squiggle.setLineThickness(panel.lineThickness.getThickness());
		panel.model.addDrawable(panel.squiggle);

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Point point = new Point((int) e.getX(), (int) e.getY(), panel.color);
		panel.squiggle.extendSquiggle(point);
		panel.squiggle.setLineThickness(panel.lineThickness.getThickness());
		panel.model.addDrawable(panel.squiggle);
		panel.squiggle = null;

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
		return "Squiggle";
	}

}
