package geometrija;

import java.awt.Color;
import java.awt.Graphics;


public abstract class OblikDva extends Oblik {
	private Color bojaUnutrasnjosti = Color.BLACK;
	private String strBojaUnutrasnjosti = "black";

	public abstract void popuni(Graphics g);

	public Color getBojaUnutrasnjosti() {
		return bojaUnutrasnjosti;
	}

	public void setBojaUnutrasnjosti(Color bojaUnutrasnjosti) {
		this.bojaUnutrasnjosti = bojaUnutrasnjosti;
	}

	public String getStrBojaUnutrasnjosti() {
		return strBojaUnutrasnjosti;
	}

	public void setStrBojaUnutrasnjosti(String strBojaUnutrasnjosti) {
		this.strBojaUnutrasnjosti = strBojaUnutrasnjosti;
	}




}
