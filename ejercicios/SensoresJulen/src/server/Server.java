    package server;

    import java.io.IOException;
    import java.io.OutputStream;
    import java.io.PrintWriter;
    import java.net.InetSocketAddress;
    import java.net.ServerSocket;
    import java.net.Socket;

    public class Server {

        public static void main(String[] ags){
        OutputStream os;
        PrintWriter fsalida;

            try {
            ServerSocket serverSocket = new ServerSocket();
            Socket[] sockets=new Socket[3];
            Hilos[] hilos = new Hilos[3];
            InetSocketAddress addr = new InetSocketAddress("192.168.34.161",5557);
            serverSocket.bind(addr);

            for(int i=0;i<3;i++){
                Socket newSocket = serverSocket.accept();
                sockets[i]=newSocket;
                hilos [i] = new Hilos(newSocket,i++);
                hilos[i].start();
            }

            for(int i=0;i<3;i++){
                hilos[i].join();
            }

        } catch (
        IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
