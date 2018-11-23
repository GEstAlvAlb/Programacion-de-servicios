package Trenes;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import static Trenes.Constantes.*;

public class Ventana extends JPanel {

	private ImageIcon fondo;
	private ImageIcon tren[] = new ImageIcon[3];
	int x[] = new int[3];
	int y[] = { 20, 20, 20 };
	int numTren = 1;

	public Ventana() {

	}

	@Override
	public void paintComponent(Graphics g) {

		fondo = new ImageIcon(getClass().getResource("/fotos/vias1t.jpg"));
		g.drawImage(fondo.getImage(), 0, 0, getWidth(), getHeight(), this);
		setOpaque(false);
		super.paintComponent(g);

		setVisible(true);

		for (int i = 0; i < NUM_TRENES; i++) {

			tren[i] = new ImageIcon(getClass().getResource("/fotos/TREN" + numTren + ".png"));
			g.drawImage(tren[i].getImage(), x[i], y[i], 100, 90, this);
			setOpaque(false);
			super.paintComponent(g);
			setVisible(true);
		}

	}

	public void mover(int id, int distancia, int semaforo, int vuelta) {

		if (vuelta != 1) {

			if (semaforo == 0) {
				if (x[id] > 200) {
					x[id] -= 20;

				} else {
					if (y[id] > 400) {
						x[id] -= 15;
						y[id] -= 30;
					}else {
						if(x[id]<200) {
							x[id]+=15;
							y[id]-=40;
						}
					}

					System.out.println("esta es la id " + y[id]);
				}

			}
			repaint();
			return;
		}
		if(semaforo==0) {
			x[id]+=15;
			repaint();
			return;
		}

		if (semaforo < 3) {
			x[id] += 25;

		} else {
			int i = 0;

			if (semaforo == 3) {
				if (x[id] < 950 && y[id] < 500) {
					numTren = 2;
					x[id] += 30;
				} else {
					if (y[id] <= 190) {
						x[id] += 23;
						y[id] += 20;

					} else {
						if (y[id] < 300) {
							numTren = 3;
							y[id] += 24;
							x[id] += 10;
						} else {
							if (y[id] < 500) {
								numTren = 4;
								y[id] += 24;
								x[id] -= 5;

							} else {
								if (y[id] < 630) {

									y[id] += 24;
									x[id] -= 10;

								} else {
									if (x[id] < 1200) {
										numTren = 5;
										x[id] -= 25;
									}
								}

							}

						}

					}

				}
			} else {
				if (semaforo < 10) {
					numTren = 5;
					x[id] -= 20;

				}
			}
		}

		repaint();
	}

}
