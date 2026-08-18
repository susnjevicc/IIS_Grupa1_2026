package geometry;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape implements Moveable, Comparable{   //comparable da bih napisala metodu po kojoj ce racunar znati po cemu se porede oblici 
	
	//pravilo enkapsulacije 
	//koristicemo protected umesto private da ne bismo menjali ostale konstruktore
	protected boolean selected;
	protected Color color;
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	//pisemo default konstruktor kako bismo naglasili da apstraktna klasa
	//ima konstruktor 
	public Shape() {
		
	}
	
	//svaka klasa koja nasledjuje Shape mora da implementira metodu contains 
	public abstract boolean contains(int x, int y);
	public abstract String toString();
	public abstract boolean equals(Object obj);
	public abstract void draw(Graphics g);

	
	//ne treba override u klasama koje je nasledjuju 
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	
	

}
