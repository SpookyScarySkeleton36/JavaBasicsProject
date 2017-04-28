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

public class DlgKvadrat extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtX,txtY,txtDuzinaStranice;
	private JButton btnPotvrdi,btnOdustani;
	private int x, y, duzinaStranice;
	private String bojaIvice,bojaUnutrasnjosti;
	private boolean Provera = false;
	private JPanel pnlBojaIvice,pnlBojaUnutrasnjosti;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {

			UIManager.setLookAndFeel( "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			}
			catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(DlgKvadrat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			}catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(DlgKvadrat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

			} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(DlgKvadrat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(DlgKvadrat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			}
		try {
			DlgKvadrat dialog = new DlgKvadrat();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */	
	public DlgKvadrat() {
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		setModal(true);
		setBounds(100, 100, 450, 283);
		setTitle("Matanović Sofija IT 40/2015");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(204, 255, 204));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 64, 38, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{25, 25, 33, 0, 29, 24, 0};
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
		txtX.setFont(new Font("SansSerif", Font.PLAIN, 13));
		txtX.setBackground(new Color(255, 255, 204));
		GridBagConstraints gbc_txtX = new GridBagConstraints();
		gbc_txtX.insets = new Insets(0, 0, 5, 5);
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
		txtY.setFont(new Font("SansSerif", Font.PLAIN, 13));
		txtY.setBackground(new Color(255, 255, 204));
		GridBagConstraints gbc_txtY = new GridBagConstraints();
		gbc_txtY.insets = new Insets(0, 0, 5, 5);
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
		txtDuzinaStranice.setFont(new Font("SansSerif", Font.PLAIN, 13));
		txtDuzinaStranice.setBackground(new Color(255, 255, 204));
		GridBagConstraints gbc_txtDuzinaStranice = new GridBagConstraints();
		gbc_txtDuzinaStranice.insets = new Insets(0, 0, 5, 5);
		gbc_txtDuzinaStranice.gridx = 2;
		gbc_txtDuzinaStranice.gridy = 2;
		contentPanel.add(txtDuzinaStranice, gbc_txtDuzinaStranice);
		txtDuzinaStranice.setColumns(10);

		pnlBojaIvice = new JPanel();
		pnlBojaIvice.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlBojaIvice.setBackground(new Color(255, 255, 204));
		pnlBojaIvice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Color boja = JColorChooser.showDialog(null,"Change color of the selected square:", pnlBojaIvice.getBackground());
				pnlBojaIvice.setBackground(boja);
			}
		});

		JLabel lblBojaIvice = new JLabel("Choose color of the edge:");
		lblBojaIvice.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBojaIvice.setBackground(new Color(255, 218, 185));
		GridBagConstraints gbc_lblBojaIvice = new GridBagConstraints();
		gbc_lblBojaIvice.anchor = GridBagConstraints.WEST;
		gbc_lblBojaIvice.insets = new Insets(0, 0, 5, 5);
		gbc_lblBojaIvice.gridx = 1;
		gbc_lblBojaIvice.gridy = 4;
		contentPanel.add(lblBojaIvice, gbc_lblBojaIvice);

		GridBagConstraints gbc_pnlBojaIvice = new GridBagConstraints();
		gbc_pnlBojaIvice.insets = new Insets(0, 0, 5, 5);
		gbc_pnlBojaIvice.fill = GridBagConstraints.BOTH;
		gbc_pnlBojaIvice.gridx = 2;
		gbc_pnlBojaIvice.gridy = 4;
		contentPanel.add(pnlBojaIvice, gbc_pnlBojaIvice);

		pnlBojaUnutrasnjosti = new JPanel();
		pnlBojaUnutrasnjosti.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlBojaUnutrasnjosti.setBackground(new Color(255, 255, 204));
		pnlBojaUnutrasnjosti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Color boja = JColorChooser.showDialog(null,"Change color of the selected square:", pnlBojaUnutrasnjosti.getBackground());
				pnlBojaUnutrasnjosti.setBackground(boja);

			}
		});

		JLabel lblBojaUnutrasnjosti = new JLabel("Choose color if the inside:");
		lblBojaUnutrasnjosti.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblBojaUnutrasnjosti.setBackground(new Color(255, 218, 185));
		GridBagConstraints gbc_lblBojaUnutrasnjosti = new GridBagConstraints();
		gbc_lblBojaUnutrasnjosti.anchor = GridBagConstraints.WEST;
		gbc_lblBojaUnutrasnjosti.insets = new Insets(0, 0, 0, 5);
		gbc_lblBojaUnutrasnjosti.gridx = 1;
		gbc_lblBojaUnutrasnjosti.gridy = 5;
		contentPanel.add(lblBojaUnutrasnjosti, gbc_lblBojaUnutrasnjosti);

		GridBagConstraints gbc_pnlBojaUnutrasnjosti = new GridBagConstraints();
		gbc_pnlBojaUnutrasnjosti.insets = new Insets(0, 0, 0, 5);
		gbc_pnlBojaUnutrasnjosti.fill = GridBagConstraints.BOTH;
		gbc_pnlBojaUnutrasnjosti.gridx = 2;
		gbc_pnlBojaUnutrasnjosti.gridy = 5;
		contentPanel.add(pnlBojaUnutrasnjosti, gbc_pnlBojaUnutrasnjosti);

		JPanel buttonPane = new JPanel();
		buttonPane.setBackground(new Color(255, 255, 153));
		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		btnPotvrdi = new JButton("OK");
		btnPotvrdi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				setProvera(true);
			}
		});
		btnPotvrdi.setBackground(new Color(153, 204, 0));
		btnPotvrdi.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnPotvrdi.setActionCommand("OK");
		buttonPane.add(btnPotvrdi);
		getRootPane().setDefaultButton(btnPotvrdi);

		btnOdustani = new JButton("Cancel");
		btnOdustani.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				txtDuzinaStranice.setText("");
				txtY.setText("");
				txtX.setText("");
				pnlBojaIvice.setBackground(Color.WHITE);
				pnlBojaUnutrasnjosti.setBackground(Color.WHITE);
			}
		});
		btnOdustani.setBackground(new Color(153, 204, 0));
		btnOdustani.setFont(new Font("Tahoma", Font.BOLD, 13));
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


	public void setTxtX(JTextField txtX) {
		this.txtX = txtX;
	}

	public void setTxtY(JTextField txtY) {
		this.txtY = txtY;
	}

	public void setTxtDuzinaStranice(JTextField txtDuzinaStranice) {
		this.txtDuzinaStranice = txtDuzinaStranice;
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

	public JPanel getPnlBojaUnutrasnjosti() {
		return pnlBojaUnutrasnjosti;
	}

	public void setPnlBojaIvice(JPanel pnlBojaIvice) {
		this.pnlBojaIvice = pnlBojaIvice;
	}

	public void setPnlBojaUnutrasnjosti(JPanel pnlBojaUnutrasnjosti) {
		this.pnlBojaUnutrasnjosti = pnlBojaUnutrasnjosti;
	}


}
