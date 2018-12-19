package Trenes;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import static Trenes.Constantes.*;

public class Ventana extends JPanel {

	private ImageIcon fondo;
	private ImageIcon tren[] = new ImageIcon[NUM_TRENES];
	int x[] = new int[NUM_TRENES];
	int y[] = new int[NUM_TRENES];
	int numTren[] = new int[NUM_TRENES];

	public Ventana() {

		for (int i = 0; i < numTren.length; i++) {
			y[i] = 20;
			numTren[i] = 1;
		}
	}

	@Override
	public void paintComponent(Graphics g) {

		fondo = new ImageIcon(getClass().getResource("/fotos/vias1t.jpg"));
		g.drawImage(fondo.getImage(), 0, 0, getWidth(), getHeight(), this);
		setOpaque(false);
		super.paintComponent(g);

		setVisible(true);

		for (int i = 0; i < NUM_TRENES; i++) {

			tren[i] = new ImageIcon(getClass().getResource("/fotos/TREN" + numTren[i] + ".png"));
			g.drawImage(tren[i].getImage(), x[i], y[i], 100, 90, this);
			setOpaque(false);
			super.paintComponent(g);
			setVisible(true);
		}

	}

	public void mover(int id, int distancia, int semaforo, int vuelta) {
		System.out.println(semaforo);
		if (semaforo == 0) {
			if (vuelta == 0) {
				if (x[id] != 200) {
					x[id] += 15;
				}

			} else {
				

					numTren[id] = 1;
					x[id] = 300;
					y[id] = 20;
				
			}
		}
		if (semaforo > 0 && semaforo < 3) {

			if (x[id] < 970) {
				x[id] += 25;
				repaint();
			}
		}
		if (semaforo == 3) {
			if (y[id] < 200) {
				numTren[id] = 5;
				y[id] = 640;
				x[id] = 970;
			}
		}
		if (semaforo > 3 && semaforo < 6) {
			if (x[id] > 200) {
				x[id] -= 25;

			}

		}
		

		repaint();
	}

}
