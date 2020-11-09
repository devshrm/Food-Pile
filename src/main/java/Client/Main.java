package Client;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Client c1 = new Client();
        new Login_user(c1).setVisible(true);
    }
}
