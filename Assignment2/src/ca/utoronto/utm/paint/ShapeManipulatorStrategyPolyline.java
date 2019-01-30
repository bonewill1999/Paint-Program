package ca.utoronto.utm.paint;

import java.util.ArrayList;
import javafx.scene.input.MouseEvent;

/**
 * This class implements the interface ShapeManipulatorStrategy. It is used when
 * the PaintPanel "selects" this algorithm to use. This means that when
 * "Polyline" is selected as the current shape in ShapePanel, all mouse events
 * will use the algorithms in this class.
 * 
 * @author Facebook Paint LLC
 *
 */
public class ShapeManipulatorStrategyPolyline implements ShapeManipulatorStrategy {
	PaintPanel panel;

	ArrayList<Double> doubleX = new ArrayList<Double>();
	ArrayList<Double> doubleY = new ArrayList<Double>();
	double[] x = {};
	double[] y = {};
	int amount = 0;

	public ShapeManipulatorStrategyPolyline(PaintPanel panel) {
		this.panel = panel;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		doubleX.add(e.getX());
		doubleY.add(e.getY());
		amount++;
		x = new double[doubleX.size()];
		for (int i = 0; i < doubleX.size(); i++) {
			x[i] = doubleX.get(i);
		}
		y = new double[doubleY.size()];
		for (int i = 0; i < doubleY.size(); i++) {
			y[i] = doubleY.get(i);
		}
		panel.polyline = new Polyline(x, y, amount, panel.color);
		panel.polyline.setLineWidth(panel.lineThickness.getThickness());
		panel.model.addDrawable(panel.polyline);
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

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
		return "Polyline";
	}
}
