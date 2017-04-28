package geometrija;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Oblik implements Comparable{
	private Color bojaIvice = Color.BLACK;
	private String strBojaIvice = "black";
	private boolean selektovan;

	public Oblik(){

	}
	public Oblik(Color boja){
		this.bojaIvice = boja;
	}

	public abstract void crtajSe(Graphics g);
	public abstract void selektovan(Graphics g);
	public abstract boolean sadrzi(int x, int y);

	public static Color pronadjiBoju(String color){
		if(color.equalsIgnoreCase("black"))
			return Color.BLACK;
		else if(color.equalsIgnoreCase("white"))
			return Color.WHITE;
		else if(color.equalsIgnoreCase("blue"))
			return Color.BLUE;
		else if(color.equalsIgnoreCase("red"))
			return Color.RED;
		else if(color.equalsIgnoreCase("green"))
			return Color.GREEN;
		else if(color.equalsIgnoreCase("yellow"))
			return Color.YELLOW;
		else if(color.equalsIgnoreCase("pink"))
			return Color.PINK;
		else
			return Color.BLACK;

	}

	public Color getBoja() {
		return bojaIvice;
	}

	public void setBoja(Color boja) {
		this.bojaIvice = boja;
	}
	public boolean isSelektovan() {
		return selektovan;
	}
	public void setSelektovan(boolean selektovan) {
		this.selektovan = selektovan;
	}
	public String getBojaIvice() {
		return strBojaIvice;
	}
	public void setBojaIvice(String bojaIvice) {
		this.strBojaIvice = bojaIvice;
	}


}