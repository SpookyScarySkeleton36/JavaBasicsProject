package wb;

import java.awt.EventQueue;

import javax.swing.JFrame;
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
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;

public class Sortiranje {

	private JFrame frame;
	private DlgKvadratPocetni dlgK = new DlgKvadratPocetni();
	private ArrayList<Kvadrat> lista = new ArrayList<Kvadrat>();
	private JList lstLista;
	private DefaultListModel dlm =  new DefaultListModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {

			UIManager.setLookAndFeel( "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			}
			catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Sortiranje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			}catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Sortiranje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

			} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Sortiranje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Sortiranje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sortiranje window = new Sortiranje();
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
	public Sortiranje() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Matanović Sofija IT 40-2015");
		frame.setBounds(100, 100, 500, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel pnlCentar = new JPanel();
		pnlCentar.setBackground(new Color(255, 255, 204));
		frame.getContentPane().add(pnlCentar, BorderLayout.CENTER);
		GridBagLayout gbl_pnlCentar = new GridBagLayout();
		gbl_pnlCentar.columnWidths = new int[]{91, 0, 0};
		gbl_pnlCentar.rowHeights = new int[]{292, 0};
		gbl_pnlCentar.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_pnlCentar.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		pnlCentar.setLayout(gbl_pnlCentar);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		pnlCentar.add(scrollPane, gbc_scrollPane);

		lstLista = new JList();
		lstLista.setBorder(new TitledBorder(null, "List:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lstLista.setFont(new Font("Candara", Font.PLAIN, 13));
		lstLista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(lstLista);
		lstLista.setModel(dlm);

		JPanel pnlFunkcije = new JPanel();
		pnlFunkcije.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "Options:", TitledBorder.LEADING, TitledBorder.BOTTOM, null, new Color(59, 59, 59)));
		pnlFunkcije.setBackground(new Color(204, 255, 204));
		frame.getContentPane().add(pnlFunkcije, BorderLayout.NORTH);
		GridBagLayout gbl_pnlFunkcije = new GridBagLayout();
		gbl_pnlFunkcije.columnWidths = new int[]{113, 100, 54, 100, 0};
		gbl_pnlFunkcije.rowHeights = new int[]{28, 0};
		gbl_pnlFunkcije.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlFunkcije.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlFunkcije.setLayout(gbl_pnlFunkcije);

		JButton btnSortirajListu = new JButton("Sort");
		btnSortirajListu.setForeground(new Color(0, 0, 0));
		btnSortirajListu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSortirajListu.setBackground(new Color(255, 255, 204));
		btnSortirajListu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (lista.isEmpty()) {
					JOptionPane.showMessageDialog(null, "There are no elements to sort.");
				}
				else {
					Collections.sort(lista);
					Iterator it = lista.iterator();
					dlm.addElement("");
					dlm.addElement("List after sorting:");
					while(it.hasNext()) {
						dlm.addElement(it.next());
					}
				}
			}
		});

		JButton btnDodajNaListu = new JButton("Add ");
		btnDodajNaListu.setForeground(new Color(0, 0, 0));
		btnDodajNaListu.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnDodajNaListu.setBackground(new Color(255, 255, 204));
		btnDodajNaListu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dlgK.getBtnOdustani().setVisible(true);
				dlgK.setVisible(true);
				if (dlgK.isProvera()) {
					Kvadrat kv = new Kvadrat();
					kv.setGoreLevo(new Tacka(dlgK.getX(), dlgK.getY()));
					kv.setDuzinaStranica(dlgK.getDuzinaStranice());
					kv.setBojaIvice(dlgK.getBojaIvice());
					kv.setStrBojaUnutrasnjosti(dlgK.getBojaUnutrasnjosti());
					lista.add(kv);
					dlm.addElement(kv);
				}
			}
		});
		GridBagConstraints gbc_btnDodajNaListu = new GridBagConstraints();
		gbc_btnDodajNaListu.fill = GridBagConstraints.BOTH;
		gbc_btnDodajNaListu.insets = new Insets(0, 0, 0, 5);
		gbc_btnDodajNaListu.gridx = 1;
		gbc_btnDodajNaListu.gridy = 0;
		pnlFunkcije.add(btnDodajNaListu, gbc_btnDodajNaListu);
		GridBagConstraints gbc_btnSortirajListu = new GridBagConstraints();
		gbc_btnSortirajListu.fill = GridBagConstraints.BOTH;
		gbc_btnSortirajListu.gridx = 3;
		gbc_btnSortirajListu.gridy = 0;
		pnlFunkcije.add(btnSortirajListu, gbc_btnSortirajListu);
	}

	public ArrayList<Kvadrat> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Kvadrat> lista) {
		this.lista = lista;
	}

}
