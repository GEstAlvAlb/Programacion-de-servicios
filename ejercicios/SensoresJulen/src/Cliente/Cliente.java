package Cliente;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Random;

public class Cliente {

    public static void main(String[] args) {
        try {
            Socket clienteSocket = new Socket();

            InetSocketAddress addr = new InetSocketAddress("192.168.34.161", 5557);
            clienteSocket.connect(addr);

            PrintWriter fsalida = new PrintWriter(clienteSocket.getOutputStream(),true);
            for(int i=0;i<10;i++)
                fsalida.println(new Random().nextInt(49+1-1));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
