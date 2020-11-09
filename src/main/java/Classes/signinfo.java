package Classes;

import java.io.Serializable;

public class signinfo implements Serializable {

    private String username;
    private String password;
    private String name;

    public signinfo(String name, String username, String password) {
        this.password = password;
        this.name = name;
        this.username = username;

    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
}
