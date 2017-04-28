package geometrija;

import java.awt.Color;
import java.awt.Graphics;

public class Linija extends Oblik{
	private Tacka tPocetna;
	private Tacka tKrajnja;

	public Linija(){

	}
	public Linija(Tacka tPocetna, Tacka tKrajnja){
		this.tPocetna = tPocetna;
		this.tKrajnja = tKrajnja;
	}
	public Linija(Tacka tPocetna, Tacka tKrajnja, Color boja){
		this(tPocetna,tKrajnja);
		setBoja(boja);
	}

	public void pomeriZa(int x, int y){
		tPocetna.setX(tPocetna.getX()+x);
		tPocetna.setY(tPocetna.getY()+y);
		tKrajnja.setX(tKrajnja.getX()+x);
		tKrajnja.setY(tKrajnja.getY()+y);		
	}

	public double duzina(){
		return tPocetna.udaljenost(tKrajnja);
	}
	// (xPocetne,yPocetne)-->(xKrajnje,yKrajnje)
	public String toString(){
		return tPocetna+"-->"+tKrajnja;
	}
	public boolean equals(Object obj){
		if(obj instanceof Linija){
			Linija pomocna = (Linija) obj;
			if(tPocetna.equals(pomocna.gettPocetna()) && tKrajnja.equals(pomocna.gettKrajnja()))
				return true;
			else
				return false;
		}
		else
			return false;
	}
	public Tacka sredinaLinije(){
		int sredinaX = (tPocetna.getX() + tKrajnja.getX()) / 2;
		int sredinaY = (tPocetna.getY() + tKrajnja.getY()) / 2;
		return new Tacka(sredinaX, sredinaY);
	}
	public boolean sadrzi(int x, int y){
		Tacka mestoKlika = new Tacka(x, y);
		if(mestoKlika.udaljenost(tPocetna)+mestoKlika.udaljenost(tKrajnja)-this.duzina()<0.5)
			return true;
		else 
			return false;
	}
	public void selektovan(Graphics g){
		setSelektovan(true);
		g.setColor(Color.BLUE);
		tPocetna.selektovan(g);
		tKrajnja.selektovan(g);
		sredinaLinije().selektovan(g);
	}
	public void crtajSe(Graphics g){
		g.setColor(getBoja());
		g.drawLine(tPocetna.getX(), tPocetna.getY(), tKrajnja.getX(), tKrajnja.getY());
		if(isSelektovan())
			selektovan(g);
	}
	public int compareTo(Object o) {
		if(o instanceof Linija){
			Linija pomocna = (Linija) o;
			return (int) (this.duzina() - pomocna.duzina());
		}
		else
			return 0;
	}
	public Tacka gettPocetna(){
		return tPocetna;
	}
	public Tacka gettKrajnja(){
		return tKrajnja;
	}
	public void settPocetna(Tacka tPocetna){
		this.tPocetna = tPocetna;
	}
	public void settKrajnja(Tacka tKrajnja){
		this.tKrajnja = tKrajnja;
	}
}
