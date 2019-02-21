package Cliente;

import java.io.IOException;
import java.net.Socket;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import Servidor.Interface;

public class Cliente {

	String nombre;
	String contraseña;
	
	static Interface inter;
	static Registry registry;
	public Cliente() {
		
		
		
	}
	
	
	public static void main (String[]args) {
		try {
			registry=LocateRegistry.getRegistry("localhost", 8888);
			inter = (Interface) registry.lookup("Interface");
			
			
			if(inter.conectar("asd","1234")){
				System.out.println(inter.hoja());
			}
			else {
				System.out.println("me salgo");
				return;
			}
			
		} catch (RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
