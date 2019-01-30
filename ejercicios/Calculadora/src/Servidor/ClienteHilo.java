package Servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClienteHilo extends Thread {
	int num1, num2;
	String simbolo;
	int total;
	Socket socket;

	ClienteHilo(Socket socket) {

		this.socket = socket;
	}

	public void run() {
		try {
			BufferedReader fEntrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter fSalida = new PrintWriter(socket.getOutputStream(), true);
			num1 = Integer.parseInt(fEntrada.readLine());
			simbolo = fEntrada.readLine();
			num2 = Integer.parseInt(fEntrada.readLine());
			switch (simbolo) {
			case "+":
				total=num2+num1;
				break;
			case "-":
				
				total=num1-num2;
				break;
			case "*":
				total=num1*num2;

				break;
			case "/":
				total=num1/num2;

				break;

			default:
				break;
			}
			
			fSalida.println(String.valueOf(total));
			
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
