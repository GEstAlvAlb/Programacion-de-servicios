package hilos;

public class crearHilos extends Thread  {
    crearHilos (String name)
    {
        super(name);
    }
    public void run()
    {
    	int tam=0;
    	if(this.getName().equalsIgnoreCase("hilo1")) {tam=125;}
    	if(this.getName().equalsIgnoreCase("hilo2")) {tam=240;}
    	if(this.getName().equalsIgnoreCase("hilo3")) {tam=375;}
    	System.out.println(tam);
        int j=0;
        int[]array= numeros();
        for(int i=tam;i<(125+tam);i++)
        {
            if(array[i]==3)
            {
                j++;
            }
        }
        System.out.println("En el "+this.getName()+" hay"+j);
        
    }
    public int []numeros() {
    	
        int[] numero=new int[501];
        for(int i=0;i<=500;i++)
            numero[i]=(int) (Math.random()*10+1);
    return numero;
    }
    
    public static void main(String args[]) {
        for(int i=0;i<=3;i++)
        new crearHilos("hilo"+i).start();
        
    }
}

