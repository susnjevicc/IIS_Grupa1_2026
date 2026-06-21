package geometry;

import java.awt.Graphics;

public class Rectangle  {

	private Point upperLeftPoint;
	private int width;
	private int height;
	private boolean selected;
	
	
	// Povrsina pravougaonika P=w*h
	public int area() {
		return width * height;
	}
	
	// Obim pravougaonika O=2*(w+h)
	public int circumference() {
		return 2*(width*height);
	}
	
	public Point getUpperLeftPoint() {
		return upperLeftPoint;
	}
	
	
	public void setUpperLeftPoint(Point upperLeftPoint) {
		this.upperLeftPoint = upperLeftPoint;
	}
	
	
	public int getWidth() {
		return width;
	}
	
	
	public void setWidth(int width) {
		this.width = width;
	}
	
	
	public int getHeight() {
		return height;
	}
	
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	
	public boolean isSelected() {
		return selected;
	}
	
	
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	

}