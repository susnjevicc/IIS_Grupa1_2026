package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JToggleButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JColorChooser;

public class FrmTest extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroupBoje = new ButtonGroup();
	private DefaultListModel<String> dlmBoje = new DefaultListModel<String>();
	private JLabel lblCrvenaBoja;
	private JLabel lblPlavaBoja;
	private JLabel lblZutaBoja;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTest frame = new FrmTest();
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
	public FrmTest() {
		setTitle("Dodavanje boja");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel pnlCenter = new JPanel();
		contentPane.add(pnlCenter, BorderLayout.CENTER);
		GridBagLayout gbl_pnlCenter = new GridBagLayout();
		gbl_pnlCenter.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_pnlCenter.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_pnlCenter.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_pnlCenter.rowWeights = new double[] { 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		pnlCenter.setLayout(gbl_pnlCenter);

		JToggleButton tglbtnCrvenaBoja = new JToggleButton("Crvena boja");
		tglbtnCrvenaBoja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlmBoje.addElement(lblCrvenaBoja.getText());
				lblCrvenaBoja.setForeground(Color.red);
				lblPlavaBoja.setForeground(Color.black);
				lblZutaBoja.setForeground(Color.black);
			}
		});
		buttonGroupBoje.add(tglbtnCrvenaBoja);
		GridBagConstraints gbc_tglbtnCrvenaBoja = new GridBagConstraints();
		gbc_tglbtnCrvenaBoja.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnCrvenaBoja.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnCrvenaBoja.gridx = 0;
		gbc_tglbtnCrvenaBoja.gridy = 0;
		pnlCenter.add(tglbtnCrvenaBoja, gbc_tglbtnCrvenaBoja);

		lblCrvenaBoja = new JLabel("Crvena boja");
		GridBagConstraints gbc_lblCrvenaBoja = new GridBagConstraints();
		gbc_lblCrvenaBoja.anchor = GridBagConstraints.WEST;
		gbc_lblCrvenaBoja.insets = new Insets(0, 0, 5, 5);
		gbc_lblCrvenaBoja.gridx = 1;
		gbc_lblCrvenaBoja.gridy = 0;
		pnlCenter.add(lblCrvenaBoja, gbc_lblCrvenaBoja);

		JToggleButton tglbtnPlavaBoja = new JToggleButton("Plava boja");
		tglbtnPlavaBoja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlmBoje.addElement(lblPlavaBoja.getText());
				lblPlavaBoja.setForeground(Color.blue);
				lblCrvenaBoja.setForeground(Color.black);
				lblZutaBoja.setForeground(Color.black);
			}
		});
		buttonGroupBoje.add(tglbtnPlavaBoja);
		GridBagConstraints gbc_tglbtnPlavaBoja = new GridBagConstraints();
		gbc_tglbtnPlavaBoja.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnPlavaBoja.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnPlavaBoja.gridx = 0;
		gbc_tglbtnPlavaBoja.gridy = 1;
		pnlCenter.add(tglbtnPlavaBoja, gbc_tglbtnPlavaBoja);

		lblPlavaBoja = new JLabel("Plava boja");
		GridBagConstraints gbc_lblPlavaBoja = new GridBagConstraints();
		gbc_lblPlavaBoja.anchor = GridBagConstraints.WEST;
		gbc_lblPlavaBoja.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlavaBoja.gridx = 1;
		gbc_lblPlavaBoja.gridy = 1;
		pnlCenter.add(lblPlavaBoja, gbc_lblPlavaBoja);

		JToggleButton tglbtnZutaBoja = new JToggleButton("Zuta boja");
		tglbtnZutaBoja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlmBoje.addElement(lblZutaBoja.getText());
				lblZutaBoja.setForeground(Color.yellow);
				lblPlavaBoja.setForeground(Color.black);
				lblCrvenaBoja.setForeground(Color.black);
			}
		});
		buttonGroupBoje.add(tglbtnZutaBoja);
		GridBagConstraints gbc_tglbtnZutaBoja = new GridBagConstraints();
		gbc_tglbtnZutaBoja.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnZutaBoja.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnZutaBoja.gridx = 0;
		gbc_tglbtnZutaBoja.gridy = 2;
		pnlCenter.add(tglbtnZutaBoja, gbc_tglbtnZutaBoja);

		lblZutaBoja = new JLabel("Zuta boja");
		GridBagConstraints gbc_lblZutaBoja = new GridBagConstraints();
		gbc_lblZutaBoja.anchor = GridBagConstraints.WEST;
		gbc_lblZutaBoja.insets = new Insets(0, 0, 5, 5);
		gbc_lblZutaBoja.gridx = 1;
		gbc_lblZutaBoja.gridy = 2;
		pnlCenter.add(lblZutaBoja, gbc_lblZutaBoja);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 3;
		pnlCenter.add(scrollPane, gbc_scrollPane);

		JList<String> listBoje = new JList<String>();
		scrollPane.setViewportView(listBoje);
		listBoje.setModel(dlmBoje);

		JPanel pnlSouth = new JPanel();
		contentPane.add(pnlSouth, BorderLayout.SOUTH);
		GridBagLayout gbl_pnlSouth = new GridBagLayout();
		gbl_pnlSouth.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_pnlSouth.rowHeights = new int[] { 0, 0 };
		gbl_pnlSouth.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_pnlSouth.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		pnlSouth.setLayout(gbl_pnlSouth);

		JButton btnAntistresDugme = new JButton("Antistres dugme");
		btnAntistresDugme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
