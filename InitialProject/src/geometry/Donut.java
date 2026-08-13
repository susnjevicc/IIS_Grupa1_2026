package geometry;

import java.awt.Color;
import java.awt.Graphics;

public class Donut extends Circle{
	
	private int innerRadius;
	
	public Donut() {
		// on setuje innerRadius na default vrednost koja je 0 i poziva u pozadini
		super(); // moze i ne mora, podrazumeva se - konstruktor klase Circle
	}
	
	public Donut(Point center, int radius, int innerRadius) {
		super(center, radius);
		this.innerRadius = innerRadius;
	}
	
	public Donut(Point center, int radius, int innerRadius, boolean selected) {
		this(center, radius, innerRadius);
		this.setSelected(selected);
	}
	
	
	public String toString() {
		return super.toString() + ", inner radius =" + innerRadius;
	}
	
	
	public boolean equals(Object obj) {
		if(obj instanceof Donut) {
			Donut pomocna = (Donut) obj;
			// pomocna je Donut ali i Circle i Object zato prolazi instanceof u equals
			//u Circle i zato mozemo Donut downcast u Circle
			if(super.equals(pomocna) && this.innerRadius == pomocna.innerRadius)
				return true;
		}
		return false;
	}
	
	
	
	
	
	public boolean contains(int x, int y) {
		return (super.contains(x, y) &&
				getCenter().distance(new Point(x,y)) > innerRadius);
	}
	
	
	public double area() {
		double area = super.area() - innerRadius*innerRadius*Math.PI;
		return area;
	}
	
	public double circumference() {
		double circumference = super.circumference() + 2*innerRadius*Math.PI;
		return circumference;
	}

	
	
	
	//metode pristupa za ostale property nasledjujemo samo, ne redefinisemo
	
	@Override
	public void draw(Graphics g) {
		super.draw(g);
		g.drawOval(center.getX()-innerRadius, center.getY()-innerRadius, 
		        innerRadius*2, innerRadius*2);
		
		if (isSelected()) {
			g.setColor(Color.BLUE);
			g.drawRect(getCenter().getX() - 2, getCenter().getY() - 2, 4, 4);
			g.drawRect(getCenter().getX() - innerRadius - 2, getCenter().getY() - 2, 4, 4);
			g.drawRect(getCenter().getX() + innerRadius - 2, getCenter().getY() - 2, 4, 4);
			g.drawRect(getCenter().getX() - 2, getCenter().getY() - innerRadius - 2, 4, 4);
			g.drawRect(getCenter().getX() - 2, getCenter().getY() + innerRadius - 2, 4, 4);
			g.setColor(Color.black);
		}
	}

	
	//iako je identicno moramo je redefinisati zbog area koja bi se pozivala 
	//inace nad iz Circle a ne iz Donut 
	
	@Override
	public int compareTo(Object o) {
		if(o instanceof Donut) {
			double povrsinaThis = this.area();
			double povrsinaParametra = ((Donut) o).area();
			
			return(int)(povrsinaThis - povrsinaParametra);
		}
		
		return 0;
	}
	
	

	public int getInnerRadius() {
		return innerRadius;
	}

	

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
	
	

}
