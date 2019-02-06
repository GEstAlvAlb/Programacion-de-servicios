package Servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import Objeto.Objeto;

public class ClienteHilo extends Thread {

	Socket socket;
	Objeto objeto = new Objeto();

	ClienteHilo(Socket socket) {

		this.socket = socket;
	}

	public void run() {
		try {
			BufferedReader fEntrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter fSalida = new PrintWriter(socket.getOutputStream(), true);

			ObjectInputStream objEntrada = new ObjectInputStream(socket.getInputStream());

			objeto = (Objeto) objEntrada.readObject();

			switch (objeto.getSimbolo()) {
			case "+":
				objeto.setResultado(objeto.getNum1() + objeto.getNum2());
				break;
			case "-":

				objeto.setResultado(objeto.getNum1() - objeto.getNum2());
				break;
			case "*":
				objeto.setResultado(objeto.getNum1() * objeto.getNum2());

				break;
			case "/":
				objeto.setResultado(objeto.getNum1() / objeto.getNum2());

				break;

			default:
				break;
			}

			ObjectOutputStream objSalida = new ObjectOutputStream(socket.getOutputStream());
			objSalida.writeObject(objeto);
			
			
			fEntrada.close();
			fSalida.close();
			objEntrada.close();
			objSalida.close();
			socket.close();
		

		} catch (NumberFormatException | IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
