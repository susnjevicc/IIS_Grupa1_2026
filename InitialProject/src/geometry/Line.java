package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Line extends Shape{

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
	
	public double length() {
		return startPoint.distance(endPoint);
	}
	
	public String toString() {
		return startPoint.toString() + " -->" + endPoint.toString();
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof Line) {
			Line secondLine = (Line) obj;
			if (startPoint.equals(secondLine.startPoint) &&
	endPoint.equals(secondLine.endPoint)) {
				return true;
			}
		}
		return false;
	}
	
	
	public boolean contains(int x, int y) {
		Point sadrziTacku = new Point(x, y);
		return this.startPoint.distance(sadrziTacku) + this.endPoint.distance(sadrziTacku) - length() <= 2;
	}
	
	
	
	
	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.drawLine(startPoint.getX(), startPoint.getY(),
				endPoint.getX(), endPoint.getY());
		
		if(isSelected()) {
			g.setColor(Color.blue);
			g.drawRect(startPoint.getX()-2, startPoint.getY()-2, 4, 4);
			g.drawRect(endPoint.getX()-2, endPoint.getY()-2, 4, 4);
			g.setColor(Color.black);
		}
		
	}

	
	
	@Override
	public void moveTo(int x, int y) {
		startPoint.moveTo(x, y);
		endPoint.moveTo(x, y);
		//dobicemo tacku 
	}

	@Override
	public void moveBy(int x, int y) {
		startPoint.moveBy(x, y);
		endPoint.moveBy(x, y);	
	}
	
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Line) {
			//duzina linije nad kojom pozivamo compareTo
			double duzinaThisLinije = this.length();
			//mora downcast jer je length samo u Line a ne i u Object
			//a kompajler ga gleda kao Object iako smo prosledili new Line
			double duzinaParametraLinije = ((Line) o).length();
			
			return(int)(duzinaThisLinije - duzinaParametraLinije);
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
