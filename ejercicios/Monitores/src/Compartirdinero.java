
public class Compartirdinero {

	public static void main(String[] args) {
		Cuenta c=new Cuenta(10);
		Sacardinero h1=new Sacardinero("Pepe",c);
		Sacardinero h2 =new Sacardinero("Maria",c);
		h1.start();
		h2.start();
	}
}
