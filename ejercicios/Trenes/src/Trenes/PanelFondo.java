package Trenes;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.ImageIcon;

public class PanelFondo extends javax.swing.JPanel{
	public void painComponent(Graphics g) {
		Dimension tamanio =getSize();
		ImageIcon imagenFondo=new ImageIcon(getClass().getResource("/fotos/via.gif"));
		g.drawImage(imagenFondo.getImage(),0,0,tamanio.width,tamanio.height,null);
		setOpaque(false);
		
		super.paintComponent(g);
	}
	
	

}
