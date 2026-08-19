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
	protected int selectedIndex;
	

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
	
	protected void selectShape(int x, int y) {
        if(selectedShape != null) {
            selectedShape.setSelected(false);
        }
        selectedShape = null;
        for(int i = ShapeList.size()-1; i >= 0; i--) {
            if(ShapeList.get(i).contains(x, y)) {
            	ShapeList.get(i).setSelected(true);
            	selectedShape = ShapeList.get(i);
            	selectedIndex = i;
                break;
            }
        }
        paint(getGraphics());
        
    }
	
	protected void deleteShape() {
        selectedShape = null;
        ShapeList.remove(selectedIndex);
        paint(getGraphics());
    }

	
}
