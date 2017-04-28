package wb;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import geometrija.Kvadrat;
import geometrija.Tacka;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class DlgKvadratPocetni extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtX,txtY,txtDuzinaStranice;
	private JComboBox cbxBojaIvice,cbxBojaUnutrasnjosti;
	private JButton btnPotvrdi,btnOdustani;
	private int x, y, duzinaStranice;
	private String bojaIvice,bojaUnutrasnjosti;
	private boolean Provera = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {

			UIManager.setLookAndFeel( "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			}
			catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(DlgKvadratPocetni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			}catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(DlgKvadratPocetni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

			} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(DlgKvadratPocetni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(DlgKvadratPocetni.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			}
		try {
			DlgKvadratPocetni dialog = new DlgKvadratPocetni();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */



	public DlgKvadratPocetni() {
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setModal(true);
		setBounds(100, 100, 433, 276);
		setTitle("Matanović Sofija  IT 40/2015");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(204, 255, 204));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);

		JLabel lblX = new JLabel("Enter X coordinate of upper left dot:");
		lblX.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblX.setBackground(new Color(255, 218, 185));
		GridBagConstraints gbc_lblX = new GridBagConstraints();
		gbc_lblX.insets = new Insets(0, 0, 5, 5);
		gbc_lblX.gridx = 1;
		gbc_lblX.gridy = 0;
		contentPanel.add(lblX, gbc_lblX);

		txtX = new JTextField();
		txtX.setBackground(new Color(255, 255, 204));
		GridBagConstraints gbc_txtX = new GridBagConstraints();
		gbc_txtX.insets = new Insets(0, 0, 5, 5);
		gbc_txtX.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtX.gridx = 2;
		gbc_txtX.gridy = 0;
		contentPanel.add(txtX, gbc_txtX);
		txtX.setColumns(10);

		JLabel lblY = new JLabel("Enter Y coordinate of upper left dot:");
		lblY.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblY.setBackground(new Color(255, 218, 185));
		GridBagConstraints gbc_lblY = new GridBagConstraints();
		gbc_lblY.insets = new Insets(0, 0, 5, 5);
		gbc_lblY.gridx = 1;
		gbc_lblY.gridy = 1;
		contentPanel.add(lblY, gbc_lblY);

		txtY = new JTextField();
		txtY.setBackground(new Color(255, 255, 204));
		GridBagConstraints gbc_txtY = new GridBagConstraints();
		gbc_txtY.insets = new Insets(0, 0, 5, 5);
		gbc_txtY.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtY.gridx = 2;
		gbc_txtY.gridy = 1;
		contentPanel.add(txtY, gbc_txtY);
		txtY.setColumns(10);

		JLabel lblDuzinaStranice = new JLabel("Enter length:");
		lblDuzinaStranice.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDuzinaStranice.setBackground(new Color(255, 218, 185));
		GridBagConstraints gbc_lblDuzinaStranice = new GridBagConstraints();
		gbc_lblDuzinaStranice.anchor = GridBagConstraints.WEST;
		gbc_lblDuzinaStranice.insets = new Insets(0, 0, 5, 5);
		gbc_lblDuzinaStranice.gridx = 1;
		gbc_lblDuzinaStranice.gridy = 2;
		contentPanel.add(lblDuzinaStranice, gbc_lblDuzinaStranice);

		txtDuzinaStranice = new JTextField();
		txtDuzinaStranice.setBackground(new Color(255, 255, 204));
		GridBagConstraints gbc_txtDuzinaStranice = new GridBagConstraints();
		gbc_txtDuzinaStranice.insets = new Insets(0, 0, 5, 5);
		gbc_txtDuzinaStranice.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDuzinaStranice.gridx = 2;
		gbc_txtDuzinaStranice.gridy = 2;
		contentPanel.add(txtDuzinaStranice, gbc_txtDuzinaStranice);
		txtDuzinaStranice.setColumns(10);

		JLabel lblBojaIvice = new JLabel("Choose color of the edge:");
		lblBojaIvice.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBojaIvice.setBackground(new Color(255, 218, 185));
		GridBagConstraints gbc_lblBojaIvice = new GridBagConstraints();
		gbc_lblBojaIvice.anchor = GridBagConstraints.WEST;
		gbc_lblBojaIvice.insets = new Insets(0, 0, 5, 5);
		gbc_lblBojaIvice.gridx = 1;
		gbc_lblBojaIvice.gridy = 4;
		contentPanel.add(lblBojaIvice, gbc_lblBojaIvice);

		cbxBojaIvice = new JComboBox();
		cbxBojaIvice.setForeground(new Color(0, 0, 0));
		cbxBojaIvice.setBackground(new Color(255, 255, 204));
		cbxBojaIvice.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbxBojaIvice.setModel(new DefaultComboBoxModel(new String[] {"Black", "White", "Blue", "Red", "Green", "Yellow", "Pink"}));
		cbxBojaIvice.setSelectedIndex(0);
		GridBagConstraints gbc_cbxBojaIvice = new GridBagConstraints();
		gbc_cbxBojaIvice.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxBojaIvice.insets = new Insets(0, 0, 5, 5);
		gbc_cbxBojaIvice.gridx = 2;
		gbc_cbxBojaIvice.gridy = 4;
		contentPanel.add(cbxBojaIvice, gbc_cbxBojaIvice);

		JLabel lblBojaUnutrasnjosti = new JLabel("Choose color if the inside:");
		lblBojaUnutrasnjosti.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBojaUnutrasnjosti.setBackground(new Color(255, 218, 185));
		GridBagConstraints gbc_lblBojaUnutrasnjosti = new GridBagConstraints();
		gbc_lblBojaUnutrasnjosti.anchor = GridBagConstraints.WEST;
		gbc_lblBojaUnutrasnjosti.insets = new Insets(0, 0, 0, 5);
		gbc_lblBojaUnutrasnjosti.gridx = 1;
		gbc_lblBojaUnutrasnjosti.gridy = 5;
		contentPanel.add(lblBojaUnutrasnjosti, gbc_lblBojaUnutrasnjosti);

		cbxBojaUnutrasnjosti = new JComboBox();
		cbxBojaUnutrasnjosti.setForeground(new Color(0, 0, 0));
		cbxBojaUnutrasnjosti.setBackground(new Color(255, 255, 204));
		cbxBojaUnutrasnjosti.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cbxBojaUnutrasnjosti.setModel(new DefaultComboBoxModel(new String[] {"Black", "White", "Blue", "Red", "Green", "Yellow", "Pink"}));
		cbxBojaUnutrasnjosti.setSelectedIndex(0);
		GridBagConstraints gbc_cbxBojaUnutrasnjosti = new GridBagConstraints();
		gbc_cbxBojaUnutrasnjosti.insets = new Insets(0, 0, 0, 5);
		gbc_cbxBojaUnutrasnjosti.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbxBojaUnutrasnjosti.gridx = 2;
		gbc_cbxBojaUnutrasnjosti.gridy = 5;
		contentPanel.add(cbxBojaUnutrasnjosti, gbc_cbxBojaUnutrasnjosti);

		JPanel buttonPane = new JPanel();
		buttonPane.setBackground(new Color(255, 255, 153));
		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		btnPotvrdi = new JButton("OK");
		btnPotvrdi.setBackground(new Color(153, 204, 0));
		btnPotvrdi.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					x = Integer.parseInt(txtX.getText());
					y = Integer.parseInt(txtY.getText());
					duzinaStranice = Integer.parseInt(txtDuzinaStranice.getText());
					bojaIvice = cbxBojaIvice.getSelectedItem().toString();
					bojaUnutrasnjosti = cbxBojaUnutrasnjosti.getSelectedItem().toString();

					setVisible(false);

					txtDuzinaStranice.setText("");
					txtY.setText("");
					txtX.setText("");
					cbxBojaIvice.setSelectedItem("Black");
					cbxBojaUnutrasnjosti.setSelectedItem("Black");
					setProvera(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Error, wrong value.");
				}
			}
		});
		btnPotvrdi.setActionCommand("OK");
		buttonPane.add(btnPotvrdi);
		getRootPane().setDefaultButton(btnPotvrdi);

		btnOdustani = new JButton("Cancel");
		btnOdustani.setBackground(new Color(153, 204, 0));
		btnOdustani.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnOdustani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				txtX.setText("");
				txtY.setText("");
				txtDuzinaStranice.setText("");
				cbxBojaIvice.setSelectedItem("Black");
				cbxBojaUnutrasnjosti.setSelectedItem("Black");
			}
		});
		btnOdustani.setActionCommand("Cancel");
		buttonPane.add(btnOdustani);
	}


	public JTextField getTxtX() {
		return txtX;
	}

	public JTextField getTxtY() {
		return txtY;
	}

	public JTextField getTxtDuzinaStranice() {
		return txtDuzinaStranice;
	}

	public JComboBox getCbxBojaIvice() {
		return cbxBojaIvice;
	}

	public JComboBox getCbxBojaUnutrasnjosti() {
		return cbxBojaUnutrasnjosti;
	}

	public void setTxtX(JTextField txtX) {
		this.txtX = txtX;
	}

	public void setTxtY(JTextField txtY) {
		this.txtY = txtY;
	}

	public void setTxtDuzinaStranice(JTextField txtDuzinaStranice) {
		this.txtDuzinaStranice = txtDuzinaStranice;
	}

	public void setCbxBojaIvice(JComboBox cbxBojaIvice) {
		this.cbxBojaIvice = cbxBojaIvice;
	}

	public void setCbxBojaUnutrasnjosti(JComboBox cbxBojaUnutrasnjosti) {
		this.cbxBojaUnutrasnjosti = cbxBojaUnutrasnjosti;
	}

	public JButton getBtnPotvrdi() {
		return btnPotvrdi;
	}

	public JButton getBtnOdustani() {
		return btnOdustani;
	}

	public void setBtnPotvrdi(JButton btnPotvrdi) {
		this.btnPotvrdi = btnPotvrdi;
	}

	public void setBtnOdustani(JButton btnOdustani) {
		this.btnOdustani = btnOdustani;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getDuzinaStranice() {
		return duzinaStranice;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setDuzinaStranice(int duzinaStranice) {
		this.duzinaStranice = duzinaStranice;
	}

	public void setBojaIvice(String bojaIvice) {
		this.bojaIvice = bojaIvice;
	}

	public void setBojaUnustrasnjosti(String bojaUnustrasnjosti) {
		this.bojaUnutrasnjosti = bojaUnustrasnjosti;
	}

	public boolean isProvera() {
		return Provera;
	}

	public void setProvera(boolean Provera) {
		this.Provera = Provera;
	}

	public String getBojaIvice() {
		return bojaIvice;
	}

	public String getBojaUnutrasnjosti() {
		return bojaUnutrasnjosti;
	}

	public void setBojaUnutrasnjosti(String bojaUnutrasnjosti) {
		this.bojaUnutrasnjosti = bojaUnutrasnjosti;
	}


}
