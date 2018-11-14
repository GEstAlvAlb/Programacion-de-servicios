
import java.awt.TextArea;

import java.util.Random;

import javax.swing.*;
;

class ventanas {
	private JFrame ventana = new JFrame();
	private TextArea texto_ventana = new TextArea();
	static int locaX=0;
	ventanas(String nombre) {
		
		ventana.setName(nombre);
		ventana.setTitle(nombre);
		ventana.setSize(400, 400);
		ventana.setLocation(locaX,0);
		locaX=locaX+450;
		ventana.setVisible(true);
		ventana.add(texto_ventana);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void escribecadena(String cadena) {

		texto_ventana.setText(texto_ventana.getText() + cadena);
	}
}

class Operaciones {
	public int disCorre[]= {0,0,0,0,0};
	
	public int apos[]={0,0,0,0,0}; //aray para almacenar el orden de llegada
	public int pos;	//variable para saber en que posicion llegan

	Operaciones() {
		
		this.pos=0;
		
	}
}

class Operacionesenhilos extends Thread {
	private int numhilo;
	Operaciones r;
	private ventanas ventana_hilo;
	Random rand = new Random();
	
	Operacionesenhilos(int i, Operaciones resultados) {
		this.numhilo = i;
		this.r = resultados;
		ventana_hilo=new ventanas("Corredor"+numhilo);
	}

	public void run() {
		String cadena=new String();
			do{
				r.disCorre[numhilo] = r.disCorre[numhilo] + rand.nextInt(100); //distancia recprrida por el corredor
				cadena=("Soy el Corredor" + numhilo + " llevo " + r.disCorre[numhilo]+"metros \n");
				ventana_hilo.escribecadena(cadena);
				try{ 
					sleep(rand.nextInt(500)); //tiempo de espera aleatorio para darle mas tiempo de adelantamiento
					}catch(InterruptedException e) { System.out.println("Hilo Interrumpido.");} 		
			}while(r.disCorre[numhilo]<1000);
			System.out.println("Soy el Corredor" + numhilo + " y he acabado la carrera"); //muestra en el programa padre quien ha llegado antes
			r.pos=r.pos+1;
			r.apos[r.pos]=numhilo;
			
		
	}
}

public class ejer1Alberto {
	static int numhilos = 4;
	public Operaciones almacen_operaciones;
	private static Operacionesenhilos HiloOperaciones[];

	public static void main(String[] args) {
		Operaciones almacen_operaciones = new Operaciones();
		HiloOperaciones = new Operacionesenhilos[numhilos];
		for (int i = 0; i < numhilos; i++) {
			HiloOperaciones[i] = new Operacionesenhilos(i + 1, almacen_operaciones);
			HiloOperaciones[i].start();
		}
		System.out.println("Carrera empezada esperando resultados");
		try {
			for (int i = 0; i < numhilos; i++) {
				HiloOperaciones[i].join(); // todo add catch exception
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("El orden de llegada ha sido:");
		for(int i=1;i<=numhilos;i++) {
			
			System.out.println("corredor"+almacen_operaciones.apos[i]);
			
				
		}
	}
}