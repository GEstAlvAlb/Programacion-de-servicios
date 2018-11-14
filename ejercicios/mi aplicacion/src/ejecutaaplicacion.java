public class ejecutaaplicacion{
	public static void main(String[] arg) {
		Runtime r=Runtime.getRuntime(); // creas un proceso que se llame a si mismo
		String comando="NOTEPAD";
		String comando2="C:\\Program Files (x86)\\Google\\Chrome\\Application\\CHROME";
		Process p; // proceso p que nombra otro proceso
		Process p2;// segudno proceso
		
		try{
			p=r.exec(comando); // esto hace que se ejecute el comando
			p2=r.exec(comando2);
			
			p.waitFor(); //esto hace que el proceso padre no finaliza hasta que termine el proceso p
			p2.waitFor(); //esto hace que el proceso padre no finaliza hasta que termine el proceso p2
		}
		catch (Exception e) {
			System.out.println("errpr en :" + comando);
			e.printStackTrace();
			
		}
		//System.out.println("Soy el padre voy a finalizar");
		
		
		
	}
	
	
	
	

}