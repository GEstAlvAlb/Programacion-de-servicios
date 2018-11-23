package Trenes;
import java.util.concurrent.Semaphore;

public class Constantes {
	
	public static Semaphore estacion1=new Semaphore(1);
	public static Semaphore estacion2=new Semaphore(1);
	public static Semaphore estacion3=new Semaphore(1);
	public static Semaphore estacion4=new Semaphore(1);
	public static Semaphore estacion5=new Semaphore(1);
	public static Semaphore estacion6=new Semaphore(1);
	public static Semaphore estacion7=new Semaphore(1);
	
	public static final int NUM_ESTACIONES= 6;
	public static final int NUM_TRENES = 2;
	public static final int NUM_VUELTAS=3;
	
	
}
