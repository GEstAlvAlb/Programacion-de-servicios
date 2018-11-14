package hilos;
import java.io.*;
import java.util.*;

class NewThread implements Runnable{
	String name; // nombre del hilo
	Thread t;
	NewThread(String threadname){
		name=threadname;
		t=new Thread(this, name);
		System.out.println("nuevo hilo: "+ t);
		t.start();//comienzo del hilo
	}
	
	public void run(){
		try {
		for(int i=0;i<5;i++) {
				System.out.println("Hilo" + name +": "+ i);
		Thread.sleep(1000);
		}
	}catch(InterruptedException e) {
		System.out.println("interrupcion del hilo hijo" +name);
		
	}
		System.out.println("sale del hilo hijo "+ name);
}
}

public class hilos2 {
	public static void main (String[]arg) {
		new NewThread("uno");
		new NewThread("dos");
		new NewThread("tres");
		try {
			//esperar
			Thread.sleep(10000);
		}catch(InterruptedException e) {
			System.out.println("interrupcion");
			
		}
		System.out.println("sale del programa principal");
		
		
	}
}
