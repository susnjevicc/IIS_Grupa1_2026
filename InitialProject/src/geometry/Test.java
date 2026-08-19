package geometry;

import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		Point p = new Point();
		p.setX(10);
		p.setY(20);
		p.setSelected(true);

		System.out.println("Koordinata x: " + p.getX());
		System.out.println("Koordinata y: " + p.getY());
		System.out.println("Selected: " + p.isSelected());

		Point point2 = new Point();
		point2.setX(50);
		point2.setY(40);
		double distance = p.distance(point2);
		System.out.println("Distanca je: " + distance);

		/* Vezbe 2 - zadacici */

		// 1. Inicijalizovati x koordinatu tacke p
		// na vrednost y koordinate tacke p1
		p.setX(point2.getY());

		// promeni y koordinatu tacke point2 na 50
		point2.setY(50);

		// 2. Postaviti za pocetnu tacku linije l1 tacku p, a
		// za krajnju tacku linije l1 tacku p1
		Line l1 = new Line();
		l1.setStartPoint(p);
		l1.setEndPoint(point2);

		// 3. Postaviti y koordinatu krajnje tacke l1 na 23
		l1.getEndPoint().setY(23);

		// 4. Promeniti vrednost x koordinate pocetne tacke linije l1
		// na vrednost y koordinate krajnje tacke linije l1
		l1.getStartPoint().setX(l1.getEndPoint().getY());

		// 5. Postaviti x koordinatu krajnje tacke l1 na vrednost
		// duzine linije l1 umanjene za vrednost zbira x i y
		// koordinate pocetne tacke linije l1
		l1.getEndPoint().setX((int) (l1.length() - (l1.getStartPoint().getX() + l1.getStartPoint().getY())));

		// 6. Postaviti x koordinatu tacke gore levo pravougaonika
		// r1 na vrednost 10 i y koordinatu na vrednost 15
		Rectangle r1 = new Rectangle();
		Point leftPoint = new Point();
		r1.setUpperLeftPoint(leftPoint);
		r1.getUpperLeftPoint().setX(10);
		r1.getUpperLeftPoint().setY(15);

		// 7. Postaviti centar kruga c1 na koordinate tacke
		// gore levo od r1
		Circle c1 = new Circle();
		c1.setCenter(r1.getUpperLeftPoint());

		// 8. Postaviti x koordinatu centra kruga c1 na vrednost razlike
		// povrsine pravougaonika r1 i y koordinate pocetne tacke linije l1
		r1.setHeight(20);
		r1.setWidth(30);
		c1.getCenter().setX(r1.area() - l1.getStartPoint().getY());

		// Vezbe 5
		/*
		 * Postaviti x koordinatu centra ranije kreiranog kruga circle1 na vrednost
		 * zbira vrednosti poluprečnika kruga circle1 i vrednosti koja predstavlja
		 * udaljenost početne i krajnje tačke prethodno kreirane linije line1 (koristiti
		 * metodu distance(), a ne length()).
		 */

		c1.getCenter().setX((int) (c1.getRadius() + l1.getStartPoint().distance(l1.getEndPoint())));

		Point p3 = new Point(10, 20);
		p3.setSelected(true);

		Point p4 = new Point(10, 20, true);
		System.out.println(p3.toString());

		System.out.println(p3.equals(p4));
		System.out.println(p3 == p4); // false

		p3 = p4;

		System.out.println(p3 == p4); // true

		// npr p4 je tacka klika
		// da li tacka p3 sadrzi tacku klika?
		p3.contains(p4.getX(), p4.getY());

		Donut donut1 = new Donut();
		donut1.setCenter(p4);
		Circle donut2 = new Donut(); // upcastovanje
		donut2.setCenter(p3);
		// Point donut3 = new Donut(); -- ne moze jer Donut nije tacka
		donut1.equals(donut2);
		donut1.getRadius();
		donut1.getInnerRadius();
		donut1.isSelected();
		System.out.println(donut1);

		// vezbe 6
		// ne mozemo kreirati objekat klase Shape jer je apstraktna
		// Shape shape1 = new Shape();
		// sa leve strane kod deklaracije moze apstraktna klasa ali sa desne mora
		// konkretna implementacija apst klase
		Shape shape1 = new Point(50, 60, true); // stvarni objekat u memoriji
		// kompajler dozvoljava shape1.toString() jer je toString iz Object klase
		// a interpreter prilikom izvrsavanja poziva toString iz Pointa zbog new Point()
		// a tamo je override metode
		System.out.println(shape1.toString());
		System.out.println(shape1.isSelected());

		//vebe 8
		//zadatak1
		Point[] points = new Point[4];
		points[0] = new Point(10, 10);
		points[1] = new Point(2, 2);
		points[2] = new Point(5, 6);
		points[3] = new Point(1, 4);
		
		System.out.println("---Nesortiran niz---");
		for (int i = 0; i < points.length; i++) {
		    Point point = points[i];
		    System.out.println(point);
		}
		
		Arrays.sort(points);

		System.out.println("\n ---Sortiran niz---");
		for (int i = 0; i < points.length; i++) {
		    Point point = points[i];
		    System.out.println(point); 
		}
		
		try {
			c1.setRadius(10);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
}