package geometrija;

import java.awt.Color;
import java.awt.Graphics;

public class Kvadrat extends OblikDva implements Pomerljiv{
	protected Tacka goreLevo;
	protected int duzinaStranice;

	public Kvadrat(){

	}
	public Kvadrat(Tacka goreLevo, int duzinaStranice){
		this.goreLevo = goreLevo;
		this.duzinaStranice = duzinaStranice;
	}
	public Kvadrat(Tacka goreLevo, int duzinaStranice,Color boja, Color bojaUnutrasnjosti){
		this(goreLevo,duzinaStranice);
		setBoja(boja);
		setBojaUnutrasnjosti(bojaUnutrasnjosti);
	}
	public Kvadrat(Tacka goreLevo, int duzinaStranice, String boja, String bojaUnutrasnjosti){
		this(goreLevo,duzinaStranice);
		setBojaIvice(boja);
		setStrBojaUnutrasnjosti(bojaUnutrasnjosti);
	}
	public void pomeriNa(int x, int y){
		goreLevo.setX(x);
		goreLevo.setY(y);
	}

	public void pomeriZa(int x, int y){
		goreLevo.setX(goreLevo.getX()+x);
		goreLevo.setY(goreLevo.getY()+y);
	}

	public int obim(){
		return 4 * duzinaStranice;
	}
	public int povrsina(){
		return duzinaStranice * duzinaStranice;
	}
	//Tacka gore levo=(xGoreLevo,yGoreLevo), duzina stranice=duzinaStranice
	public String toString(){
		return "Upper left dot="+goreLevo+", width="+duzinaStranice+", edge color="+this.getBojaIvice()+", inside color="+this.getStrBojaUnutrasnjosti();
	}
	public boolean equals(Object obj){
		if(obj instanceof Kvadrat){
			Kvadrat pomocni = (Kvadrat) obj;
			if(goreLevo.equals(pomocni.goreLevo) && duzinaStranice == pomocni.duzinaStranice)
				return true;
			else
				return false;

		}
		else
			return false;
	}
	public Linija dijagonala(){
		return new Linija(goreLevo, new Tacka(goreLevo.getX() + duzinaStranice,goreLevo.getY() + duzinaStranice));
	}

	public Tacka centar(){
		return dijagonala().sredinaLinije();
	}
	public boolean sadrzi(int x, int y) {
		if(this.getGoreLevo().getX()<=x 
				&& x<=(this.getGoreLevo().getX() + duzinaStranice)
				&& this.getGoreLevo().getY()<=y 
				&& y<=(this.getGoreLevo().getY() + duzinaStranice))
			return true;
		else 
			return false;

	}
	public void selektovan(Graphics g) {
		// TODO Auto-generated method stub
		setSelektovan(true);
		g.setColor(Color.BLUE);
		new Linija(getGoreLevo(), new Tacka(getGoreLevo().getX()+duzinaStranice, getGoreLevo().getY())).selektovan(g);
		new Linija(getGoreLevo(), new Tacka(getGoreLevo().getX(), getGoreLevo().getY()+duzinaStranice)).selektovan(g);
		new Linija(new Tacka(getGoreLevo().getX()+duzinaStranice, getGoreLevo().getY()), dijagonala().gettKrajnja()).selektovan(g);
		new Linija(new Tacka(getGoreLevo().getX(), getGoreLevo().getY()+duzinaStranice), dijagonala().gettKrajnja()).selektovan(g);

	}
	public void crtajSe(Graphics g){
		g.setColor(getBoja());
		g.drawRect(goreLevo.getX(), goreLevo.getY(), duzinaStranice, duzinaStranice);
		popuni(g);
		if(isSelektovan())
			selektovan(g);
	}

	public void popuni(Graphics g) {
		g.setColor(getBojaUnutrasnjosti());
		g.fillRect(goreLevo.getX()+1, goreLevo.getY()+1, duzinaStranice-1, duzinaStranice-1);

	}

	public int compareTo(Object o) {
		if(o instanceof Kvadrat){
			Kvadrat pomocni = (Kvadrat) o;
			return (int) (this.povrsina() - pomocni.povrsina());
		}
		else
			return 0;
	}
	public Tacka getGoreLevo() {
		return goreLevo;
	}

	public int getDuzinaStranica() {
		return duzinaStranice;
	}
	public void setGoreLevo(Tacka goreLevo) {
		this.goreLevo = goreLevo;
	}
	public void setDuzinaStranica(int duzinaStranica) {
		this.duzinaStranice = duzinaStranica;
	}
	public int getDuzinaStranice() {
		return duzinaStranice;
	}

	public void setDuzinaStranice(int duzinaStranice) {
		this.duzinaStranice = duzinaStranice;
	}


}
