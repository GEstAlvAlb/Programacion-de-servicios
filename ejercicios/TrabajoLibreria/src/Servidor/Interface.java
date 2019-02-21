package Servidor;

import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Interface extends Remote {

	public List<String> hoja(String nomLibro, int pag) throws RemoteException, IOException;
	
	public void salir()throws RemoteException;
	public boolean conectar(String nombre, String contraseņa)throws RemoteException;

	

	

	
	
}
