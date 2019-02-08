package Servidor;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Servidor implements Interfaz {

	public int suma(int a, int b) throws RemoteException {
		return (a + b);
	}

	public int resta(int a, int b) throws RemoteException {
		return (a - b);
	}

	public int multip(int a, int b) throws RemoteException {
		return (a * b);
	}

	public int div(int a, int b) throws RemoteException {
		return (a / b);

	}

	public static void main(String[] args) {
		System.out.println("Creando el registro de objetos remotos...");
		Registry reg = null;
		try {
			reg = LocateRegistry.createRegistry(5555);
			// Puerto de ref. del objeto java
		} catch (Exception e) {
			System.out.println("ERROR: No se ha podido crear el registro");
			e.printStackTrace();
		}
		System.out.println("Creando el objeto servidor e inscribiendolo en el registro...");
		Servidor serverObject = new Servidor();
		try {
			reg.rebind("Calculadora", (Interfaz) UnicastRemoteObject.exportObject(serverObject, 0));
		} catch (Exception e) {
			System.out.println("ERROR: No se ha podido inscribir el objeto servidor.");
			e.printStackTrace();
		}
	}
}