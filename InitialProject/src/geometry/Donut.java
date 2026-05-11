package geometry;

import java.awt.Graphics;

public class Donut extends Circle {

	private int innerRadius;

	public Donut() {
		// on setuje innerRadius na default vrednost koja je 0 i poziva u pozadini
		super(); // moze i ne mora, podrazumeva se - konstruktor klase Circle
	}

	public Donut(Point center, int radius, int innerRadius) {
		// this.center = center; // ne moze jer je center private u circle
		// 1. nacin je da this.setCenter(center)
		// 2. nacin je this.center ali center u Circle treba da bude protected
		super(center, radius); // poziv konstruktora iz klase circle
		this.innerRadius = innerRadius;

	}

	public Donut(Point center, int radius, int innerRadius, boolean selected) {
		/* 1. nacin
		 * this(center, radius, innerRadius);
		 * this.setSelected(selected);
		 */
		// 2. nacin
		super(center, radius, selected);
		this.innerRadius = innerRadius;
		// ne mozemo u isto vreme pozivati i this() i super()
		//super.getCenter(); // mogu pozvati property iz circle

	}

	public String toString() {
		// return toString(); // ovo bi stvorilo rekurziju (infinity loop)
		return super.toString() + ", inner radius = " + innerRadius;
	}

	public boolean equals(Object obj) {
		// instanceof Circle --> prolaze i Circle ali i Donut
		// obj.getClass() --> prolazi samo Circle
		if (obj instanceof Donut) {
			Donut pomocna = (Donut) obj;
			// pomocna je Donut ali i Circle i Object zato prolazi instanceof u equals u Circle i zato mozemo Donut downcast u Circle
			if (super.equals(pomocna) && this.innerRadius == pomocna.innerRadius)	
				return true;
		}
		return false;
	}

	public boolean contains(int x, int y) {
		return (super.contains(x, y) && 
				getCenter().distance(new Point(x,y))> innerRadius);
	}

	public double area() { 
		double area = super.area() - innerRadius*innerRadius*Math.PI;
		return area;
	}

	// uraditi za obim kod kuce
	// a metode pristupa za ostale property nasledjujemo samo ne redefinisemo

	@Override
	public void draw(Graphics g) {
		super.draw(g);
		g.drawOval(center.getX()-innerRadius, center.getY()-innerRadius, 
				innerRadius*2, innerRadius*2);
	}
	
	@Override
	public void moveTo(int x, int y) {
		// TODO Auto-generated method stub

	}

	@Override
	public void moveBy(int x, int y) {
		// TODO Auto-generated method stub

	}
	
	//iako je identicna moram je redefinisati zbog area koja bi se pozivala
	//inace nad iz Circle a ne iz Donut
	@Override
	public int compareTo(Object o) {
		if(o instanceof Donut) {
			double povrsinaThis = this.area();
			double povrsinaParametra = ((Donut) o).area();
			
			return (int)(povrsinaThis - povrsinaParametra);
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