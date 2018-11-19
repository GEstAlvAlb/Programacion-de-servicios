package Trenes;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Ventana extends javax.swing.JPanel{

	ImageIcon imagen;
	//int colum;
	String nombre;
	
	static int columna = 20; // posicion inicial del muñeco parado orizontal

	static int fila = 195; // posicion inicial del muñeco parado vertical
	
    public Ventana(String nombre) {
    	this.nombre=nombre;
    	//this.colum=colum;
    	
    }
 
	public void paint (Graphics g) {
		Dimension tamanio =getSize();
		imagen=new ImageIcon (getClass().getResource(nombre));
		g.drawImage(imagen.getImage(), 0, 0, tamanio.width, tamanio.height, null);
		setOpaque(false);
		
		
		ImageIcon imagen = new ImageIcon(new ImageIcon(getClass().getResource("/fotos/tren1.png")).getImage());

		g.drawImage(imagen.getImage(), columna, fila, 30, 40, null); //el 206 es el ancho y el 356 el alto
		super.paint(g);
		
		
		
	}
	
	 
   
   
    
    

    
}
