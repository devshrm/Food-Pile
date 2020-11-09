package Client;

import java.io.IOException;

import java.net.Socket;

public class Client {

    public Socket socket;

    public Client() throws IOException {
        socket = new Socket("localhost", 5000);

    }

}
