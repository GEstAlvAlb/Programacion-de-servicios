package asd;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Interfaz {
	JFrame framePrincipal = null;
	JLabel imagenFriki[]=  new JLabel[3]; 


	
	public Interfaz() {
		iniciar();
		framePrincipal.setVisible(true);
	}

	/*
	 * 10,50,250,250 10,320,250,250 10,590,250,250
	 */
	public void iniciar() {
		framePrincipal = new JFrame("CARRERA");
		framePrincipal.setSize(1300, 900);
		framePrincipal.setLayout(null);
		framePrincipal.getContentPane().setBackground(Color.white);
		framePrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
		framePrincipal.setLocationRelativeTo(null);
		framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		int x[]= {50,320,590};

		for (int i = 0; i <= 2; i++) {
			imagenFriki[i] = new JLabel();
			imagenFriki[i].setBounds(10, x[i], 250, 250);
			ImageIcon imgfriki1 = new ImageIcon(getClass().getResource("/fotos/tren"+(i+1)+".png"));
			ImageIcon imgescalada = new ImageIcon(imgfriki1.getImage().getScaledInstance(imagenFriki[i].getWidth(),
					imagenFriki[i].getHeight(), Image.SCALE_DEFAULT));
			imagenFriki[i].setIcon(imgescalada);
			framePrincipal.add(imagenFriki[i]);
		}

	}

	public void mover(int id) {

		imagenFriki[id].setLocation(imagenFriki[id].getX() + 5, imagenFriki[id].getY());

	}
}