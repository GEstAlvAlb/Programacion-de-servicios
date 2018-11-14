import java.util.*;

public class random{ 
  public static void main(String args[]){
    int [] array = new int[10];
    Random rand = new Random();

    
    
    for(int i=0; i<10;i++){
        
       array[i]=rand.nextInt(25);
       array[i]*=-1;
       System.out.println(array[i]);
    }
    System.out.println();
    
    
    for(int i=0; i<10;i++){
      
         array[i]=rand.nextInt(100);
         while(array[i]<=60){

                array[i]=rand.nextInt(100);
                
         }
       
          System.out.println(array[i]);
    }
}  
}
