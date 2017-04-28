package geometrija;

import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Crtez extends JPanel{
	int x;
	int y;
	public Crtez() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				x = e.getX();
				y = e.getY();
			}
		});
	}

	public static void main(String[] args){
		JFrame prozor = new JFrame("Crtanje");
		prozor.setSize(800, 600);
		Crtez c = new Crtez();
		prozor.getContentPane().add(c);
		prozor.setVisible(true);
		prozor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void paint(Graphics g){
		Tacka t1 = new Tacka(x, y);
		t1.crtajSe(g);
		repaint();
		/*t1.setBoja("zelena");
		t1.setSelektovan(true);
		t1.crtajSe(g);
		Linija l1 = new Linija(new Tacka(20, 20), new Tacka(150, 30));
		l1.crtajSe(g);
		l1.gettPocetna().crtajSe(g);
		l1.gettPocetna().setBoja("plava");
		l1.gettKrajnja().setBoja("zelena");
		l1.setBoja("crvena");
		l1.gettPocetna().crtajSe(g);
		l1.gettKrajnja().crtajSe(g);
		l1.crtajSe(g);
		Pravougaonik p1 = new Pravougaonik(new Tacka(200, 30), 100, 50,"crvEnA");
		Kvadrat kv1 = new Kvadrat(new Tacka(400, 30), 100, "pLAVa");
		p1.crtajSe(g);
		kv1.crtajSe(g);
		Krug kr1 = new Krug(new Tacka(600, 200), 100,"plava");
		kr1.crtajSe(g);
		kr1.setBojaUnutrasnjosti("crvena");
		kr1.popuni(g);
		kv1.setBojaUnutrasnjosti("crvena");
		kv1.popuni(g);
		p1.popuni(g);*/
	}

}
