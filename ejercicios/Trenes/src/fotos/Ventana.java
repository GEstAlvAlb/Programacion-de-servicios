package fotos;

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

	static int columna = 20; // posicion inicial del mu�eco parado orizontal
	static JPanel panel;
	static int fila = 195; // posicion inicial del mu�eco parado vertical
<<<<<<< HEAD:ejercicios/Trenes/src/Trenes/Ventana.java

	Tren2 tren;
	Tren2 tren2;

	public Ventana(String nombre) {
		this.nombre = nombre;
		this.tren = new Tren2("/fotos/tren1.png");
		this.tren2 = new Tren2("/fotos/tren1.png");

	}

	public void paint(Graphics g) {
		Dimension tamanio = getSize();
		imagen = new ImageIcon(getClass().getResource("/fotos/via.gif"));
=======
	
    public Ventana() {
    	this.nombre=nombre;
    	//this.colum=colum;
    	
    }
 
	public void paint (Graphics g) {
		Dimension tamanio =getSize();
		imagen=new ImageIcon (getClass().getResource("/fotos/via.gif"));
>>>>>>> 64e0cdc93a627a7c8f8ed56a94d2d8c6410e8531:ejercicios/Trenes/src/fotos/Ventana.java
		g.drawImage(imagen.getImage(), 0, 0, tamanio.width, tamanio.height, null);
		setOpaque(false);

		Graphics2D g2 = (Graphics2D) g;

		g2.drawImage(new ImageIcon(getClass().getResource("/fotos/tren1.png")).getImage(), getColumna(), getFila(),
				null);
		
		g2.drawImage(new ImageIcon(getClass().getResource("/fotos/tren2.png")).getImage(), getColumna(), getFila()+210,
				null);

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
<<<<<<< HEAD:ejercicios/Trenes/src/Trenes/Ventana.java
=======
	
	public void mover() {
		repaint();
	}
	 
   
   
    
    
>>>>>>> 64e0cdc93a627a7c8f8ed56a94d2d8c6410e8531:ejercicios/Trenes/src/fotos/Ventana.java

}
