package Trenes;

import static Trenes.Constantes.NUM_TRENES;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Ventana extends javax.swing.JPanel {

	private final PanelFondo jpanel = new PanelFondo();

	JLabel[] imagenTren = new JLabel[3];
	JFrame framePrincipal = null;
	ImageIcon imagen;

	public Ventana() {

		iniciar();
		framePrincipal.setVisible(true);

	}



	public void paint(Graphics g) {
		Dimension tamanio = getSize();
		imagen = new ImageIcon(getClass().getResource("/fotos/via.gif"));
		g.drawImage(imagen.getImage(), 0, 0, tamanio.width, tamanio.height, null);
		setOpaque(false);
		
		

}
	public void iniciar() {
		framePrincipal = new JFrame("CARRERA");
		framePrincipal.setSize(1300, 900);
		framePrincipal.setLayout(null);
		framePrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
		framePrincipal.setLocationRelativeTo(null);
		framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//painComponent(null);

		for (int i = 0; i < NUM_TRENES; i++) {
			imagenTren[i] = new JLabel();
			imagenTren[i].setBounds(10, 50, 250, 250);
			ImageIcon fotoTren = new ImageIcon(getClass().getResource("/fotos/tren" + (i + 1) + ".png"));
			ImageIcon imgEscalada = new ImageIcon(fotoTren.getImage().getScaledInstance(imagenTren[i].getWidth(),
					imagenTren[i].getHeight(), Image.SCALE_DEFAULT));
			imagenTren[i].setIcon(imgEscalada);
			framePrincipal.add(imagenTren[i]);

		}
	}

	public void mover(int id) {

		imagenTren[id].setLocation(imagenTren[id].getX() + 5, imagenTren[id].getY());
	}

}
