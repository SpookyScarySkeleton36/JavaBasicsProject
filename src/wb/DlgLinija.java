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

public class DlgLinija extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtX,txtY,txtX1,txtY1;
	private JButton btnPotvrdi,btnOdustani;
	private int x, y, duzinaStranice;
	private String bojaIvice,bojaUnutrasnjosti;
	private boolean Provera = false;
	private JPanel pnlBojaIvice;
	private JLabel lblX1,lblY1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {

			UIManager.setLookAndFeel( "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			}
			catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(DlgLinija.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			}catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(DlgLinija.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

			} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(DlgLinija.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(DlgLinija.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			}
		try {
			DlgLinija dialog = new DlgLinija();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgLinija() {
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setModal(true);
		setBounds(100, 100, 437, 284);
		setTitle("Matanović Sofija IT 40/2015");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(204, 255, 204));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 33, 0, 23, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);

		JLabel lblX = new JLabel("Enter X coordinate of starting dot:");
		lblX.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblX.setBackground(new Color(255, 218, 185));
		GridBagConstraints gbc_lblX = new GridBagConstraints();
		gbc_lblX.anchor = GridBagConstraints.WEST;
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

		JLabel lblY = new JLabel("Enter Y coordinate of starting dot:");
		lblY.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblY.setBackground(new Color(255, 218, 185));
		GridBagConstraints gbc_lblY = new GridBagConstraints();
		gbc_lblY.anchor = GridBagConstraints.WEST;
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

		lblX1 = new JLabel("Enter X coordinate of ending dot:");
		lblX1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblX1 = new GridBagConstraints();
		gbc_lblX1.anchor = GridBagConstraints.WEST;
		gbc_lblX1.insets = new Insets(0, 0, 5, 5);
		gbc_lblX1.gridx = 1;
		gbc_lblX1.gridy = 2;
		contentPanel.add(lblX1, gbc_lblX1);

		txtX1 = new JTextField();
		txtX1.setBackground(new Color(255, 255, 204));
		GridBagConstraints gbc_txtX1 = new GridBagConstraints();
		gbc_txtX1.insets = new Insets(0, 0, 5, 5);
		gbc_txtX1.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtX1.gridx = 2;
		gbc_txtX1.gridy = 2;
		contentPanel.add(txtX1, gbc_txtX1);
		txtX1.setColumns(10);

		lblY1 = new JLabel("Enter Y coordinate of ending dot:");
		lblY1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblY1 = new GridBagConstraints();
		gbc_lblY1.anchor = GridBagConstraints.WEST;
		gbc_lblY1.insets = new Insets(0, 0, 5, 5);
		gbc_lblY1.gridx = 1;
		gbc_lblY1.gridy = 3;
		contentPanel.add(lblY1, gbc_lblY1);

		txtY1 = new JTextField();
		txtY1.setBackground(new Color(255, 255, 204));
		GridBagConstraints gbc_txtY1 = new GridBagConstraints();
		gbc_txtY1.insets = new Insets(0, 0, 5, 5);
		gbc_txtY1.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtY1.gridx = 2;
		gbc_txtY1.gridy = 3;
		contentPanel.add(txtY1, gbc_txtY1);
		txtY1.setColumns(10);

		JLabel lblBojaIvice = new JLabel("Choose color of the line:");
		lblBojaIvice.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBojaIvice.setBackground(new Color(255, 218, 185));
		GridBagConstraints gbc_lblBojaIvice = new GridBagConstraints();
		gbc_lblBojaIvice.anchor = GridBagConstraints.WEST;
		gbc_lblBojaIvice.insets = new Insets(0, 0, 0, 5);
		gbc_lblBojaIvice.gridx = 1;
		gbc_lblBojaIvice.gridy = 5;
		contentPanel.add(lblBojaIvice, gbc_lblBojaIvice);


		pnlBojaIvice = new JPanel();
		pnlBojaIvice.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlBojaIvice.setBackground(new Color(255, 255, 204));
		pnlBojaIvice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Color boja = JColorChooser.showDialog(null,"Change color of the selected line:", pnlBojaIvice.getBackground());
				pnlBojaIvice.setBackground(boja);
			}
		});
		GridBagConstraints gbc_pnlBojaIvice = new GridBagConstraints();
		gbc_pnlBojaIvice.insets = new Insets(0, 0, 0, 5);
		gbc_pnlBojaIvice.fill = GridBagConstraints.BOTH;
		gbc_pnlBojaIvice.gridx = 2;
		gbc_pnlBojaIvice.gridy = 5;
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
				txtX1.setText("");
				txtY1.setText("");
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

	public JPanel getPnlBojaIvice() {
		return pnlBojaIvice;
	}


	public void setPnlBojaIvice(JPanel pnlBojaIvice) {
		this.pnlBojaIvice = pnlBojaIvice;
	}

	public JTextField getTxtX1() {
		return txtX1;
	}

	public JTextField getTxtY1() {
		return txtY1;
	}

	public void setTxtX1(JTextField txtX1) {
		this.txtX1 = txtX1;
	}

	public void setTxtY1(JTextField txtY1) {
		this.txtY1 = txtY1;
	}


}
