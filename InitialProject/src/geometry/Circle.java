package geometry;

import java.awt.Graphics;

public class Circle extends Shape {
	protected Point center; // nije nasledjivanje vec komponovanje
	private int radius;

	public Circle() {
	}

	public Circle(Point center, int radius) {
		this.center = center;
		this.radius = radius;
	}

	public Circle(Point center, int radius, boolean selected) {
		this(center, radius);
		this.selected = selected;
	}

	public double area() {
		return radius * radius * Math.PI;
	}

	public double circumference() {
		return 2 * radius * Math.PI;
	}

	public String toString() {
//return "Center: " + center + ", radius = " + radius;
		return "Center: " + center.toString() + ", radius = " + radius;
	}

	public boolean equals(Object obj) {
		if (obj instanceof Circle) {
			Circle pomocna = (Circle) obj;
			if (this.center.equals(pomocna.center) && this.radius == pomocna.radius)
				return true;
		}
		return false;
	}

// moze se kreirati i metoda contains(Point tackaKlika)
	public boolean contains(int x, int y) {
		Point sadrziTacku = new Point(x, y);
		return (this.center.distance(sadrziTacku) <= this.radius);
	}

	@Override
	public void draw(Graphics g) {
		g.drawOval(center.getX() - radius, center.getY() - radius, radius * 2, radius * 2);

	}

	//ne treba implementirati u Donut jer im odgovara implementacija koju nasledjuju iz Circle
	@Override
	public void moveTo(int x, int y) {
		center.moveTo(x, y);

	}

	@Override
	public void moveBy(int x, int y) {
		center.moveBy(x, y);

	}
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Circle) {
			double povrsinaThis = this.area();
			double povrsinaParametra = ((Circle) o).area();
			
			return (int)(povrsinaThis - povrsinaParametra);
		}
		
		return 0;
	}

//metode pristupa 
	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

}