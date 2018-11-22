package Trenes;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Ventana2 extends JFrame {
	static Ventana panel = new Ventana();
	
	public Ventana2() {

		
		this.add(panel, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
	}

	public static void main(String args[]) {

		new Ventana2();
		panel.mover();

	};
}
