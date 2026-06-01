package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JToggleButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FrmTest extends JFrame {

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlCenter = new JPanel();
		contentPane.add(pnlCenter, BorderLayout.CENTER);
		GridBagLayout gbl_pnlCenter = new GridBagLayout();
		gbl_pnlCenter.columnWidths = new int[]{0, 0, 0, 0};
		gbl_pnlCenter.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_pnlCenter.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlCenter.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		pnlCenter.setLayout(gbl_pnlCenter);
		
		JToggleButton tglbtnCrvenaBoja = new JToggleButton("Crvena boja");
		buttonGroupBoje.add(tglbtnCrvenaBoja);
		tglbtnCrvenaBoja.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dlmBoje.addElement(lblCrvenaBoja.getText());
			}
		});
		GridBagConstraints gbc_tglbtnCrvenaBoja = new GridBagConstraints();
		gbc_tglbtnCrvenaBoja.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnCrvenaBoja.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnCrvenaBoja.gridx = 0;
		gbc_tglbtnCrvenaBoja.gridy = 0;
		pnlCenter.add(tglbtnCrvenaBoja, gbc_tglbtnCrvenaBoja);
		
	    lblCrvenaBoja = new JLabel("Crvena boja");
		GridBagConstraints gbc_lblCrvenaBoja = new GridBagConstraints();
		gbc_lblCrvenaBoja.insets = new Insets(0, 0, 5, 5);
		gbc_lblCrvenaBoja.gridx = 1;
		gbc_lblCrvenaBoja.gridy = 0;
		pnlCenter.add(lblCrvenaBoja, gbc_lblCrvenaBoja);
		
		JToggleButton tglbtnPlavaBoja = new JToggleButton("Plava boja");
		buttonGroupBoje.add(tglbtnPlavaBoja);
		GridBagConstraints gbc_tglbtnPlavaBoja = new GridBagConstraints();
		gbc_tglbtnPlavaBoja.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnPlavaBoja.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnPlavaBoja.gridx = 0;
		gbc_tglbtnPlavaBoja.gridy = 1;
		pnlCenter.add(tglbtnPlavaBoja, gbc_tglbtnPlavaBoja);
		
		lblPlavaBoja = new JLabel("Plava boja");
		GridBagConstraints gbc_lblPlavaBoja = new GridBagConstraints();
		gbc_lblPlavaBoja.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlavaBoja.gridx = 1;
		gbc_lblPlavaBoja.gridy = 1;
		pnlCenter.add(lblPlavaBoja, gbc_lblPlavaBoja);
		
		JToggleButton tglbtnZutaBoja = new JToggleButton("Zuta boja");
		buttonGroupBoje.add(tglbtnZutaBoja);
		GridBagConstraints gbc_tglbtnZutaBoja = new GridBagConstraints();
		gbc_tglbtnZutaBoja.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnZutaBoja.fill = GridBagConstraints.HORIZONTAL;
		gbc_tglbtnZutaBoja.gridx = 0;
		gbc_tglbtnZutaBoja.gridy = 2;
		pnlCenter.add(tglbtnZutaBoja, gbc_tglbtnZutaBoja);
		
	    lblZutaBoja = new JLabel("Zuta boja");
		GridBagConstraints gbc_lblZutaBoja = new GridBagConstraints();
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
	}

}
