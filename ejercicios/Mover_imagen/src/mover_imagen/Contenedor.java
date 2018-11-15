
package mover_imagen;

import javax.swing.JComponent;

import javax.swing.JPanel;

import javax.swing.ImageIcon;

import java.awt.Graphics;

import java.awt.Color;

public class Contenedor extends JComponent {
	static JPanel panel;

	static int columna = 3; // posicion inicial del muñeco parado orizontal

	static int fila = 195; // posicion inicial del muñeco parado vertical

	static int numero = 1; // primera foto que se muestra

	Contenedor(JPanel panel) {
		this.panel = panel;

		setBounds(0, 0, panel.getWidth(), panel.getHeight());

	}

	public void paint(Graphics g) {
		
		//El niño y el cambio de imagen
		ImageIcon imagen = new ImageIcon(
				new ImageIcon(getClass().getResource("imagenes/" + numero + ".png")).getImage());

		g.drawImage(imagen.getImage(), columna, fila, 206, 356, null); //el 206 es el ancho y el 356 el alto


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
					System.out.println("paso");
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
		columna = 3; //posicion en la que empieza el movimiento
	}
}
