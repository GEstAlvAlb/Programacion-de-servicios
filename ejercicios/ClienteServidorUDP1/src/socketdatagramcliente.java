//Envía un mensaje al Proceso servidor que lo espera

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;


public class socketdatagramcliente {
	public static void main(String[] args) {
		try {
			System.out.println("Creando socket datagram");
			DatagramSocket datagramSocket = new DatagramSocket();
			System.out.println("Enviando mensaje");
			String mensaje = "Hola";
			InetAddress addr = InetAddress.getByName("192.168.34.34"); //ip del servidor ip de ivan
			DatagramPacket datagrama = new DatagramPacket(mensaje.getBytes(), mensaje.getBytes().length, addr, 5555);
			datagramSocket.send(datagrama);
			System.out.println("Mensaje enviado");
			System.out.println("Cerrando el socket datagrama");
			datagramSocket.close();
			System.out.println("Terminado");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}