// koristicemo staticku metodu
				JOptionPane.showMessageDialog(null, "Antistres dugme", "Poruka", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		GridBagConstraints gbc_btnAntistresDugme = new GridBagConstraints();
		gbc_btnAntistresDugme.insets = new Insets(0, 0, 0, 5);
		gbc_btnAntistresDugme.gridx = 0;
		gbc_btnAntistresDugme.gridy = 0;
		pnlSouth.add(btnAntistresDugme, gbc_btnAntistresDugme);

		JButton btnBoje = new JButton("Dodaj boju");
		btnBoje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgTest dlgTest = new DlgTest();
				dlgTest.setVisible(true);

				if (dlgTest.isOk) {
					dlmBoje.addElement(dlgTest.getTxtRed().getText() + " " + dlgTest.getTxtGreen().getText() + " "
							+ dlgTest.getTxtBlue().getText());
					Color pnlBoja = new Color(Integer.parseInt(dlgTest.getTxtRed().getText()),
							Integer.parseInt(dlgTest.getTxtGreen().getText()),
							Integer.parseInt(dlgTest.getTxtBlue().getText()));
					pnlCenter.setBackground(pnlBoja);
				}

			}
		});
		GridBagConstraints gbc_btnBoje = new GridBagConstraints();
		gbc_btnBoje.insets = new Insets(0, 0, 0, 5);
		gbc_btnBoje.gridx = 1;
		gbc_btnBoje.gridy = 0;
		pnlSouth.add(btnBoje, gbc_btnBoje);

		JButton btnIzmeniBoju = new JButton("Izmeni boju");
		btnIzmeniBoju.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DlgTest dlgIzmeniBoju = new DlgTest();
				int index = listBoje.getSelectedIndex();

				if (index > -1) {
					String[] split = dlmBoje.getElementAt(index).toString().split(" ");
					dlgIzmeniBoju.getTxtRed().setText(split[0]);
					dlgIzmeniBoju.getTxtGreen().setText(split[1]);
					dlgIzmeniBoju.getTxtBlue().setText(split[2]);
					// posle setovanja tekstualnih polja!!
					dlgIzmeniBoju.setVisible(true);
					if (dlgIzmeniBoju.isOk) {
						dlmBoje.setElementAt(dlgIzmeniBoju.getTxtRed().getText() + " "
								+ dlgIzmeniBoju.getTxtGreen().getText() + " " + dlgIzmeniBoju.getTxtBlue().getText(),
								index);
						Color pnlBoja = new Color(Integer.parseInt(dlgIzmeniBoju.getTxtRed().getText()),
								Integer.parseInt(dlgIzmeniBoju.getTxtGreen().getText()),
								Integer.parseInt(dlgIzmeniBoju.getTxtBlue().getText()));
						pnlCenter.setBackground(pnlBoja);
					}
				}

			}
		});
		GridBagConstraints gbc_btnIzmeniBoju = new GridBagConstraints();
		gbc_btnIzmeniBoju.insets = new Insets(0, 0, 0, 5);
		gbc_btnIzmeniBoju.gridx = 2;
		gbc_btnIzmeniBoju.gridy = 0;
		pnlSouth.add(btnIzmeniBoju, gbc_btnIzmeniBoju);

		JButton btnIzaberiBoju = new JButton("Izaberi boju");
		btnIzaberiBoju.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color izabranaBoja = JColorChooser.showDialog(null, "Izaberi boju", Color.black);
				pnlCenter.setBackground(izabranaBoja);
			}
		});
		GridBagConstraints gbc_btnIzaberiBoju = new GridBagConstraints();
		gbc_btnIzaberiBoju.insets = new Insets(0, 0, 0, 5);
		gbc_btnIzaberiBoju.gridx = 3;
		gbc_btnIzaberiBoju.gridy = 0;
		pnlSouth.add(btnIzaberiBoju, gbc_btnIzaberiBoju);

		JPanel pnlNorth = new JPanel();
		pnlNorth.setBackground(new Color(0, 255, 128));
		contentPane.add(pnlNorth, BorderLayout.NORTH);

		JLabel lblNaslov = new JLabel("Zadatak 1");
		pnlNorth.add(lblNaslov);

	}

}