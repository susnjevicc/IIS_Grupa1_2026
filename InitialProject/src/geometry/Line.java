package geometry;

import java.awt.Graphics;

public class Line extends Shape {

	private Point startPoint;
	private Point endPoint;

	public Line() {

	}

	public Line(Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}

	public Line(Point startPoint, Point endPoint, boolean selected) {
		this(startPoint, endPoint);
		this.selected = selected;
	}

	public double lenght() {
		return startPoint.distance(endPoint);
	}

	public String toString() {
		return startPoint.toString() + " -->" + endPoint.toString();
	}

	public boolean equals(Object obj) {
		if (obj instanceof Line) {
			Line secondLine = (Line) obj;
			if (startPoint.equals(secondLine.startPoint) && endPoint.equals(secondLine.endPoint)) {
				return true;
			}
		}
		return false;
	}

	public boolean contains(int x, int y) {
		Point sadrziTacku = new Point(x, y);
		return this.startPoint.distance(sadrziTacku) + this.endPoint.distance(sadrziTacku) - lenght() <= 2;
	}

	@Override
	public void draw(Graphics g) {
		g.drawLine(startPoint.getX(), startPoint.getY(), endPoint.getX(), endPoint.getY());

	}

	@Override
	public void moveTo(int x, int y) {
		startPoint.moveTo(x,y);
		endPoint.moveTo(x,y);
		//dobicemo tacku 
		//

	}

	@Override
	public void moveBy(int x, int y) {
		startPoint.moveBy(x,y);
		endPoint.moveBy(x,y);
		// 
	}

	@Override
	public int compareTo(Object o) {
		if(o instanceof Line) {
			//duzina linije nad kojom pozivamo compareTo
			double duzinaThisLinije = this.lenght();
			//mora downcast jer je lengthh samo u Line a ne i u Object 
			//a kompajler ga gleda kao Object iako smo prosledili new Line
			double duzinaParametarLinije = ((Line) o).lenght();
			
			return (int)(duzinaThisLinije - duzinaParametarLinije);
		}
		
		return 0;
	}
	
	public Point getStartPoint() {
		return startPoint;
	}

	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}

	public Point getEndPoint() {
		return endPoint;
	}

	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}

}
