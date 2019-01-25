import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class cliente {

	public static void main(String[] args) throws IOException {
		String Host = "localhost";
		int Puerto = 6000; // Puerto remote
		
		try {
			Socket Cliente = new Socket(Host, Puerto);
			// Crear Flujo de Salida al Servidor
			PrintWriter fsalida = new PrintWriter(Cliente.getOutputStream(), true);
			// Crear Flujo de Entrada al Servidor
			BufferedReader fentrada = new BufferedReader(new InputStreamReader(Cliente.getInputStream()));
			// Flujo para Entada estandar
			BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
			String cadena, eco = "";
			
			System.out.print("Introduce cadena; ");
			
			cadena = in.readLine(); // lectura por teclado
			
			while (!cadena.equals("*")) {
				fsalida.println(cadena); // envio de la cadena al servidor
				eco = fentrada.readLine(); // recibir la cadena del servidor
				System.out.println(" =>ECO; " + eco);
				System.out.print("Introduce cadena; ");
				cadena = in.readLine(); // lectura por teclado
			}
			
			fsalida.close();
			fentrada.close();
			System.out.println("Fin del envio…");
			in.close();
			Cliente.close();
		}catch(NullPointerException e){
			System.out.println("Conexion finalizada con el servidor");
		}
	}
}