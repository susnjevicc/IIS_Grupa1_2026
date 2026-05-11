package geometry;

import java.awt.Graphics;

public class Rectangle extends Shape {

	private Point upperLeftPoint;
	private int width;
	private int height;

	public Rectangle() {

	}

	public Rectangle(Point upperLeftPoint, int width, int height) {
		this.upperLeftPoint = upperLeftPoint;
		this.width = width;
		this.height = height;
	}

	public Rectangle(Point upperLeftPoint, int width, int height, boolean selected) {
		this(upperLeftPoint, width, height);
		this.selected = selected;
	}

// Povrsina pravougaonika P=w*h
	public int area() {
		return width * height;
	}

// Obim pravougaonika O=2*(w+h)
	public int circumference() {
		return 2 * (width + height);
	}

	public String toString() {
		return "Upper left point: " + upperLeftPoint.toString() + ", width = " + width + ", height = " + height;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Rectangle) {
			Rectangle secondRect = (Rectangle) obj;
			if (upperLeftPoint.equals(secondRect.upperLeftPoint) && width == secondRect.width
					&& height == secondRect.height) {
				return true;
			}
		}
		return false;
	}

	public boolean contains(int x, int y) {
		return (x >= this.upperLeftPoint.getX() && x <= this.upperLeftPoint.getX() + width
				&& y >= this.upperLeftPoint.getY() && y <= this.upperLeftPoint.getY() + height);
	}

	@Override
	public void draw(Graphics g) {
		g.drawRect(upperLeftPoint.getX(), upperLeftPoint.getY(), width, height);

	}

	@Override
	public void moveTo(int x, int y) {
		upperLeftPoint.moveTo(x, y);

	}

	@Override
	public void moveBy(int x, int y) {
		upperLeftPoint.moveBy(x, y);
		

	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Rectangle) {
			double povrsinaThis = this.area();
			double povrsinaParametra = ((Rectangle) o).area();
			
			return (int)(povrsinaThis - povrsinaParametra);
		}
		
		return 0;
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

}