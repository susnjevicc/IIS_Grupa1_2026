package drawing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Point;

import java.awt.BorderLayout;
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
		buttonGroup.add(BtnLine);
		panel_1.add(BtnLine);
		
		JToggleButton BtnRectangle = new JToggleButton("Rectangle");
		buttonGroup.add(BtnRectangle);
		panel_1.add(BtnRectangle);
		
		JToggleButton BtnCircle = new JToggleButton("Circle");
		buttonGroup.add(BtnCircle);
		panel_1.add(BtnCircle);
		
		JToggleButton BtnDonut = new JToggleButton("Donut");
		buttonGroup.add(BtnDonut);
		panel_1.add(BtnDonut);
		
		JToggleButton BtnSelect = new JToggleButton("Select");
		buttonGroup.add(BtnSelect);
		panel_1.add(BtnSelect);
		
		JButton BtnModify = new JButton("Modify");
		panel_1.add(BtnModify);
		
		JButton BtnDelete = new JButton("Delete");
		panel_1.add(BtnDelete);

	}

}
