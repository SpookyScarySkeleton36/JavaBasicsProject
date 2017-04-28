package wb;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

import geometrija.Oblik;
import geometrija.OblikDva;
//omogucava crtanje i brisanje sa panela u aplikaciji Crtanje
public class PanelCrtanje extends JPanel {
	ArrayList<Oblik> listaOblika = new ArrayList<Oblik>();

	public PanelCrtanje() {
		setBackground(Color.WHITE);
	}

	public void paint(Graphics g){
		super.paint(g);
		Iterator<Oblik> it = listaOblika.iterator(); 
		while(it.hasNext()){
			Oblik o = (Oblik) it.next();
			o.crtajSe(g); //crtanje oblika
		}
		repaint(); //brisanje
	}

}
