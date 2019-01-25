import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		
		String host = "localhost";
		int puerto = 6660;
			
			Random r = new Random();
			Socket cliente;
			try {
				Scanner teclado = new Scanner(System.in,"UTF-8");
				cliente = new Socket(host,puerto);
				PrintWriter fsalida = new PrintWriter(cliente.getOutputStream(), true);
				
				BufferedReader fentrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
				BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
				String cadena = "";
				
				fsalida.println(teclado.nextLine());
				fsalida.close();
				fentrada.close();
				System.out.println("Fin de envio");
				in.close();
				cliente.close();
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
