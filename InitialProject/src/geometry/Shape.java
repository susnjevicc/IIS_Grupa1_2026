package geometry;

	import java.awt.Graphics;

	// kao ugovor
	public abstract class Shape implements Moveable, Comparable{
		// pravilo enkapsulacije
		// koristicemo protected umesto private da ne bismo menjali ostale konstruktore
		protected boolean selected;
		
		// pisemo default konstruktor kako bismo naglasili da apstraktna klasa ima konstruktor
		public Shape() {
			
		}
		
		// svaka klasa koja nasledjuje Shape mora da implementira metodu contains
		public abstract boolean contains(int x, int y);
		public abstract String toString();
		public abstract boolean equals(Object obj);
		public abstract void draw(Graphics g);
		
		
		// ne treba override u klasama koje je nasledjuju
		public boolean isSelected() {
			return selected;
		}

		public void setSelected(boolean selected) {
			this.selected = selected;
		}
		
		
	}


