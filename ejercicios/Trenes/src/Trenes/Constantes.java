package Trenes;
import java.util.concurrent.Semaphore;

public class Constantes {
	public static Semaphore estacion1=new Semaphore(1);
	public static Semaphore estacion2=new Semaphore(1);
	public static Semaphore estacion3=new Semaphore(1);
	public static Semaphore estacion4=new Semaphore(1);
	
	public static int NUM_ESTACIONES= 4;
	public static int NUM_TRENES = 1;
	
	
}
