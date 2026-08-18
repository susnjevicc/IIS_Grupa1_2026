package drawing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmDrawing extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private String action;
	private Point startPoint = null;  //za Line

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmDrawing frame = new FrmDrawing();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmDrawing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		PnlDrawing panel = new PnlDrawing();
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (action == "Point") {
					startPoint = null;
					DlgPoint Point = new DlgPoint();
					Point.txtX.setText(Integer.toString(e.getX()));
					Point.txtY.setText(Integer.toString(e.getY()));
					Point.setVisible(true);
					if(Point.isOk) {
						String X = Point.txtX.getText();
						String Y = Point.txtY.getText();
						Point newPoint = new Point(Integer.parseInt(X), Integer.parseInt(Y));
						newPoint.setColor(Point.btnColor.getBackground());
						panel.addShape(newPoint);
						
					}
					
				}else if(action == "Line"){
					if(startPoint == null) {
                        startPoint = new Point(e.getX(), e.getY());
                    }
					else {
						DlgLine Line = new DlgLine();
						Line.txtX.setText(Integer.toString(startPoint.getX()));
						Line.txtY.setText(Integer.toString(startPoint.getY()));
						Line.txtX2.setText(Integer.toString(e.getX()));
						Line.txtY2.setText(Integer.toString(e.getY()));
						Line.setVisible(true);
						if(Line.isOk) {
							String X = Line.txtX.getText();
							String Y = Line.txtY.getText();
							String X2 = Line.txtX2.getText();
							String Y2 = Line.txtY2.getText();
							Point newPoint = new Point(Integer.parseInt(X), Integer.parseInt(Y));
							Point endPoint = new Point(Integer.parseInt(X2), Integer.parseInt(Y2));
							Line newLine = new Line(startPoint, endPoint);
							newLine.setColor(Line.btnColor.getBackground());
							panel.addShape(newLine);
							
							
						}
						startPoint = null;
					}
				}else if(action == "Rectangle") {
					startPoint = null;
					DlgRectangle Rectangle = new DlgRectangle();
					Rectangle.txtX.setText(Integer.toString(e.getX()));
					Rectangle.txtY.setText(Integer.toString(e.getY()));
					Rectangle.setVisible(true);
					if(Rectangle.isOk) {
						String X = Rectangle.txtX.getText();
						String Y = Rectangle.txtY.getText();
						String Width = Rectangle.txtWidth.getText();
						String Height = Rectangle.txtHeight.getText();
						Point newPoint = new Point(Integer.parseInt(X), Integer.parseInt(Y));
						Rectangle newRectangle = new Rectangle(newPoint,Integer.parseInt(Width), Integer.parseInt(Height));
						newRectangle.setColor(Rectangle.btnColor.getBackground());
						newRectangle.setInnerColor(Rectangle.btnInnerColor.getBackground());
						panel.addShape(newRectangle);
					}
				}else if(action == "Circle"){
					startPoint = null;
					DlgCircle Circle = new DlgCircle();
					Circle.txtX.setText(Integer.toString(e.getX()));
					Circle.txtY.setText(Integer.toString(e.getY()));
					Circle.setVisible(true);
					if(Circle.isOk) {
						String X = Circle.txtX.getText();
						String Y = Circle.txtY.getText();
						String Radius = Circle.txtRadius.getText();
						Point newPoint = new Point(Integer.parseInt(X), Integer.parseInt(Y));
						Circle newCircle = new Circle(newPoint,Integer.parseInt(Radius));
						newCircle.setColor(Circle.btnColor.getBackground());
						newCircle.setInnerColor(Circle.btnInnerColor.getBackground());
						panel.addShape(newCircle);
					}
				}else if(action == "Donut") {
					startPoint = null;
					DlgDonut Donut = new DlgDonut();
					Donut.txtX.setText(Integer.toString(e.getX()));
					Donut.txtY.setText(Integer.toString(e.getY()));
					Donut.setVisible(true);
					if(Donut.isOk) {
						String X = Donut.txtX.getText();
						String Y = Donut.txtY.getText();
						String Radius = Donut.txtRadius.getText();
						String innerRadius = Donut.txtinnerRadius.getText();
						Point newPoint = new Point(Integer.parseInt(X), Integer.parseInt(Y));
						Donut newDonut = new Donut(newPoint,Integer.parseInt(Radius), Integer.parseInt(innerRadius));
						newDonut.setColor(Donut.btnColor.getBackground());
						newDonut.setInnerColor(Donut.btnInnerColor.getBackground());
						panel.addShape(newDonut);
					}
					
				}else if(action == "Select") {
					panel.selectShape(e.getX(), e.getY());
				}
				
			}
		});
		contentPane.add(panel, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JToggleButton BtnPoint = new JToggleButton("Point");
		BtnPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				action = "Point";
			}
		});
		buttonGroup.add(BtnPoint);
		panel_1.add(BtnPoint);
		
		JToggleButton BtnLine = new JToggleButton("Line");
		BtnLine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				action = "Line";
			}
		});
		buttonGroup.add(BtnLine);
		panel_1.add(BtnLine);
		
		JToggleButton BtnRectangle = new JToggleButton("Rectangle");
		BtnRectangle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				action = "Rectangle";
			}
		});
		buttonGroup.add(BtnRectangle);
		panel_1.add(BtnRectangle);
		
		JToggleButton BtnCircle = new JToggleButton("Circle");
		BtnCircle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				action = "Circle";
			}
		});
		buttonGroup.add(BtnCircle);
		panel_1.add(BtnCircle);
		
		JToggleButton BtnDonut = new JToggleButton("Donut");
		BtnDonut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				action = "Donut";
			}
		});
		buttonGroup.add(BtnDonut);
		panel_1.add(BtnDonut);
		
		JToggleButton BtnSelect = new JToggleButton("Select");
		BtnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				action = "Select";
			}
		});
		buttonGroup.add(BtnSelect);
		panel_1.add(BtnSelect);
		
		JButton BtnModify = new JButton("Modify");
		BtnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (panel.selectedShape == null) {
					JOptionPane.showMessageDialog(null, "There is no selected object to modify!", "Error", JOptionPane.ERROR_MESSAGE);
				}else {
					if (panel.selectedShape instanceof Point) {
						Point selectedPoint = (Point) panel.selectedShape;
						DlgPoint Point = new DlgPoint();
						Point.txtX.setText(Integer.toString(selectedPoint.getX()));
						Point.txtY.setText(Integer.toString(selectedPoint.getY()));
						Point.btnColor.setBackground(selectedPoint.getColor());
						Point.setVisible(true);
						if (Point.isOk) {
							int x = Integer.parseInt(Point.txtX.getText());
                            int y = Integer.parseInt(Point.txtY.getText());
                            Color color = Point.btnColor.getBackground();
                            panel.selectedShape.moveTo(x, y);
                            panel.selectedShape.setColor(color);
                            panel.selectShape(-1, -1);
						}
					
					}else if(panel.selectedShape instanceof Line) {
						Line selectedLine = (Line) panel.selectedShape;
						DlgLine Line = new DlgLine();
						Line.txtX.setText(Integer.toString(selectedLine.getStartPoint().getX()));
						Line.txtY.setText(Integer.toString(selectedLine.getStartPoint().getY()));
						Line.txtX2.setText(Integer.toString(selectedLine.getEndPoint().getX()));
						Line.txtY2.setText(Integer.toString(selectedLine.getEndPoint().getY()));
						Line.btnColor.setBackground(selectedLine.getColor());
						Line.setVisible(true);
						if (Line.isOk) {
							  int x = Integer.parseInt(Line.txtX.getText());
	                            int y = Integer.parseInt(Line.txtY.getText());
	                            int x2 = Integer.parseInt(Line.txtX2.getText());
	                            int y2 = Integer.parseInt(Line.txtY2.getText());
	                            Color color = Line.btnColor.getBackground();
	                            panel.selectedShape.moveTo(x, y);
	                            selectedLine.setEndPoint(new Point(x2,y2));
	                            panel.selectedShape.setColor(color);
	                            panel.selectShape(-1, -1);
						}
						
						
					}else if(panel.selectedShape instanceof Rectangle) {
						Rectangle selectedRectangle= (Rectangle) panel.selectedShape;
						DlgRectangle Rectangle = new DlgRectangle();
						Rectangle.txtX.setText(Integer.toString(selectedRectangle.getUpperLeftPoint().getX()));
						Rectangle.txtY.setText(Integer.toString(selectedRectangle.getUpperLeftPoint().getY()));
						Rectangle.txtWidth.setText(Integer.toString(selectedRectangle.getWidth()));
						Rectangle.txtHeight.setText(Integer.toString(selectedRectangle.getHeight()));
						Rectangle.btnColor.setBackground(selectedRectangle.getColor());
						Rectangle.btnInnerColor.setBackground(selectedRectangle.getInnerColor());
						Rectangle.setVisible(true);
						if (Rectangle.isOk) {
							  int x = Integer.parseInt(Rectangle.txtX.getText());
	                            int y = Integer.parseInt(Rectangle.txtY.getText());
	                            int width = Integer.parseInt(Rectangle.txtWidth.getText());
	                            int height = Integer.parseInt(Rectangle.txtHeight.getText());
	                            Color color = Rectangle.btnColor.getBackground();
	                            Color innerColor = Rectangle.btnInnerColor.getBackground();
	                            panel.selectedShape.moveTo(x, y);
	                            selectedRectangle.setWidth(width);
	                            selectedRectangle.setHeight(height);
	                            panel.selectedShape.setColor(color);
	                            panel.selectedShape.setInnerColor(innerColor);
	                            panel.selectShape(-1, -1);
						}
					}
				
					
				}
			
			}
		});
		panel_1.add(BtnModify);
		
		JButton BtnDelete = new JButton("Delete");
		panel_1.add(BtnDelete);

	}

}
