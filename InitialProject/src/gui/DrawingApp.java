package gui;

import javax.swing.JFrame;

public class DrawingApp {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Drawing");
		frame.setSize(800,600);
		
		
		DrawingPanel drawingPanel = new DrawingPanel();
		//povezivanje frame i panel 
		frame.getContentPane().add(drawingPanel);
		
		
		frame.setVisible(true);
		
	}

	
}
