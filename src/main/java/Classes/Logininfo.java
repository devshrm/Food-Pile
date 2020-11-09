package Classes;

import java.io.Serializable;

public class Logininfo implements Serializable {

    private String username;
    private String password;

    public Logininfo(String username, String password) {
        this.password = password;
        this.username = username;

    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
