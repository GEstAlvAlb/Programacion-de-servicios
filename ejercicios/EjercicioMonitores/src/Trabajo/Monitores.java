package Trabajo;

public class Monitores {

	private static int cochesAparcados, camionesAparcados;
	
	public synchronized void mensajeCoche(int id) {
		System.out.println("El veiculo "+id+" esta esperando");
		System.out.println("Veiculo " +id+" aparcando");
		cochesAparcados++;
		System.out.println("Veiculos aparcados"+ cochesAparcados);
		
	}
}
