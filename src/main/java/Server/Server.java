package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String args[]) {
        ServerSocket serverSocket;
        Socket soc;
        System.out.println("Server started");
        try {
            serverSocket = new ServerSocket(5000);
        } catch (IOException e) {
            return;
        }
        while (true) {
            try {
                soc = serverSocket.accept();
                Thread t = new Thread(new HandleClient(soc));
                t.start();
            } catch (IOException e) {
                return;
            }

        }
    }

}
