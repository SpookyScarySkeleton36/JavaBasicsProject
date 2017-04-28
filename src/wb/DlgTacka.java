package wb;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;

public class DlgTacka extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtX, txtY;
	private JButton btnPotvrdi, btnOdustani;
	private int x, y, duzinaStranice;
	private String bojaIvice, bojaUnutrasnjosti;
	private boolean Provera = false;
	private JPanel pnlBojaIvice;

	public static void main(String[] args) {
		try {

			UIManager.setLookAndFeel( "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			}
			catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(DlgTacka.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			}catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(DlgTacka.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

			} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(DlgTacka.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(DlgTacka.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			}
		try {
			DlgTacka dialog = new DlgTacka();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public DlgTacka() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setBounds(100, 100, 450, 300);
		setTitle("Matanović Sofija IT 40/2015");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(204, 255, 204));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 64, 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 0, 30, 0, 33, 0, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);

		JLabel lblX = new JLabel("Enter X coordinate of dot:");
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
		gbc_txtX.insets = new Insets(0, 0, 5, 0);
		gbc_txtX.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtX.gridx = 2;
		gbc_txtX.gridy = 0;
		contentPanel.add(txtX, gbc_txtX);
		txtX.setColumns(10);

		JLabel lblY = new JLabel("Enter Y coordinate of dot:");
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
		gbc_txtY.insets = new Insets(0, 0, 5, 0);
		gbc_txtY.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtY.gridx = 2;
		gbc_txtY.gridy = 1;
		contentPanel.add(txtY, gbc_txtY);
		txtY.setColumns(10);

		JLabel lblBojaIvice = new JLabel("Choose color of the dot:");
		lblBojaIvice.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBojaIvice.setBackground(new Color(255, 218, 185));
		GridBagConstraints gbc_lblBojaIvice = new GridBagConstraints();
		gbc_lblBojaIvice.insets = new Insets(0, 0, 5, 5);
		gbc_lblBojaIvice.gridx = 1;
		gbc_lblBojaIvice.gridy = 3;
		contentPanel.add(lblBojaIvice, gbc_lblBojaIvice);

		pnlBojaIvice = new JPanel();
		pnlBojaIvice.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlBojaIvice.setBackground(new Color(255, 255, 204));
		pnlBojaIvice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Color boja = JColorChooser.showDialog(null, "Change color of the selected dot:",
						pnlBojaIvice.getBackground());
				pnlBojaIvice.setBackground(boja);
			}
		});
		GridBagConstraints gbc_pnlBojaIvice = new GridBagConstraints();
		gbc_pnlBojaIvice.insets = new Insets(0, 0, 5, 0);
		gbc_pnlBojaIvice.fill = GridBagConstraints.BOTH;
		gbc_pnlBojaIvice.gridx = 2;
		gbc_pnlBojaIvice.gridy = 3;
		contentPanel.add(pnlBojaIvice, gbc_pnlBojaIvice);

		JPanel buttonPane = new JPanel();
		buttonPane.setBackground(new Color(255, 255, 153));
		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		btnPotvrdi = new JButton("OK");
		btnPotvrdi.setBackground(new Color(153, 204, 0));
		btnPotvrdi.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				setProvera(true);
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
				pnlBojaIvice.setBackground(Color.WHITE);
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

	public void setTxtX(JTextField txtX) {
		this.txtX = txtX;
	}

	public void setTxtY(JTextField txtY) {
		this.txtY = txtY;
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

	public boolean isProvera() {
		return Provera;
	}

	public void setProvera(boolean Provera) {
		this.Provera = Provera;
	}

	public String getBojaIvice() {
		return bojaIvice;
	}

	public JPanel getPnlBojaIvice() {
		return pnlBojaIvice;
	}

	public void setPnlBojaIvice(JPanel pnlBojaIvice) {
		this.pnlBojaIvice = pnlBojaIvice;
	}

	public String getBojaUnutrasnjosti() {
		return bojaUnutrasnjosti;
	}

	public void setBojaUnutrasnjosti(String bojaUnutrasnjosti) {
		this.bojaUnutrasnjosti = bojaUnutrasnjosti;
	}

}
