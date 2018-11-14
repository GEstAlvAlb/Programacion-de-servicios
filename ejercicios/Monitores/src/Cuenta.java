public class Cuenta {
	private int saldo;

	Cuenta(int s){
		saldo=s;//inicializar el saldo actual
	}
	int getsaldo() {
		return saldo;
	}

	void restar(int cantidad) {// se resta la cantidad del saldo
		saldo = saldo - cantidad;

	}

	synchronized void Retirardinero(int cant, String nom) {
		if(getsaldo()>cant) {
			System.out.println("Saldo acutual " +getsaldo());
			try {
				Thread.sleep(500);;
			}catch(InterruptedException ex) {
				
			}
			restar(cant);
			System.out.println(nom+" retira "+cant+" (Actual "+getsaldo()+")");
		}else {
			System.out.println(nom+" sin saldo suficiente " +getsaldo());
			
		}
		if(getsaldo()<0) {
			System.out.println("Saldo negativo" +getsaldo()); //retira el saldo de la cuenta
			
		}

	}

}
