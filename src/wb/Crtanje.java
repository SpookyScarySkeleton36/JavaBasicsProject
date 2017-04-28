package wb;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.plaf.ButtonUI;

import geometrija.Krug;
import geometrija.Kvadrat;
import geometrija.Linija;
import geometrija.Pravougaonik;
import geometrija.Tacka;
import wb.DlgKrug;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JColorChooser;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;
import java.awt.SystemColor;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Icon;

public class Crtanje {

	private JFrame frame;
	private JTextField selektovan;
	private JPanel pnlKontrolni;
	private PanelCrtanje pnlCrtez = new PanelCrtanje();
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private int x,y, p=0;
	private Object oblik;
	private Color bojaIvice=Color.BLACK, bojaUnutrasnjosti=Color.WHITE; 
	private JToggleButton tglbtnSelektuj, tglbtnTacka, tglbtnLinija, tglbtnKvadrat, tglbtnKrug, tglbtnPravougaonik, tglbtnModifikuj, tglbtnObrisi;
	public static DlgKvadrat dlgK = new DlgKvadrat();
	public static DlgPravougaonik dlgP = new DlgPravougaonik();
	public static DlgKrug dlgKr = new DlgKrug();
	public static DlgTacka dlgT = new DlgTacka();
	public static DlgLinija dlgL = new DlgLinija();
	private boolean Provera = true;
	private Exception ex = null;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel( "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
			}
			catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(Crtanje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			}catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(Crtanje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

			} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(Crtanje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(Crtanje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
			}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Crtanje window = new Crtanje();
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
	public Crtanje() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Matanovć Sofija IT 40/2015");
		frame.setForeground(new Color(0, 153, 0));
		frame.setBackground(new Color(0, 153, 0));
		frame.setBounds(100, 100, 900, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel pnlKontrolni = new JPanel();
		pnlKontrolni.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Main menu:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)));
		pnlKontrolni.setBackground(new Color(240, 230, 140));
		frame.getContentPane().add(pnlKontrolni, BorderLayout.NORTH);
		GridBagLayout gbl_pnlKontrolni = new GridBagLayout();
		gbl_pnlKontrolni.columnWidths = new int[]{22, 80, 326, 223, 0};
		gbl_pnlKontrolni.rowHeights = new int[]{100, 0};
		gbl_pnlKontrolni.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlKontrolni.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		pnlKontrolni.setLayout(gbl_pnlKontrolni);

		JPanel pnlOpcije = new JPanel();
		pnlOpcije.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "Options:", TitledBorder.LEADING, TitledBorder.BOTTOM, null, new Color(59, 59, 59)));
		pnlOpcije.setBackground(new Color(46, 139, 87));
		GridBagConstraints gbc_pnlOpcije = new GridBagConstraints();
		gbc_pnlOpcije.insets = new Insets(0, 0, 0, 5);
		gbc_pnlOpcije.gridx = 1;
		gbc_pnlOpcije.gridy = 0;
		pnlKontrolni.add(pnlOpcije, gbc_pnlOpcije);
		GridBagLayout gbl_pnlOpcije = new GridBagLayout();
		gbl_pnlOpcije.columnWidths = new int[]{92, 0};
		gbl_pnlOpcije.rowHeights = new int[]{0, 0, 16, 0};
		gbl_pnlOpcije.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_pnlOpcije.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlOpcije.setLayout(gbl_pnlOpcije);

		JToggleButton tglbtnSelektuj = new JToggleButton("Select");
		tglbtnSelektuj.setToolTipText("Selects choosen shape");
		tglbtnSelektuj.setBackground(new Color(255, 160, 122));
		tglbtnSelektuj.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		GridBagConstraints gbc_tglbtnSelektuj = new GridBagConstraints();
		gbc_tglbtnSelektuj.fill = GridBagConstraints.BOTH;
		gbc_tglbtnSelektuj.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnSelektuj.gridx = 0;
		gbc_tglbtnSelektuj.gridy = 0;
		pnlOpcije.add(tglbtnSelektuj, gbc_tglbtnSelektuj);
		buttonGroup.add(tglbtnSelektuj);
		
		JToggleButton tglbtnModifikuj = new JToggleButton("Modify");
		tglbtnModifikuj.setToolTipText("Modify features of selected shape");
		tglbtnModifikuj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=pnlCrtez.listaOblika.size()-1;i>=0;i--){
					if(pnlCrtez.listaOblika.get(i) instanceof Tacka){					
						Tacka pom = (Tacka)pnlCrtez.listaOblika.get(i);
						if(pom.isSelektovan()){
							try {

								dlgT.getTxtX().setEditable(true);
								dlgT.getTxtY().setEditable(true);
								dlgT.getTxtX().setText(Integer.toString(pom.getX()));
								dlgT.getTxtY().setText(Integer.toString(pom.getY()));
								dlgT.getPnlBojaIvice().setBackground(pom.getBoja());
								dlgT.setVisible(true);

								pom.setX(Integer.parseInt(dlgT.getTxtX().getText()));
								pom.setY(Integer.parseInt(dlgT.getTxtY().getText()));
								pom.setBoja(dlgT.getPnlBojaIvice().getBackground());
								dlgT.getTxtX().setText("");
								dlgT.getTxtY().setText("");
								dlgT.getPnlBojaIvice().setBackground(Color.WHITE);

							}
							catch(Exception x) {
								JOptionPane.showMessageDialog(null,"Error, wrong value.");
							}
						}
					}
					else if (pnlCrtez.listaOblika.get(i) instanceof Linija) {
						Linija pom = (Linija)pnlCrtez.listaOblika.get(i);
						if (pom.isSelektovan()) {
							dlgL.getTxtX().setText(Integer.toString(pom.gettPocetna().getX()));
							dlgL.getTxtY().setText(Integer.toString(pom.gettPocetna().getY()));
							dlgL.getTxtX1().setText(Integer.toString(pom.gettKrajnja().getX()));
							dlgL.getTxtY1().setText(Integer.toString(pom.gettKrajnja().getY()));
							dlgL.getPnlBojaIvice().setBackground(pom.getBoja());
							try {
								dlgL.setVisible(true);
								Color bojaIvice = dlgL.getPnlBojaIvice().getBackground();
								int pocX = Integer.parseInt(dlgL.getTxtX().getText());
								int pocY = Integer.parseInt(dlgL.getTxtY().getText());
								int kraX = Integer.parseInt(dlgL.getTxtX1().getText());
								int kraY = Integer.parseInt(dlgL.getTxtY1().getText());

								pom.settPocetna(new Tacka(pocX, pocY));
								pom.settKrajnja(new Tacka(kraX, kraY));
								pom.setBoja(bojaIvice);

								dlgL.getTxtX().setText("");
								dlgL.getTxtY().setText("");
								dlgL.getTxtX1().setText("");
								dlgL.getTxtY1().setText("");
								dlgL.getPnlBojaIvice().setBackground(Color.WHITE);
							}
							catch(Exception x) {
								JOptionPane.showMessageDialog(null,"Error, wrong value.");
							}
						}
					}
					else if (pnlCrtez.listaOblika.get(i) instanceof Krug) {
						Krug pomocni = (Krug)pnlCrtez.listaOblika.get(i);
						if (pomocni.isSelektovan()) {
							dlgKr.getTxtX().setEditable(true);
							dlgKr.getTxtY().setEditable(true);
							dlgKr.getTxtX().setText(Integer.toString(pomocni.getCentar().getX()));
							dlgKr.getTxtY().setText(Integer.toString(pomocni.getCentar().getY()));
							dlgKr.getTxtDuzinaStranice().setText(Integer.toString(pomocni.getR()));
							dlgKr.getPnlBojaIvice().setBackground(pomocni.getBoja());
							dlgKr.getPnlBojaUnutrasnjosti().setBackground(pomocni.getBojaUnutrasnjosti());
							try {
								dlgKr.setVisible(true);
								int x = Integer.parseInt(dlgKr.getTxtX().getText());
								int y = Integer.parseInt(dlgKr.getTxtY().getText());

								pomocni.setBoja(dlgKr.getPnlBojaIvice().getBackground());
								pomocni.setBojaUnutrasnjosti(dlgKr.getPnlBojaUnutrasnjosti().getBackground());
								pomocni.setCentar(new Tacka(x, y));
								pomocni.setR(Integer.parseInt(dlgKr.getTxtDuzinaStranice().getText()));

								dlgKr.getTxtX().setText("");
								dlgKr.getTxtY().setText("");
								dlgKr.getTxtDuzinaStranice().setText("");
								dlgKr.getPnlBojaIvice().setBackground(Color.WHITE);
								dlgKr.getPnlBojaUnutrasnjosti().setBackground(Color.WHITE);
							}
							catch(Exception x) {
								JOptionPane.showMessageDialog(null,"Error, wrong value.");
							}
						}
					}
					else if (pnlCrtez.listaOblika.get(i) instanceof Kvadrat) {
						Kvadrat pomocna = (Kvadrat)pnlCrtez.listaOblika.get(i);
						if (pomocna.isSelektovan()) {
							dlgK.getTxtX().setEditable(true);
							dlgK.getTxtY().setEditable(true);
							dlgK.getTxtX().setText(Integer.toString(pomocna.getGoreLevo().getX()));
							dlgK.getTxtY().setText(Integer.toString(pomocna.getGoreLevo().getY()));
							dlgK.getTxtDuzinaStranice().setText(Integer.toString(pomocna.getDuzinaStranica()));
							dlgK.getPnlBojaIvice().setBackground(pomocna.getBoja());
							dlgK.getPnlBojaUnutrasnjosti().setBackground(pomocna.getBojaUnutrasnjosti());
							try {
								dlgK.setVisible(true);
								int x = Integer.parseInt(dlgK.getTxtX().getText());
								int y = Integer.parseInt(dlgK.getTxtY().getText());

								pomocna.setBoja(dlgK.getPnlBojaIvice().getBackground());
								pomocna.setBojaUnutrasnjosti(dlgK.getPnlBojaUnutrasnjosti().getBackground());
								pomocna.setGoreLevo(new Tacka(x, y));
								pomocna.setDuzinaStranica(Integer.parseInt(dlgK.getTxtDuzinaStranice().getText()));

								dlgK.getTxtX().setText("");
								dlgK.getTxtY().setText("");
								dlgK.getTxtDuzinaStranice().setText("");
								dlgK.getPnlBojaIvice().setBackground(Color.WHITE);
								dlgK.getPnlBojaUnutrasnjosti().setBackground(Color.WHITE);
							}
							catch(Exception x) {
								JOptionPane.showMessageDialog(null,"Error, wrong value.");
							}
						}
					}
					else if (pnlCrtez.listaOblika.get(i) instanceof Pravougaonik) {
						Pravougaonik pomocna = (Pravougaonik)pnlCrtez.listaOblika.get(i);
						if(pomocna.isSelektovan()) {
							dlgP.getTxtX().setEditable(true);
							dlgP.getTxtY().setEditable(true);
							dlgP.getTxtX().setText(Integer.toString(pomocna.getGoreLevo().getX()));
							dlgP.getTxtY().setText(Integer.toString(pomocna.getGoreLevo().getY()));
							dlgP.getTxtDuzinaStranice().setText(Integer.toString(pomocna.getDuzinaStranica()));
							dlgP.getTxtVisina().setText(Integer.toString(pomocna.getVisina()));
							dlgP.getPnlBojaIvice().setBackground(pomocna.getBoja());
							dlgP.getPnlBojaUnutrasnjosti().setBackground(pomocna.getBojaUnutrasnjosti());
							try {
								dlgP.setVisible(true);
								int x = Integer.parseInt(dlgP.getTxtX().getText());
								int y = Integer.parseInt(dlgP.getTxtY().getText());
								pomocna.setBoja(dlgP.getPnlBojaIvice().getBackground());
								pomocna.setBojaUnutrasnjosti(dlgP.getPnlBojaUnutrasnjosti().getBackground());
								pomocna.setDuzinaStranice(Integer.parseInt(dlgP.getTxtDuzinaStranice().getText()));
								pomocna.setVisina(Integer.parseInt(dlgP.getTxtVisina().getText()));

								dlgP.getTxtX().setText("");
								dlgP.getTxtY().setText("");
								dlgP.getTxtDuzinaStranice().setText("");
								dlgP.getTxtVisina().setText("");
								dlgP.getPnlBojaIvice().setBackground(Color.WHITE);
								dlgP.getPnlBojaUnutrasnjosti().setBackground(Color.WHITE);
							}
							catch(Exception x) {
								JOptionPane.showMessageDialog(null,"Error, wrong value.");
							}
						}
					}

				}
			}
		});
		tglbtnModifikuj.setBackground(new Color(250, 128, 114));
		tglbtnModifikuj.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		GridBagConstraints gbc_tglbtnModifikuj = new GridBagConstraints();
		gbc_tglbtnModifikuj.fill = GridBagConstraints.BOTH;
		gbc_tglbtnModifikuj.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnModifikuj.gridx = 0;
		gbc_tglbtnModifikuj.gridy = 1;
		pnlOpcije.add(tglbtnModifikuj, gbc_tglbtnModifikuj);
		buttonGroup.add(tglbtnModifikuj);

		JPanel pnlSelektovan = new JPanel();
		pnlSelektovan.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "Selected shape:", TitledBorder.LEADING, TitledBorder.BOTTOM, null, new Color(59, 59, 59)));
		pnlSelektovan.setBackground(new Color(46, 139, 87));
		GridBagConstraints gbc_pnlSelektovan = new GridBagConstraints();
		gbc_pnlSelektovan.fill = GridBagConstraints.BOTH;
		gbc_pnlSelektovan.gridx = 3;
		gbc_pnlSelektovan.gridy = 0;
		pnlKontrolni.add(pnlSelektovan, gbc_pnlSelektovan);
		GridBagLayout gbl_pnlSelektovan = new GridBagLayout();
		gbl_pnlSelektovan.columnWidths = new int[]{103, 103, 0};
		gbl_pnlSelektovan.rowHeights = new int[]{0, 0, 29, 0};
		gbl_pnlSelektovan.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlSelektovan.rowWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlSelektovan.setLayout(gbl_pnlSelektovan);


		JPanel pnlBojaIvice = new JPanel();
		pnlBojaIvice.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		pnlBojaIvice.setToolTipText("Shows edge color of selected item");
		pnlBojaIvice.setBackground(new Color(255, 127, 80));
		GridBagConstraints gbc_pnlBojaIvice = new GridBagConstraints();
		gbc_pnlBojaIvice.insets = new Insets(0, 0, 0, 5);
		gbc_pnlBojaIvice.fill = GridBagConstraints.BOTH;
		gbc_pnlBojaIvice.gridx = 0;
		gbc_pnlBojaIvice.gridy = 2;
		pnlSelektovan.add(pnlBojaIvice, gbc_pnlBojaIvice);

		JPanel pnlBojaUnutrasnjosti = new JPanel();
		pnlBojaUnutrasnjosti.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		pnlBojaUnutrasnjosti.setToolTipText("Shows inside color of selected item");
		pnlBojaUnutrasnjosti.setBackground(new Color(255, 127, 80));
		GridBagConstraints gbc_pnlBojaUnutrasnjosti = new GridBagConstraints();
		gbc_pnlBojaUnutrasnjosti.fill = GridBagConstraints.BOTH;
		gbc_pnlBojaUnutrasnjosti.gridx = 1;
		gbc_pnlBojaUnutrasnjosti.gridy = 2;
		pnlSelektovan.add(pnlBojaUnutrasnjosti, gbc_pnlBojaUnutrasnjosti);

		JToggleButton tglbtnObrisi = new JToggleButton("Erase");
		tglbtnObrisi.setToolTipText("Erases selected shape");
		tglbtnObrisi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tglbtnObrisi.isSelected()) {
					for(int i = pnlCrtez.listaOblika.size() -1; i >= 0; i--) {
						if(pnlCrtez.listaOblika.get(i).isSelektovan()) {
							int n = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete shape?", "Notification", JOptionPane.YES_NO_OPTION);
							if (n == 0) {
								pnlCrtez.listaOblika.remove(i);
								selektovan.setText("");
								pnlBojaIvice.setBackground(Color.WHITE);
								pnlBojaUnutrasnjosti.setBackground(Color.WHITE);

							}
						}
					}
				}
			}
		});
		tglbtnObrisi.setBackground(new Color(205, 92, 92));
		tglbtnObrisi.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		GridBagConstraints gbc_tglbtnObrisi = new GridBagConstraints();
		gbc_tglbtnObrisi.fill = GridBagConstraints.BOTH;
		gbc_tglbtnObrisi.gridx = 0;
		gbc_tglbtnObrisi.gridy = 2;
		pnlOpcije.add(tglbtnObrisi, gbc_tglbtnObrisi);
		buttonGroup.add(tglbtnObrisi);

		JPanel pnlOblici = new JPanel();
		pnlOblici.setBorder(new TitledBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)), "Shapes:", TitledBorder.LEADING, TitledBorder.BOTTOM, null, new Color(59, 59, 59)));
		pnlOblici.setBackground(new Color(46, 139, 87));
		GridBagConstraints gbc_pnlOblici = new GridBagConstraints();
		gbc_pnlOblici.insets = new Insets(0, 0, 0, 5);
		gbc_pnlOblici.fill = GridBagConstraints.VERTICAL;
		gbc_pnlOblici.gridx = 2;
		gbc_pnlOblici.gridy = 0;
		pnlKontrolni.add(pnlOblici, gbc_pnlOblici);
		GridBagLayout gbl_pnlOblici = new GridBagLayout();
		gbl_pnlOblici.columnWidths = new int[]{103, 103, 0};
		gbl_pnlOblici.rowHeights = new int[]{20, 0, 18, 0};
		gbl_pnlOblici.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_pnlOblici.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		pnlOblici.setLayout(gbl_pnlOblici);

		JToggleButton tglbtnTacka = new JToggleButton("Dot");
		tglbtnTacka.setToolTipText("Creates a dot on clicked place");
		tglbtnTacka.setBackground(new Color(255, 215, 0));
		tglbtnTacka.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		GridBagConstraints gbc_tglbtnTacka = new GridBagConstraints();
		gbc_tglbtnTacka.fill = GridBagConstraints.BOTH;
		gbc_tglbtnTacka.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnTacka.gridx = 0;
		gbc_tglbtnTacka.gridy = 0;
		pnlOblici.add(tglbtnTacka, gbc_tglbtnTacka);
		buttonGroup.add(tglbtnTacka);

		JToggleButton tglbtnKvadrat = new JToggleButton("Square");
		tglbtnKvadrat.setToolTipText("Creates a squre, upper left dot is placed on click");
		tglbtnKvadrat.setBackground(new Color(255, 255, 0));
		tglbtnKvadrat.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		GridBagConstraints gbc_tglbtnKvadrat = new GridBagConstraints();
		gbc_tglbtnKvadrat.fill = GridBagConstraints.BOTH;
		gbc_tglbtnKvadrat.insets = new Insets(0, 0, 5, 0);
		gbc_tglbtnKvadrat.gridx = 1;
		gbc_tglbtnKvadrat.gridy = 0;
		pnlOblici.add(tglbtnKvadrat, gbc_tglbtnKvadrat);
		buttonGroup.add(tglbtnKvadrat);

		JToggleButton tglbtnLinija = new JToggleButton("Line");
		tglbtnLinija.setToolTipText("Creates a line based on two clicks");
		tglbtnLinija.setBackground(new Color(255, 165, 0));
		tglbtnLinija.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		GridBagConstraints gbc_tglbtnLinija = new GridBagConstraints();
		gbc_tglbtnLinija.fill = GridBagConstraints.BOTH;
		gbc_tglbtnLinija.insets = new Insets(0, 0, 5, 5);
		gbc_tglbtnLinija.gridx = 0;
		gbc_tglbtnLinija.gridy = 1;
		pnlOblici.add(tglbtnLinija, gbc_tglbtnLinija);
		buttonGroup.add(tglbtnLinija);

		JToggleButton tglbtnKrug = new JToggleButton("Circle");
		tglbtnKrug.setToolTipText("Creates a circle, center is placed on click");
		tglbtnKrug.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		tglbtnKrug.setBackground(new Color(255, 140, 0));
		GridBagConstraints gbc_tglbtnKrug = new GridBagConstraints();
		gbc_tglbtnKrug.fill = GridBagConstraints.BOTH;
		gbc_tglbtnKrug.insets = new Insets(0, 0, 0, 5);
		gbc_tglbtnKrug.gridx = 0;
		gbc_tglbtnKrug.gridy = 2;
		pnlOblici.add(tglbtnKrug, gbc_tglbtnKrug);
		buttonGroup.add(tglbtnKrug);

		JToggleButton tglbtnPravougaonik = new JToggleButton("Rectangle");
		tglbtnPravougaonik.setToolTipText("Creates a rectangle, upper left dot is placed on click");
		tglbtnPravougaonik.setBackground(new Color(255, 69, 0));
		tglbtnPravougaonik.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 12));
		GridBagConstraints gbc_tglbtnPravougaonik = new GridBagConstraints();
		gbc_tglbtnPravougaonik.fill = GridBagConstraints.BOTH;
		gbc_tglbtnPravougaonik.gridx = 1;
		gbc_tglbtnPravougaonik.gridy = 2;
		pnlOblici.add(tglbtnPravougaonik, gbc_tglbtnPravougaonik);
		buttonGroup.add(tglbtnPravougaonik);

		selektovan = new JTextField();
		selektovan.setFont(new Font("SansSerif", Font.PLAIN, 14));
		selektovan.setToolTipText("Allows you to see which shape is selected");
		selektovan.setBackground(new Color(255, 127, 80));
		GridBagConstraints gbc_txtStatus = new GridBagConstraints();
		gbc_txtStatus.gridwidth = 2;
		gbc_txtStatus.insets = new Insets(0, 0, 5, 0);
		gbc_txtStatus.fill = GridBagConstraints.BOTH;
		gbc_txtStatus.gridx = 0;
		gbc_txtStatus.gridy = 0;
		pnlSelektovan.add(selektovan, gbc_txtStatus);
		selektovan.setColumns(10);

		JLabel lblBojaIvice = new JLabel("Edge color:");
		lblBojaIvice.setFont(new Font("SansSerif", Font.BOLD, 12));
		GridBagConstraints gbc_lblBojaIvice = new GridBagConstraints();
		gbc_lblBojaIvice.insets = new Insets(0, 0, 5, 5);
		gbc_lblBojaIvice.gridx = 0;
		gbc_lblBojaIvice.gridy = 1;
		pnlSelektovan.add(lblBojaIvice, gbc_lblBojaIvice);

		JLabel lblBojaUnutranjosti = new JLabel("Inside color:");
		lblBojaUnutranjosti.setFont(new Font("SansSerif", Font.BOLD, 12));
		GridBagConstraints gbc_lblBojaUnutranjosti = new GridBagConstraints();
		gbc_lblBojaUnutranjosti.insets = new Insets(0, 0, 5, 0);
		gbc_lblBojaUnutranjosti.gridx = 1;
		gbc_lblBojaUnutranjosti.gridy = 1;
		pnlSelektovan.add(lblBojaUnutranjosti, gbc_lblBojaUnutranjosti);

		JScrollPane scrpnlCrtanje = new JScrollPane();
		frame.getContentPane().add(scrpnlCrtanje, BorderLayout.CENTER);


		pnlCrtez.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tglbtnTacka.isSelected()){
					x = e.getX();
					y = e.getY();
					bojaIvice = JColorChooser.showDialog(null,"Choose the color of the dot: ", bojaIvice);
					Tacka tacka = new Tacka(x, y, bojaIvice);;
					pnlCrtez.listaOblika.add(tacka);
				}
				else if(tglbtnLinija.isSelected())
				{
					if(p==0)
					{
						oblik = new Linija(new Tacka(e.getX(), e.getY()), new Tacka(0,0));
						p++;
						return;
					}
					else{
						Linija linija = (Linija)oblik;
						bojaIvice = JColorChooser.showDialog(null,"Choose the color of the line: ", bojaIvice);
						linija.setBoja(bojaIvice);
						linija.settKrajnja(new Tacka(e.getX(), e.getY()));
						p = 0;
						pnlCrtez.listaOblika.add(linija);
					}
				}
				else if(tglbtnKvadrat.isSelected())
				{
					dlgK.setProvera(false);
					x = e.getX();
					y = e.getY();
					dlgK.getTxtX().setText(Integer.toString(x));
					dlgK.getTxtY().setText(Integer.toString(y));
					dlgK.getTxtX().setEditable(false);
					dlgK.getTxtY().setEditable(false);
					try { 
						dlgK.setVisible(true);
						int duzinaStranice = Integer.parseInt(dlgK.getTxtDuzinaStranice().getText());;
						if (duzinaStranice <= 0)
							throw ex;
						Color bojaIvice = dlgK.getPnlBojaIvice().getBackground();
						Color bojaUnutrasnjosti = dlgK.getPnlBojaUnutrasnjosti().getBackground();
						Kvadrat kv = new Kvadrat(new Tacka(x, y), duzinaStranice, bojaIvice, bojaUnutrasnjosti);
						if (dlgK.isProvera())
							pnlCrtez.listaOblika.add(kv);
						dlgK.getTxtX().setText("");
						dlgK.getTxtY().setText("");
						dlgK.getTxtDuzinaStranice().setText("");
						dlgK.getPnlBojaIvice().setBackground(Color.WHITE);
						dlgK.getPnlBojaUnutrasnjosti().setBackground(Color.WHITE);
					}
					catch (Exception exp) {
						JOptionPane.showMessageDialog(null, "Error, wrong value.");
						dlgK.getTxtX().setText("");
						dlgK.getTxtY().setText("");
						dlgK.getTxtDuzinaStranice().setText("");
						dlgK.getPnlBojaIvice().setBackground(Color.WHITE);
						dlgK.getPnlBojaUnutrasnjosti().setBackground(Color.WHITE);
					}
				}
				else if(tglbtnPravougaonik.isSelected())
				{
					dlgP.setProvera(false);
					x = e.getX();
					y = e.getY();
					dlgP.getTxtX().setText(Integer.toString(x));
					dlgP.getTxtY().setText(Integer.toString(y));
					dlgP.getTxtX().setEditable(false);
					dlgP.getTxtY().setEditable(false);
					try {
						dlgP.setVisible(true);
						int duzinaStranice = Integer.parseInt(dlgP.getTxtDuzinaStranice().getText());
						int visina = Integer.parseInt(dlgP.getTxtVisina().getText());
						if (duzinaStranice <= 0 | visina <= 0)
							throw ex;
						Color bojaIvice = dlgP.getPnlBojaIvice().getBackground();
						Color bojaUnutrasnjosti = dlgP.getPnlBojaUnutrasnjosti().getBackground();
						Pravougaonik p1 = new Pravougaonik(new Tacka(x, y), duzinaStranice, visina, bojaIvice, bojaUnutrasnjosti);
						if (dlgP.isProvera())
							pnlCrtez.listaOblika.add(p1);
						dlgP.getTxtX().setText("");
						dlgP.getTxtY().setText("");
						dlgP.getTxtDuzinaStranice().setText("");
						dlgP.getTxtVisina().setText("");
						dlgP.getPnlBojaIvice().setBackground(Color.WHITE);
						dlgP.getPnlBojaUnutrasnjosti().setBackground(Color.WHITE);
					}
					catch (Exception exp) {
						JOptionPane.showMessageDialog(null, "Error, wrong value.");
						dlgP.getTxtX().setText("");
						dlgP.getTxtY().setText("");
						dlgP.getTxtDuzinaStranice().setText("");
						dlgP.getTxtVisina().setText("");
						dlgP.getPnlBojaIvice().setBackground(Color.WHITE);
						dlgP.getPnlBojaUnutrasnjosti().setBackground(Color.WHITE);
					}
				}
				else if(tglbtnKrug.isSelected()){
					dlgKr.setProvera(false);
					x = e.getX();
					y = e.getY();
					dlgKr.getTxtX().setText(Integer.toString(x));
					dlgKr.getTxtY().setText(Integer.toString(y));
					dlgKr.getTxtX().setEditable(false);
					dlgKr.getTxtY().setEditable(false);
					try {
						dlgKr.setVisible(true);
						int duzinaStranice = Integer.parseInt(dlgKr.getTxtDuzinaStranice().getText());
						if (duzinaStranice <= 0)
							throw ex;
						Color bojaIvice = dlgKr.getPnlBojaIvice().getBackground();
						Color bojaUnutrasnjosti = dlgKr.getPnlBojaUnutrasnjosti().getBackground();
						Krug kg = new Krug(new Tacka(x, y), duzinaStranice, bojaIvice, bojaUnutrasnjosti);
						if (dlgKr.isProvera())
							pnlCrtez.listaOblika.add(kg);
						dlgKr.getTxtX().setText("");
						dlgKr.getTxtY().setText("");
						dlgKr.getTxtDuzinaStranice().setText("");
						dlgKr.getPnlBojaIvice().setBackground(Color.WHITE);
						dlgKr.getPnlBojaUnutrasnjosti().setBackground(Color.WHITE);
					}
					catch (Exception exp) {
						JOptionPane.showMessageDialog(null, "Error, wrong value.");
						dlgKr.getTxtX().setText("");
						dlgKr.getTxtY().setText("");
						dlgKr.getTxtDuzinaStranice().setText("");
						dlgKr.getPnlBojaIvice().setBackground(Color.WHITE);
						dlgKr.getPnlBojaUnutrasnjosti().setBackground(Color.WHITE);
					}
				}
				else if(tglbtnSelektuj.isSelected()){
					for(int i = pnlCrtez.listaOblika.size()-1; i>=0; i--){
						if (pnlCrtez.listaOblika.get(i).isSelektovan()){
							return;	
						}
						else if(pnlCrtez.listaOblika.get(i) instanceof Tacka)
						{
							Tacka pomocnaT = (Tacka)pnlCrtez.listaOblika.get(i);
							if(pomocnaT.sadrzi(e.getX(), e.getY())){
								pomocnaT.selektovan(pnlCrtez.getGraphics());
								selektovan.setText("Dot");
								pnlBojaIvice.setBackground(pomocnaT.getBoja());
								return;
							}
						}
						else if(pnlCrtez.listaOblika.get(i) instanceof Linija)
						{
							Linija pomocnaL = (Linija)pnlCrtez.listaOblika.get(i);
							if(pomocnaL.sadrzi(e.getX(), e.getY())){
								pomocnaL.selektovan(pnlCrtez.getGraphics());
								selektovan.setText("Line");
								pnlBojaIvice.setBackground(pomocnaL.getBoja());
								return;
							}
						}
						else if(pnlCrtez.listaOblika.get(i) instanceof Krug)
						{
							Krug pomocniK = (Krug)pnlCrtez.listaOblika.get(i);
							if(pomocniK.sadrzi(e.getX(), e.getY())){
								pomocniK.selektovan(pnlCrtez.getGraphics());
								selektovan.setText("Circle");
								pnlBojaIvice.setBackground(pomocniK.getBoja());
								pnlBojaUnutrasnjosti.setBackground(pomocniK.getBojaUnutrasnjosti());
								return;
							}
						}	
						else if(pnlCrtez.listaOblika.get(i) instanceof Kvadrat)
						{
							Kvadrat pomocniK = (Kvadrat)pnlCrtez.listaOblika.get(i);
							if(pomocniK.sadrzi(e.getX(), e.getY())){
								pomocniK.selektovan(pnlCrtez.getGraphics());
								selektovan.setText("Square");
								pnlBojaIvice.setBackground(pomocniK.getBoja());
								pnlBojaUnutrasnjosti.setBackground(pomocniK.getBojaUnutrasnjosti());
								return;
							}
						}
						else if(pnlCrtez.listaOblika.get(i) instanceof Pravougaonik)
						{
							Pravougaonik pomocniP = (Pravougaonik)pnlCrtez.listaOblika.get(i);
							if(pomocniP.sadrzi(e.getX(), e.getY())){
								pomocniP.selektovan(pnlCrtez.getGraphics());
								selektovan.setText("Rectangle");
								pnlBojaIvice.setBackground(pomocniP.getBoja());
								pnlBojaUnutrasnjosti.setBackground(pomocniP.getBojaUnutrasnjosti());
								return;
							}
						}
					}
				}
			}
			public void mousePressed(MouseEvent e) {
				for(int i = pnlCrtez.listaOblika.size()-1; i>=0; i--){
					if (pnlCrtez.listaOblika.get(i).isSelektovan()) {
						pnlCrtez.listaOblika.get(i).setSelektovan(false);
						selektovan.setText("");
						return;
					}
					if (pnlCrtez.listaOblika.get(i).isSelektovan() && pnlCrtez.listaOblika.get(i+1).isSelektovan()) {
						pnlCrtez.listaOblika.get(i+1).setSelektovan(true);
					}
				}
			}
		});
		pnlCrtez.setBackground(SystemColor.window);
		scrpnlCrtanje.setViewportView(pnlCrtez);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTextField getSelektovan() {
		return selektovan;
	}

	public void setSelektovan(JTextField selektovan) {
		this.selektovan = selektovan;
	}

	public JPanel getPnlKontrolni() {
		return pnlKontrolni;
	}

	public void setPnlKontrolni(JPanel pnlKontrolni) {
		this.pnlKontrolni = pnlKontrolni;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getP() {
		return p;
	}

	public void setP(int p) {
		this.p = p;
	}

	public Object getOblik() {
		return oblik;
	}

	public void setOblik(Object oblik) {
		this.oblik = oblik;
	}

	public Color getBojaIvice() {
		return bojaIvice;
	}

	public void setBojaIvice(Color bojaIvice) {
		this.bojaIvice = bojaIvice;
	}

	public Color getBojaUnutrasnjosti() {
		return bojaUnutrasnjosti;
	}

	public void setBojaUnutrasnjosti(Color bojaUnutrasnjosti) {
		this.bojaUnutrasnjosti = bojaUnutrasnjosti;
	}

	public JToggleButton getTglbtnSelektuj() {
		return tglbtnSelektuj;
	}

	public void setTglbtnSelektuj(JToggleButton tglbtnSelektuj) {
		this.tglbtnSelektuj = tglbtnSelektuj;
	}

	public JToggleButton getTglbtnTacka() {
		return tglbtnTacka;
	}

	public void setTglbtnTacka(JToggleButton tglbtnTacka) {
		this.tglbtnTacka = tglbtnTacka;
	}

	public JToggleButton getTglbtnLinija() {
		return tglbtnLinija;
	}

	public void setTglbtnLinija(JToggleButton tglbtnLinija) {
		this.tglbtnLinija = tglbtnLinija;
	}

	public JToggleButton getTglbtnKvadrat() {
		return tglbtnKvadrat;
	}

	public void setTglbtnKvadrat(JToggleButton tglbtnKvadrat) {
		this.tglbtnKvadrat = tglbtnKvadrat;
	}

	public JToggleButton getTglbtnKrug() {
		return tglbtnKrug;
	}

	public void setTglbtnKrug(JToggleButton tglbtnKrug) {
		this.tglbtnKrug = tglbtnKrug;
	}

	public JToggleButton getTglbtnPravougaonik() {
		return tglbtnPravougaonik;
	}

	public void setTglbtnPravougaonik(JToggleButton tglbtnPravougaonik) {
		this.tglbtnPravougaonik = tglbtnPravougaonik;
	}

	public JToggleButton getTglbtnModifikuj() {
		return tglbtnModifikuj;
	}

	public void setTglbtnModifikuj(JToggleButton tglbtnModifikuj) {
		this.tglbtnModifikuj = tglbtnModifikuj;
	}

	public JToggleButton getTglbtnObrisi() {
		return tglbtnObrisi;
	}

	public void setTglbtnObrisi(JToggleButton tglbtnObrisi) {
		this.tglbtnObrisi = tglbtnObrisi;
	}

	public PanelCrtanje getPnlCrtez() {
		return pnlCrtez;
	}

	public void setPnlCrtez(PanelCrtanje pnlCrtez) {
		this.pnlCrtez = pnlCrtez;
	}

	public boolean isProvera() {
		return Provera;
	}

	public void setProvera(boolean provera) {
		Provera = provera;
	}

	public Exception getEx() {
		return ex;
	}

	public void setEx(Exception ex) {
		this.ex = ex;
	}

	public DlgKvadrat getDlgK() {
		return dlgK;
	}

	public void setDlgK(DlgKvadrat dlgK) {
		this.dlgK = dlgK;
	}

	public DlgPravougaonik getDlgP() {
		return dlgP;
	}

	public void setDlgP(DlgPravougaonik dlgP) {
		this.dlgP = dlgP;
	}

	public DlgKrug getDlgKr() {
		return dlgKr;
	}

	public void setDlgKr(DlgKrug dlgKr) {
		this.dlgKr = dlgKr;
	}

	public DlgTacka getDlgT() {
		return dlgT;
	}

	public void setDlgT(DlgTacka dlgT) {
		this.dlgT = dlgT;
	}

	public DlgLinija getDlgL() {
		return dlgL;
	}

	public void setDlgL(DlgLinija dlgL) {
		this.dlgL = dlgL;
	}

}
