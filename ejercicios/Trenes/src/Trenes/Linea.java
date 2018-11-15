package Trenes;
import java.util.concurrent.Semaphore;

public class Linea {

	private static Tren a_tren[];	
	private static final int NUM_TREN=2;
	private static final int NUM_ESTACIONES=4;
	

	public static void main (String[] args) {
		
		a_tren=new Tren[NUM_TREN];
		System.out.println("Lanzo los trenes");
		
		for (int i=0;i<NUM_TREN;i++) {
			a_tren[i]=new Tren(i+1);
			a_tren[i].start();
		}
		
	}
	
	
	
	
}
