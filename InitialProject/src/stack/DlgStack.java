package stack;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometry.Donut;
import geometry.Point;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class DlgStack extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtX;
	private JTextField txtY;
	private JTextField txtRadius;
	private JTextField txtInnerRadius;
	private boolean isOk;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgStack dialog = new DlgStack(); 
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgStack() {
		setModal(true); //blokira pristup pozadinskom prozoru dok je otvoren
		setBackground(new Color(255, 255, 255));
		setTitle("Create donut");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout()); 
		contentPanel.setBackground(new Color(238, 238, 247)); //unutrasnji panel 
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5)); //margine 
		getContentPane().add(contentPanel, BorderLayout.CENTER); 
		GridBagLayout gbl_contentPanel = new GridBagLayout();  //precizno poravnanje labela i tekstualnih polja 
		gbl_contentPanel.columnWidths = new int[] { 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblX = new JLabel("Enter the X coordinate: ");  
			lblX.setFont(new Font("Arial", Font.BOLD, 11)); 
			GridBagConstraints gbc_lblX = new GridBagConstraints(); //mrezna podesavanja pozicije 
			gbc_lblX.insets = new Insets(0, 0, 5, 5);  //margina 
			gbc_lblX.anchor = GridBagConstraints.NORTHEAST;  
			gbc_lblX.gridx = 0; 
			gbc_lblX.gridy = 0;  
			contentPanel.add(lblX, gbc_lblX);  //dodavanje labele na panel 
		}
		{
			txtX = new JTextField();   
			GridBagConstraints gbc_txtX = new GridBagConstraints();
			gbc_txtX.insets = new Insets(0, 0, 5, 0);
			gbc_txtX.fill = GridBagConstraints.HORIZONTAL;  
			gbc_txtX.gridx = 1;   
			gbc_txtX.gridy = 0;   
			contentPanel.add(txtX, gbc_txtX);
			txtX.setColumns(10);
		}
		{
			JLabel lblY = new JLabel("Enter the Y coordinate: ");
			lblY.setFont(new Font("Arial", Font.BOLD, 11));
			GridBagConstraints gbc_lblY = new GridBagConstraints();
			gbc_lblY.anchor = GridBagConstraints.EAST;
			gbc_lblY.insets = new Insets(0, 0, 5, 5);
			gbc_lblY.gridx = 0;
			gbc_lblY.gridy = 1;
			contentPanel.add(lblY, gbc_lblY);
		}
		{
			txtY = new JTextField();
			GridBagConstraints gbc_txtY = new GridBagConstraints();
			gbc_txtY.insets = new Insets(0, 0, 5, 0);
			gbc_txtY.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtY.gridx = 1;
			gbc_txtY.gridy = 1;
			contentPanel.add(txtY, gbc_txtY);
			txtY.setColumns(10);
		}
		{
			JLabel lblRadius = new JLabel("Enter radius: ");
			lblRadius.setFont(new Font("Arial", Font.BOLD, 11));
			GridBagConstraints gbc_lblRadius = new GridBagConstraints();
			gbc_lblRadius.anchor = GridBagConstraints.EAST;
			gbc_lblRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblRadius.gridx = 0;
			gbc_lblRadius.gridy = 2;
			contentPanel.add(lblRadius, gbc_lblRadius);
		}
		{
			txtRadius = new JTextField();
			GridBagConstraints gbc_txtRadius = new GridBagConstraints();
			gbc_txtRadius.insets = new Insets(0, 0, 5, 0);
			gbc_txtRadius.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtRadius.gridx = 1;
			gbc_txtRadius.gridy = 2;
			contentPanel.add(txtRadius, gbc_txtRadius);
			txtRadius.setColumns(10);
		}
		{
			JLabel lblInnerRadius = new JLabel("Enter inner radius: ");
			lblInnerRadius.setFont(new Font("Arial", Font.BOLD, 11));
			GridBagConstraints gbc_lblInnerRadius = new GridBagConstraints();
			gbc_lblInnerRadius.anchor = GridBagConstraints.EAST;
			gbc_lblInnerRadius.insets = new Insets(0, 0, 0, 5);
			gbc_lblInnerRadius.gridx = 0;
			gbc_lblInnerRadius.gridy = 3;
			contentPanel.add(lblInnerRadius, gbc_lblInnerRadius);
		}
		{
			txtInnerRadius = new JTextField();
			GridBagConstraints gbc_txtInnerRadius = new GridBagConstraints();
			gbc_txtInnerRadius.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtInnerRadius.gridx = 1;
			gbc_txtInnerRadius.gridy = 3;
			contentPanel.add(txtInnerRadius, gbc_txtInnerRadius);
			txtInnerRadius.setColumns(10);
		}

		{
			JPanel buttonPane = new JPanel();   //dugmad
			buttonPane.setBackground(new Color(238, 238, 247));
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));  
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setFont(new Font("Arial", Font.BOLD, 10));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// obrada mogucih izuzetaka
						// JOptionalPane je klasa koja omogucava pop-up prozore
						try {  
							if (txtX.getText().isEmpty()) { 
								JOptionPane.showMessageDialog(null, "Please, enter a value.", "Error message!",
										JOptionPane.ERROR_MESSAGE);
							} else if (txtY.getText().isEmpty()) {
								JOptionPane.showMessageDialog(null, "Please, enter a value.", "Error message!",
										JOptionPane.ERROR_MESSAGE);
							} else if (txtRadius.getText().isEmpty()) {
								JOptionPane.showMessageDialog(null, "Please, enter a value.", "Error message!",
										JOptionPane.ERROR_MESSAGE);
							} else if (txtInnerRadius.getText().isEmpty()) {
								JOptionPane.showMessageDialog(null, "Please, enter a value.", "Error message!",
										JOptionPane.ERROR_MESSAGE);
							} else { // ako polja nisu prazna, nastavljamo dalje i parsujemo unete podatke
								Integer.parseInt(txtX.getText());  
								Integer.parseInt(txtY.getText());  
								// nastavak provere
								if (Integer.parseInt(txtRadius.getText()) <= 0
										|| Integer.parseInt(txtInnerRadius.getText()) <= 0) {
									JOptionPane.showMessageDialog(null, "Radius must not be 0 or less.",
											"Error message!", JOptionPane.ERROR_MESSAGE);
								} else {
									if (Integer.parseInt(txtRadius.getText()) >= Integer
											.parseInt(txtInnerRadius.getText())) {
										isOk = true; // svi uslovi su ispunjeni
										setVisible(false); // zatvara dijalog klikom na ok
									} else {
										JOptionPane.showMessageDialog(null,
												"Radius must not be less than or equal to the inner radius",
												"Error message!", JOptionPane.ERROR_MESSAGE);
									}
								}
							}
						} catch (NumberFormatException e2) {// proveravamo numberformatexception tj da li je sve u intu  
							JOptionPane.showMessageDialog(null, "Values must be integers!", "Error message!",
									JOptionPane.ERROR_MESSAGE);
						}

					}
				});
				okButton.setBackground(new Color(179, 179, 217));
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);  //pritiskom na enter tastaturi aktivira se OK
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setFont(new Font("Arial", Font.BOLD, 10));
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						isOk = false; // vraca isOk na false i time se ne unose podaci u listu
						//ciscenje svih tekstualnih polja 
						txtX.setText(""); // ako otkazem delete pa hocu ponovo da dodam tekst
						txtY.setText("");
						txtRadius.setText("");
						txtInnerRadius.setText("");
						//vracanje polja u aktivno stanje za sledeci unos 
						txtX.setEnabled(true); // mogucnost dodavanja novog elementa nakon odustajanja od brisanja
						txtY.setEnabled(true);
						txtRadius.setEnabled(true);
						txtInnerRadius.setEnabled(true);
						dispose(); // zatvara dijalog klikom na cancel
					}
				});
				cancelButton.setBackground(new Color(179, 179, 217));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public JTextField getTxtX() {
		return txtX;
	}

	public void setTxtX(JTextField txtX) {
		this.txtX = txtX;
	}

	public JTextField getTxtY() {
		return txtY;
	}

	public void setTxtY(JTextField txtY) {
		this.txtY = txtY;
	}

	public JTextField getTxtRadius() {
		return txtRadius;
	}

	public void setTxtRadius(JTextField txtRadius) {
		this.txtRadius = txtRadius;
	}

	public JTextField getTxtInnerRadius() {
		return txtInnerRadius;
	}

	public void setTxtInnerRadius(JTextField txtInnerRadius) {
		this.txtInnerRadius = txtInnerRadius;
	}

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}

}
