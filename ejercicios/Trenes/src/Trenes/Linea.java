package Trenes;

import javax.swing.JFrame;
import static Trenes.Constantes.*;

import java.awt.BorderLayout;

public class Linea extends JFrame {

	private static Tren a_tren[];
	static Ventana ventana = new Ventana();

	public Linea(){
		this.add(ventana,BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1300,900);
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new Linea();
		a_tren = new Tren[NUM_TRENES];
		System.out.println("Lanzo los trenes");
		
		for (int i = 0; i < NUM_TRENES; i++) {
			a_tren[i] = new Tren(i,ventana);
			a_tren[i].start();
		}

	}

}
