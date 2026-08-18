package drawing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class DlgDonut extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	protected boolean isOk = false;
	private JLabel lblX;
	private JLabel lblY;
	protected JTextField txtX;
	protected JTextField txtY;
	protected JButton btnColor;
	protected JTextField txtRadius;
	protected JTextField txtinnerRadius;
	protected JButton btnInnerColor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgDonut dialog = new DlgDonut();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgDonut() {
		setModal(true); //zaustavlja sve ostale radnje dok se dijalog ne zatvori 
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblX = new JLabel("Enter the X coordinate:");
			GridBagConstraints gbc_lblX = new GridBagConstraints();
			gbc_lblX.insets = new Insets(0, 0, 5, 5);
			gbc_lblX.anchor = GridBagConstraints.EAST;
			gbc_lblX.gridx = 0;
			gbc_lblX.gridy = 0;
			contentPanel.add(lblX, gbc_lblX);
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
			JLabel lblY = new JLabel("Enter the Y coordinate:");
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
			JLabel lblRadius = new JLabel("Radius:");
			GridBagConstraints gbc_lblRadius = new GridBagConstraints();
			gbc_lblRadius.anchor = GridBagConstraints.EAST;
			gbc_lblRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblRadius.gridx = 0;
			gbc_lblRadius.gridy = 2;
			contentPanel.add(lblRadius, gbc_lblRadius);
		}
		{
			txtRadius = new JTextField();
			GridBagConstraints gbc_txtWidth = new GridBagConstraints();
			gbc_txtWidth.insets = new Insets(0, 0, 5, 0);
			gbc_txtWidth.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtWidth.gridx = 1;
			gbc_txtWidth.gridy = 2;
			contentPanel.add(txtRadius, gbc_txtWidth);
			txtRadius.setColumns(10);
		}
		{
			JLabel lblinnerRadius = new JLabel("Inner Radius:");
			GridBagConstraints gbc_lblinnerRadius = new GridBagConstraints();
			gbc_lblinnerRadius.anchor = GridBagConstraints.EAST;
			gbc_lblinnerRadius.insets = new Insets(0, 0, 5, 5);
			gbc_lblinnerRadius.gridx = 0;
			gbc_lblinnerRadius.gridy = 3;
			contentPanel.add(lblinnerRadius, gbc_lblinnerRadius);
		}
		{
			txtinnerRadius = new JTextField();
			GridBagConstraints gbc_txtHeight = new GridBagConstraints();
			gbc_txtHeight.insets = new Insets(0, 0, 5, 0);
			gbc_txtHeight.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtHeight.gridx = 1;
			gbc_txtHeight.gridy = 3;
			contentPanel.add(txtinnerRadius, gbc_txtHeight);
			txtinnerRadius.setColumns(10);
		}
		{
			JLabel lblColor = new JLabel("Color");
			GridBagConstraints gbc_lblColor = new GridBagConstraints();
			gbc_lblColor.insets = new Insets(0, 0, 5, 5);
			gbc_lblColor.gridx = 0;
			gbc_lblColor.gridy = 4;
			contentPanel.add(lblColor, gbc_lblColor);
		}
		{
			btnColor = new JButton("");
			btnColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Color color = JColorChooser.showDialog(null, "Choose the color", Color.black);
					btnColor.setBackground(color);
				}
			});
			GridBagConstraints gbc_btnColor = new GridBagConstraints();
			gbc_btnColor.insets = new Insets(0, 0, 5, 0);
			gbc_btnColor.fill = GridBagConstraints.BOTH;
			gbc_btnColor.gridx = 1;
			gbc_btnColor.gridy = 4;
			btnColor.setBackground(Color.BLACK);
			contentPanel.add(btnColor, gbc_btnColor);
		}
		{
			JLabel lblInnerColor = new JLabel("Inner Color");
			GridBagConstraints gbc_lblInnerColor = new GridBagConstraints();
			gbc_lblInnerColor.insets = new Insets(0, 0, 0, 5);
			gbc_lblInnerColor.gridx = 0;
			gbc_lblInnerColor.gridy = 5;
			contentPanel.add(lblInnerColor, gbc_lblInnerColor);
		}
		{
			btnInnerColor = new JButton("");
			btnInnerColor.setBackground(Color.WHITE);
			btnInnerColor.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Color color = JColorChooser.showDialog(null, "Choose the color", Color.black);
					btnInnerColor.setBackground(color);
				}
			});
			GridBagConstraints gbc_btnInnerColor = new GridBagConstraints();
			gbc_btnInnerColor.fill = GridBagConstraints.BOTH;
			gbc_btnInnerColor.gridx = 1;
			gbc_btnInnerColor.gridy = 5;
			contentPanel.add(btnInnerColor, gbc_btnInnerColor);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							if (txtX.getText().isEmpty() || txtY.getText().isEmpty()) {
								JOptionPane.showMessageDialog(null, "Please, enter a value.", "Error message!",
										JOptionPane.ERROR_MESSAGE);
							}
							// u JPanelu kooordinate moraju biti vece od 0 jer je pocetak (0,0) i sve ostalo
							// more biti vece
							else if ((Integer.parseInt(txtX.getText()) < 0) || (Integer.parseInt(txtY.getText()) < 0)) {
								JOptionPane.showMessageDialog(null, "Coordinates must be greater than 0.",
										"Error message!", JOptionPane.ERROR_MESSAGE);
							}else if((Integer.parseInt(txtRadius.getText()) < 0) || (Integer.parseInt(txtinnerRadius.getText()) < 0)) {
								JOptionPane.showMessageDialog(null, "Radius and Inner Radius must be greater than 0.",
										"Error message!", JOptionPane.ERROR_MESSAGE);
							}else {
								isOk = true;
								setVisible(false);
							}
								
						} catch (NumberFormatException e2) {// proveravamo numberformatexception tj da li je sve u intu
							JOptionPane.showMessageDialog(null, "Values must be integers!", "Error message!",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
