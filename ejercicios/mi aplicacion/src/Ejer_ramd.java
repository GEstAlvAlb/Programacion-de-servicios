import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.*;
import java.util.Arrays;

public class Ejer_ramd {
	static int naleatorios = 6;

	public static void main(String args[])throws IOException,InterruptedException{
		int i;
		Process[] p = new Process[naleatorios]; //Array	de procesos
		InputStream is []= 	new InputStream[naleatorios];
		InputStreamReader isr []=new InputStreamReader[naleatorios];
		BufferedReader br [] = new 	BufferedReader[naleatorios];
		
		for(i=0;i<naleatorios;i++) {
			p[i]= new ProcessBuilder("C:\\Users\\Alumnot\\Desktop\\programacion_de_servicios\\ejercicios\\bat_y_otros\\aleatorio.exe").start();
			is[i]= p[i].getInputStream();
			isr[i]= new InputStreamReader(is[i]);
			br[i] = new BufferedReader(isr[i]);  
			}
		for(i=0;i<naleatorios;i++) {
			p[i].waitFor();      
			}
		
		String line;
		for(i=0;i<naleatorios;i	++){
			System.out.println("Salida del proceso Aleatorio "+ i +":");
			while ((line=br[i].	readLine())!=null) {
				System.out.println(line); 
			} 
		}
	}
}