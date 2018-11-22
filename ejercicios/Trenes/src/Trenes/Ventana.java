package Trenes;

import java.awt.Component;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Ventana extends JPanel {
	private ImageIcon fondo;
	private ImageIcon tren[] = new ImageIcon[3];
	int x[] = new int[3];
	int y[] = new int[3];
	

	public Ventana() {

	}

	@Override
	public void paintComponent(Graphics g) {

		y[1]= 50;
		y[2]=180;
		y[0]=320;
		
		fondo = new ImageIcon(getClass().getResource("/fotos/via.gif"));
		g.drawImage(fondo.getImage(), 0, 0, getWidth(), getHeight(), this);
		setOpaque(false);
		super.paintComponent(g);
		
		setVisible(true);

		for (int i = 0; i <= 2; i++) {

			tren[i] = new ImageIcon(getClass().getResource("/fotos/tren" + (i + 1) + ".png"));
			g.drawImage(tren[i].getImage(), x[i], y[i], 120, 120, this);
			setOpaque(false);
			super.paintComponent(g);
			setVisible(true);
		}

	}

	public void mover() 
	{
		/*for (int i = 0; i < 1002; i++) {
			
			x[1] += 1;
			y[1] += 1;
		}*/
	}

}
