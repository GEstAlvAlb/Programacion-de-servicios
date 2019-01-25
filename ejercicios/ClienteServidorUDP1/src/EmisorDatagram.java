import java.io.*;
import java.net.*;


public class EmisorDatagram {
	public static void main(String[] args) {
		try {
			DatagramSocket datagramSocket = new DatagramSocket();
			String mensaje = "mensaje desde el emisor";
			InetAddress addr = InetAddress.getByName("localhost");
			DatagramPacket datagrama = new DatagramPacket(mensaje.getBytes(), mensaje.getBytes().length, addr, 5555);
			datagramSocket.send(datagrama);
			datagramSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}