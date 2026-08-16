package stack;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Donut;
import geometry.Point;

import java.awt.BorderLayout;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Color;
import java.util.Stack;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class FrmStack extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private DefaultListModel<Donut> dlm = new DefaultListModel<Donut>(); // dinamicki dodeljuje elemente u listu, da ih
																			// ne pisemo rucno u listu
	private DlgStack dialog = new DlgStack(); // objekat dijaloga koji se ponovo koristi
	private Stack<Donut> stack = new Stack<Donut>(); // pravim stek kako bih mogla da koristim LIFO princip

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmStack frame = new FrmStack();
					frame.setVisible(true); // prikaz glavnog prozora
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmStack() {
		setTitle("Katarina Susnjevic IT 3/2025");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // zatvaranje aplikacije na X dugme
		setBounds(100, 100, 448, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(179, 179, 217));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel pnlCentar = new JPanel();
		pnlCentar.setBackground(new Color(238, 238, 247));
		contentPane.add(pnlCentar, BorderLayout.CENTER);

		JScrollPane scrPnlStack = new JScrollPane();
		pnlCentar.add(scrPnlStack);

		JList lstStack = new JList();
		scrPnlStack.setViewportView(lstStack); // prvo se dodaje scrollPane a zatim lista u njega (lista nema mogucnost
												// skrolovanja)

		lstStack.setModel(dlm); // da bi spojili listu i default list model

		JPanel pnlSouth = new JPanel();
		pnlSouth.setBackground(new Color(238, 238, 247));
		contentPane.add(pnlSouth, BorderLayout.SOUTH);

		// dodavanje na stek
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Arial", Font.BOLD, 10));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialog.setTitle("Add donut");
				dialog.setVisible(true); // otvaranje modalnog dijaloga za dodavanje, povezan dijalog sa frejmom
				if (dialog.isOk()) { // ovo je metoda iz getera i setera koja proverava boolean (da li je korisnik
										// popunio i kliknuo OK)

					try {
						// parsovanje u celobrojne vrednosti iz dijaloga
						int x = Integer.parseInt(dialog.getTxtX().getText()); // uzimam podatke iz fielda
						int y = Integer.parseInt(dialog.getTxtY().getText());
						int radius = Integer.parseInt(dialog.getTxtRadius().getText());
						int innerRadius = Integer.parseInt(dialog.getTxtInnerRadius().getText());

						// pravim objekat kom ce biti dodeljene vrednosti (konstruktor je iz donut)
						Donut donut = new Donut(new Point(x, y), radius, innerRadius);
						stack.push(donut);// pusuje objekat na vrh steka
						dlm.add(0, donut);// dodaje objekat u listu LIFO princip

						// praznjenje polja dijaloga nakon uspesnog unosa
						dialog.getTxtX().setText("");
						dialog.getTxtY().setText("");
						dialog.getTxtRadius().setText("");
						dialog.getTxtInnerRadius().setText("");

					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(null, "Values are not entered!", "Error message!",
								JOptionPane.ERROR_MESSAGE);
					}

				}
			}
		});

		btnAdd.setBackground(new Color(179, 179, 217));
		pnlSouth.add(btnAdd);

		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// provera da li na steku uopste ima elemenata
				if (!dlm.isEmpty()) {

					dialog.setTitle("Remove donut");
					
					// uzimamo element sa vrha steka preko peek bez brisanja
					Donut donut = stack.peek(); // uzima prvu vrednost (ceo objekat) liste i dodeljuje ga u donut

					// popunjavanje dijaloga konkretnim vrednostima objekta sa vrha steka
					// obrnuti proces od dodavanja
					// uzimam vrednosti iz donut, konvertujem i upisujem u textfield
					dialog.getTxtX().setText(Integer.toString(donut.getCenter().getX()));
					dialog.getTxtY().setText(Integer.toString(donut.getCenter().getY()));
					dialog.getTxtRadius().setText(Integer.toString(donut.getRadius()));
					dialog.getTxtInnerRadius().setText(Integer.toString(donut.getInnerRadius()));

					// da vrednosti ne mogu da se menjaju nego da se samo prikazu
					dialog.getTxtX().setEnabled(false);
					dialog.getTxtY().setEnabled(false);
					dialog.getTxtRadius().setEnabled(false);
					dialog.getTxtInnerRadius().setEnabled(false);

					dialog.setVisible(true); // prikazuje dijalog

					// ako je korisnik kliknuo na ok
					if (dialog.isOk()) {
						stack.pop(); // izuzimanje objekta sa steka
						dlm.removeElementAt(0); // brisanje po lifo

						// ciscenje i ponovno otkljucavanje polja za buduce dodavanje
						dialog.getTxtX().setText("");
						dialog.getTxtY().setText("");
						dialog.getTxtRadius().setText("");
						dialog.getTxtInnerRadius().setText("");
						dialog.getTxtX().setEnabled(true);
						dialog.getTxtY().setEnabled(true);
						dialog.getTxtRadius().setEnabled(true);
						dialog.getTxtInnerRadius().setEnabled(true);
					}
				}
				// ako je kliknuo cancel, isOk je false, pa se blok if(dialog.isOk()) preskače
				// čime korisnik odustaje od brisanja

				else {
					JOptionPane.showMessageDialog(null, "Stack is empty!", "Information",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		btnDelete.setFont(new Font("Arial", Font.BOLD, 10));
		btnDelete.setBackground(new Color(252, 3, 61));
		pnlSouth.add(btnDelete);

		JLabel lblNewLabel = new JLabel("DONUT STACK");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
	}

}
