package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

import geometry.Circle;
import geometry.Donut;
import geometry.Point;
import geometry.Shape;

public class DrawingPanel extends JPanel {
	public DrawingPanel() {
	}

	@Override
	public void paint(Graphics g) {
		// obavezno sper.paint(g)
		// obavezno super.paint(g)
		super.paint(g);
		Circle circle1 = new Circle(new Point(100,200), 50);
		circle1.draw(g);

		Shape shape1 = new Circle(new Point(100,200), 150);
		System.out.println(shape1.toString());
		shape1.draw(g);
		System.out.println(((Circle)shape1).area());

		Point point1 = new Point(250,350);
		point1.draw(g);
		point1.moveBy(50, 50);
		point1.draw(g);

		Donut donut1 = new Donut(new Point(400,500), 50, 40);
		Donut donut2 = new Donut(new Point(450,550), 60, 40);
		donut1.compareTo(donut2);
		
		// Vezbe 8
		// Zadatak 1
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		shapes.add(donut2);
		shapes.add(donut1);
		System.out.println("Nesortirana lista");
		for (int i = 0; i < shapes.size(); i++) {
			System.out.println(shapes.get(i));
		}
		shapes.sort(null); // u pozadini poziva compareTo
		System.out.println("Sortirana lista");
		for (Shape shape : shapes) {
			System.out.println(shape);
			g.setColor(Color.red);
			shape.draw(g);
		}
		
		// obrada izuzetka
		/*Integer.parseInt("pet");
		System.out.println("1 - Da li cu se izvrsiti?");*/
		
		try {
			Integer.parseInt("pet");
			System.out.println("Bice greska");
		} catch (NumberFormatException nfe) {
			System.out.println("Greska NFE");
			//nfe.printStackTrace();
		} finally {
			System.out.println("Finally - Da li cu se izvrsiti?");
		}
		System.out.println("2 - Da li cu se izvrsiti?");
		
		Point p = new Point(200,300,false);
		g.setColor(Color.green);
		p.draw(g);
		p.setSelected(true);
		p.draw(g);
		
	}
		
	}