package drawing;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JToggleButton;
import javax.swing.JButton;

public class FrmDrawing extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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
		contentPane.add(panel, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JToggleButton BtnPoint = new JToggleButton("Point");
		panel_1.add(BtnPoint);
		
		JToggleButton BtnLine = new JToggleButton("Line");
		panel_1.add(BtnLine);
		
		JToggleButton BtnRectangle = new JToggleButton("Rectangle");
		panel_1.add(BtnRectangle);
		
		JToggleButton BtnCircle = new JToggleButton("Circle");
		panel_1.add(BtnCircle);
		
		JToggleButton BtnDonut = new JToggleButton("Donut");
		panel_1.add(BtnDonut);
		
		JToggleButton BtnSelect = new JToggleButton("Select");
		panel_1.add(BtnSelect);
		
		JButton BtnModify = new JButton("Modify");
		panel_1.add(BtnModify);
		
		JButton BtnDelete = new JButton("Delete");
		panel_1.add(BtnDelete);

	}

}
