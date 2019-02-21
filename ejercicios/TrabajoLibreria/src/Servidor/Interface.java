package Servidor;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Interface extends Remote {

	public String hoja() throws RemoteException, IOException;
	
	public void salir()throws RemoteException;
	public boolean conectar(String nombre, String contraseña)throws RemoteException;
	
}
