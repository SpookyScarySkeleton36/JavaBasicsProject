package geometrija;

import java.awt.Color;
import java.awt.Graphics;

public class Tacka extends Oblik implements Pomerljiv{
	private int x;
	private int y;


	public Tacka(){

	}
	public Tacka(int x, int y){
		this.x = x;
		this.y = y;
	}
	public Tacka(int x, int y, Color boja){
		this(x, y);
		setBoja(boja);

	}

	public void pomeriNa(int novoX, int novoY){
		x = novoX;
		setY(novoY);
	}
	public void pomeriZa(int novoX, int novoY){
		x = x + novoX;
		setY(getY()+novoY);
	}

	public double udaljenost(Tacka t2){
		double dx = x - t2.getX();
		double dy = y - t2.getY();
		double rezultat = Math.sqrt(dx*dx + dy*dy);

		return rezultat;
	}
	// (x,y)
	public String toString(){
		return "("+x+","+y+")";
	}
	public boolean equals(Object obj){
		if(obj instanceof Tacka){
			Tacka pomocna = (Tacka) obj;
			if(x == pomocna.x && y == pomocna.y)
				return true;
			else
				return false;

		}
		else
			return false;
	}

	public boolean sadrzi(int x, int y){
		Tacka mestoKlika = new Tacka(x, y);
		if(mestoKlika.udaljenost(this)<=2)
			return true;
		else
			return false;
	}

	public void selektovan(Graphics g){
		setSelektovan(true);
		g.setColor(Color.BLUE);
		g.drawRect(x-3, y-3, 6, 6);
	}

	public void crtajSe(Graphics g) {
		g.setColor(getBoja());
		g.drawLine(x+2, y, x-2, y);
		g.drawLine(x, y-2, x, y+2);
		if(isSelektovan())
			selektovan(g);

	}

	public int compareTo(Object o) {
		if(o instanceof Tacka){
			Tacka pomocna = (Tacka) o;
			return (int) this.udaljenost(new Tacka(0, 0)) - (int)pomocna.udaljenost(new Tacka(0, 0));

		}
		else
			return 0;
	}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void setX(int novoX){
		x = novoX;
	}
	public void setY(int novoY){
		y = novoY;
	}
}
