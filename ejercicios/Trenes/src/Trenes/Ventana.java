package Trenes;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Ventana extends javax.swing.JPanel {

	ImageIcon imagen;
	ImageIcon imagen2;

	// int colum;
	String nombre;

	static int columna = 20; // posicion inicial del muñeco parado orizontal
	static JPanel panel;
	static int fila = 195; // posicion inicial del muñeco parado vertical

	Tren2 tren;
	Tren2 tren2;

	public Ventana(String nombre) {
		this.nombre = nombre;
		this.tren = new Tren2("/fotos/tren1.png");
		this.tren2 = new Tren2("/fotos/tren2.png");

	}

	public void paint(Graphics g) {
		Dimension tamanio = getSize();
		imagen = new ImageIcon(getClass().getResource("/fotos/via.gif"));
		g.drawImage(imagen.getImage(), 0, 0, tamanio.width, tamanio.height, null);
		setOpaque(false);

	}

	public static int getColumna() {
		return columna;
	}

	public void setColumna(int columna) {
		Ventana.columna = this.columna + columna;
	}

	public static int getFila() {
		return fila;
	}

	public void setFila(int fila) {
		Ventana.fila = this.fila + fila;
	}

	public void mover(int x, int y) {

		setFila(y);
		setColumna(x);

		repaint();
	}

}
