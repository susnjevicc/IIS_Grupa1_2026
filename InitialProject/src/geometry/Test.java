package geometry;

public class Test {

	public static void main(String[] args) {
		Point p = new Point ();
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
            
        //promeni y koordinatu tacke point2 na 50
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
        l1.getEndPoint().setX((int)(l1.length()-(l1.getStartPoint().getX()+l1.getStartPoint().getY())));


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


	}

}