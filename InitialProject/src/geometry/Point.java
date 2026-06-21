package geometry;

import java.awt.Graphics;

public class Point  {

	private int x;
	private int y;
	private boolean selected;
	
	public double distance (Point point2) {
		double a = this.x - point2.x;
		double b = this.y - point2.y;
		double c = Math.sqrt(a*a + b*b);
		
		return c;
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
	
	
	public boolean isSelected() {
		return selected;
	}
	
	
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	
	

	

}