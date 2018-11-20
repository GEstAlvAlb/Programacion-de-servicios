package Trenes;
import java.util.concurrent.Semaphore;

import javax.swing.JFrame;

public class Linea extends JFrame {

	private static Tren a_tren[];	
	private static final int NUM_TREN=3;
	private static final int NUM_ESTACIONES=4;
	

	public static void main (String[] args) {
		
		Linea  f=new Linea();
		f.setSize(400,400);
		f.setVisible(true);
		Ventana p=new Ventana("/fotos/via.gif");
		f.add(p);
		
		a_tren=new Tren[NUM_TREN];
		System.out.println("Lanzo los trenes");
		
		for (int i=0;i<NUM_TREN;i++) {
			a_tren[i]=new Tren(i+1,NUM_ESTACIONES,p);
			a_tren[i].start();
		}
		
		
	}
	
	
	
	
}
