package Server;

import java.sql.*;

public class Conn {

    Connection c;
    Statement s;

    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/FoodPile", "devshrm", "3377");
            s = c.createStatement();
            System.out.println("Connected to db");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

}
