
package mover_imagen;

import javax.swing.JComponent;

import javax.swing.JPanel;

import javax.swing.ImageIcon;

import java.awt.Graphics;

import java.awt.Color;

public class Contenedor extends JComponent {
	static JPanel panel;

	static int columna = 3;

	static int fila = 195;

	static int numero = 1;

	Contenedor(JPanel panel) {
		this.panel = panel;

		setBounds(0, 0, panel.getWidth(), panel.getHeight());

	}

	public void paint(Graphics g) {
		
		//El niño
		ImageIcon imagen = new ImageIcon(
				new ImageIcon(getClass().getResource("imagenes/" + numero + ".png")).getImage());

		g.drawImage(imagen.getImage(), columna, fila, 206, 356, null);

		// nuves
		/*
		 * g.setColor(Color.WHITE);
		 * 
		 * g.fillOval(35,40 ,100, 30); g.fillOval(70,45 ,150, 50); g.fillOval(160,55
		 * ,100, 30); g.fillOval(320,45 ,100, 25); g.fillOval(340,40 ,100, 25);
		 * g.fillOval(700,40 ,100, 30); g.fillOval(780,40 ,100, 30); g.fillOval(610,50
		 * ,150, 30);
		 **/

		// sol

		/*
		 * g.setColor(Color.YELLOW);
		 * 
		 * g.fillOval(480,30 ,80,80);
		 */

	}

	static Thread hilo = new Thread() {
		@Override
		public void run() {
			try {
				while (true) {
					numero++;

					if (numero == 8) {
						numero = 1;
					}

					panel.repaint();

					columna += 10;

					hilo.sleep(100);
				}

			} catch (java.lang.InterruptedException ex) {
				System.out.println(ex.getMessage());
			}
		}
	};

	public static void mover() {
		if (!hilo.isAlive()) {
			hilo.start();
		}
		columna = 3;
	}
}
