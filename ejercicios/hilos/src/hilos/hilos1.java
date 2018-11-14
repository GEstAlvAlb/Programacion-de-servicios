package hilos;
import java.io.*;
import java.util.*;

class HilosS extends Thread{
	public void run(){
		for(int i=0;i<5;i++)
				System.out.println("en el hilo...");
	}
}

public class hilos1 {
	public static void main (String[]arg) {
		HilosS hs=new HilosS();
		hs.start();
		for(int i=0;i<5;i++);
		System.out.println("Fuera del hilo");
		
		
	}
}