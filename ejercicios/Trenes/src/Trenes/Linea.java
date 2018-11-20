package Trenes;
import javax.swing.JFrame;

public class Linea extends JFrame {

	private static Tren a_tren[];	
	private static final int NUM_TREN=6;
	private static final int NUM_ESTACIONES=4;
	

	public static void main (String[] args) {
		
	
		
		a_tren=new Tren[NUM_TREN];
		System.out.println("Lanzo los trenes");
		
		for (int i=0;i<NUM_TREN;i++) {
			a_tren[i]=new Tren(i+1,NUM_ESTACIONES);
			a_tren[i].start();
		}
		
	}
	
	
	
	
}
