package gui;

import java.awt.Color;
import java.awt.Graphics; 
import java.util.ArrayList;
import java.util.HashMap; 
import java.util.Iterator;

import javax.swing.JPanel; 

import geometry.Circle; 
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Shape;

public class DrawingPanel extends JPanel { // JPanel je ugradjena Java klasa

	public DrawingPanel() {

	}

	@Override
	public void paint(Graphics g) {  
		super.paint(g);    //poziva metodu paint iz JPanel, da bi brisao prethodni sadrzaj i prebojio pozadinu panela
		
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
		
		
		
		Line line1 = new Line(new Point(10, 10), new Point(30,30));
		Rectangle rec1 = new Rectangle(new Point(100,100), 20, 30);
		
		//vezbe 8
		//zadatak 2
		ArrayList<Shape> shapes = new ArrayList<Shape>();
		shapes.add(point1);
		shapes.add(line1);
		shapes.add(circle1);
		shapes.add(donut1);
		shapes.add(rec1);
		
		for(Shape shape : shapes) {
			shape.moveBy(10, 0);
			
		}
		
		//zadatak 3
		shapes.get(3).draw(g);
		shapes.get(shapes.size() - 1).draw(g);
		shapes.remove(1);
		shapes.get(1).draw(g);
		shapes.get(3).draw(g);
		shapes.add(3, line1);
		
		
		
		//zadatak 4
		HashMap <String, Shape> hmShapes = new HashMap <String, Shape>();
		hmShapes.put("Point", point1);
		hmShapes.put("Line", line1);
		hmShapes.put("Circle", circle1);
		
		System.out.println(hmShapes.get("Point"));
		System.out.println(hmShapes.get("Line"));
		
		Point p = new Point(200,300,false);
		g.setColor(Color.green);
		p.draw(g);
		p.setSelected(true);
		p.draw(g);
		
	

	// obrada izuzetka
	/*
	 * Integer.parseInt("pet"); System.out.println("1 - Da li cu se izvrsiti?");
	 */

	try

	{
		Integer.parseInt("pet");
		System.out.println("Bice greska");
	}catch(
	NumberFormatException nfe)
	{
		System.out.println("Greska NFE");
		// nfe.printStackTrace();
	}finally
	{
		System.out.println("Finally - Da li cu se izvrsiti?");
	}System.out.println("2 - Da li cu se izvrsiti?");

	Point p2 = new Point(200, 300, false);g.setColor(Color.green);p.draw(g);p.setSelected(true);p.draw(g);

	}
}
