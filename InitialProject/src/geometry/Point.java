package geometry;

import java.awt.Graphics;

public class Point extends Shape {

	private int x;
	private int y;

	public Point() {

	}

	public Point(int x, int y) {
		// u pozadini se poziva i konstruktor iz Shape kao npr super()
		this.x = x;
		this.y = y;
	}

	public Point(int x, int y, boolean selected) {
		/*
		 * this.x = x; this.y = y;
		 */
		this(x, y);
		this.selected = selected;
	}

	public double distance(Point point2) {
		double a = this.x - point2.x;
		double b = this.y - point2.y;
		double c = Math.sqrt(a * a + b * b);
		return c;
	}

	public String toString() {
		return "(" + x + ", " + y + ")";
	}

	public boolean equals(Object obj) {
		if (obj instanceof Point) {
			Point secondPoint = (Point) obj;
			if (this.x == secondPoint.x && this.y == secondPoint.y) {
				return true;
			}
		}
		return false;
	}

	public boolean contains(int x, int y) {
		if (this.distance(new Point(x, y)) <= 2)
			return true;
		return false;
	}

	@Override
	public void draw(Graphics g) {
		g.drawLine(x - 2, y, x + 2, y);
		g.drawLine(x, y - 2, x, y + 2);
	}

	@Override
	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;

	}

	@Override
	public void moveBy(int x, int y) {
	// TODO Auto-generated method stub
	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof Point) {
			//udaljenost tacke nad kojom pozivamo compareTo
			double udaljenostThisTacke = this.distance(new Point(0,0));
			//mora downcast jer je distance samo u Point a ne i u Object 
			double udaljenostParametarTacke = ((Point) o).distance(new Point(0,0));
			
			return (int)(udaljenostThisTacke-udaljenostParametarTacke);
		}
		
		return 0;
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

	

}