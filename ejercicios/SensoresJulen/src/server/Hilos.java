package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Hilos extends Thread{
    BufferedReader fentrada;
    InputStream is;
    Socket newSocket;
    int sensor;

    public Hilos(Socket newSocket, int sensor) {
        try {
            this.newSocket=newSocket;
            this.sensor=sensor;
            is = newSocket.getInputStream();
            fentrada = new BufferedReader(new InputStreamReader(is));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void run(){
        try {
            int numeroMayor=0,numeroMenor=0,media=0;
            for (int i=0; i<10; i++) {
                int numero = Integer.parseInt(fentrada.readLine());
                if (i==0){
                    numeroMayor=numero;
                    numeroMenor=numero;
                }
                if (numero<numeroMenor)
                    numeroMenor=numero;
                if(numero>numeroMayor)
                    numeroMayor=numero;
                media+=numero;
            }
            media=media/10;
            System.out.println("La temperatura maxima del "+sensor+" ha sido: "+numeroMayor);
            System.out.println("La temperatura minima del "+sensor+" ha sido "+numeroMenor);
            System.out.println("La media de todas las temperaturtas del "+sensor+" ha sido "+media);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
