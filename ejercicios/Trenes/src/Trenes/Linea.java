package Trenes;

import javax.swing.JFrame;
import static Trenes.Constantes.*;

public class Linea extends JFrame {

	private static Tren a_tren[];

	public static void main(String[] args) {

	
		
		

		a_tren = new Tren[NUM_TRENES];
		System.out.println("Lanzo los trenes");

		for (int i = 0; i < NUM_TRENES; i++) {
			a_tren[i] = new Tren(i);
			a_tren[i].start();
		}

	}

}

