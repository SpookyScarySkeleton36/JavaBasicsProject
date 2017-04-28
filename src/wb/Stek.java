package wb;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import geometrija.Kvadrat;
import geometrija.Tacka;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;

public class Stek {
	private JFrame frame;
	private JButton btnDodajKvadrat,btnIzbaciKvadrat;
	private ArrayList<Kvadrat> lista = new ArrayList<Kvadrat>();
	private DlgKvadratPocetni dlgK = new DlgKvadratPocetni();
	private JList lstLista;
	private DefaultListModel dlm =  new DefaultListModel();
	private Stack<Kvadrat> stek = new Stack<Kvadrat>();
	private JScrollPane scrollPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel( "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			}
			catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Stek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			}catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Stek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

			} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Stek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Stek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stek window = new Stek();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public Stek() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Matanović Sofija IT 40/2015");
		frame.setBounds(100, 100, 600, 476);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "Stack options:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(204, 255, 204));
		frame.getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{59, 130, 97, 66, 59, 42, 62, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 23, 93, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		btnDodajKvadrat = new JButton("Add square");
		btnDodajKvadrat.setBackground(new Color(255, 255, 204));
		btnDodajKvadrat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dlgK.getBtnOdustani().setVisible(true);
				dlgK.setVisible(true);
				if (dlgK.isProvera()) {
					Kvadrat kv = new Kvadrat();
					kv.setGoreLevo(new Tacka(dlgK.getX(), dlgK.getY()));
					kv.setDuzinaStranica(dlgK.getDuzinaStranice());
					kv.setBojaIvice(dlgK.getBojaIvice());
					kv.setStrBojaUnutrasnjosti(dlgK.getBojaUnutrasnjosti());
					stek.push(kv);
					lista.add(kv);
					dlm.addElement(kv);
				}
			}
		});
		GridBagConstraints gbc_btnDodajKvadrat = new GridBagConstraints();
		gbc_btnDodajKvadrat.fill = GridBagConstraints.BOTH;
		gbc_btnDodajKvadrat.insets = new Insets(0, 0, 5, 5);
		gbc_btnDodajKvadrat.gridx = 1;
		gbc_btnDodajKvadrat.gridy = 0;
		panel.add(btnDodajKvadrat, gbc_btnDodajKvadrat);
		btnIzbaciKvadrat = new JButton("Remove square");
		btnIzbaciKvadrat.setBackground(new Color(255, 255, 204));
		btnIzbaciKvadrat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(stek.isEmpty())
					JOptionPane.showMessageDialog(null, "There are no elements to erase.");
				else {
					int i = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete element?", "Notification", JOptionPane.YES_NO_OPTION);
					if (i == 0) {
						dlgK.getBtnOdustani().setVisible(false);
						dlgK.getTxtX().setText(Integer.toString(stek.peek().getGoreLevo().getX()));
						dlgK.getTxtY().setText(Integer.toString(stek.peek().getGoreLevo().getY()));
						dlgK.getTxtDuzinaStranice().setText(Integer.toString(stek.peek().getDuzinaStranice()));
						dlgK.getCbxBojaIvice().setSelectedItem(stek.peek().getBoja());
						dlgK.getCbxBojaUnutrasnjosti().setSelectedItem(stek.peek().getBojaUnutrasnjosti());
						dlgK.setTitle("Matanović Sofija IT 40/2015");
						dlgK.setVisible(true);
						stek.pop();
						lista.remove(lista.size()-1);
						dlm.remove(dlm.size()-1);
					}
					else
						dlgK.setVisible(false);
				}
			}
		});
		GridBagConstraints gbc_btnIzbaciKvadrat = new GridBagConstraints();
		gbc_btnIzbaciKvadrat.insets = new Insets(0, 0, 5, 5);
		gbc_btnIzbaciKvadrat.fill = GridBagConstraints.BOTH;
		gbc_btnIzbaciKvadrat.gridx = 4;
		gbc_btnIzbaciKvadrat.gridy = 0;
		panel.add(btnIzbaciKvadrat, gbc_btnIzbaciKvadrat);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 2;
		panel.add(scrollPane, gbc_scrollPane);
		
		lstLista = new JList();
		lstLista.setBorder(new TitledBorder(null, "List:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lstLista.setFont(new Font("Candara", Font.PLAIN, 13));
		lstLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(lstLista);
		lstLista.setModel(dlm);
		
		
		
	}
	public DlgKvadratPocetni getDlgK() {
		return dlgK;
	}
	public void setDlgK(DlgKvadratPocetni dlgK) {
		this.dlgK = dlgK;
	}
	public JButton getBtnDodajKvadrat() {
		return btnDodajKvadrat;
	}
	public void setBtnDodajKvadrat(JButton btnDodajKvadrat) {
		this.btnDodajKvadrat = btnDodajKvadrat;
	}
	public JButton getBtnIzbaciKvadrat() {
		return btnIzbaciKvadrat;
	}
	public void setBtnIzbaciKvadrat(JButton btnIzbaciKvadrat) {
		this.btnIzbaciKvadrat = btnIzbaciKvadrat;
	}
	public Stack<Kvadrat> getStek() {
		return stek;
	}
	public void setStek(Stack<Kvadrat> stek) {
		this.stek = stek;
	}
}

