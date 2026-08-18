package drawing;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

import geometry.Shape;

public class PnlDrawing extends JPanel {

	private static final long serialVersionUID = 1L;
	protected ArrayList <Shape> ShapeList = new ArrayList();
	protected Shape selectedShape;
	

	/**
	 * Create the panel.
	 */
	public PnlDrawing() {
		setBackground(Color.white);
	}

	public void paint(Graphics g) {
		super.paint(g);
		for(Shape shape : ShapeList) {
			shape.draw(g);
		}
	}
	
	
	protected void addShape(Shape shape) {
        ShapeList.add(shape);
        paint(getGraphics());
    }
	
	
}
