package Server;

import Classes.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class HandleClient implements Runnable {

    private Socket socket;

    Conn con = new Conn();

    public HandleClient(Socket socket) throws IOException {
        this.socket = socket;

    }

    @Override
    public void run() {
        while (true) {
            try {

                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                int a = -1;

                a = in.readInt();
                //System.out.println(a);

                if (a == 1) {

                    String sql = "select * from account where username=? and password=?";
                    PreparedStatement st = con.c.prepareStatement(sql);
                    Logininfo log2 = (Logininfo) in.readObject();
                    String b = log2.getUsername();
                    String c = log2.getPassword();

                   
                    st.setString(1, b);
                    st.setString(2, b);

                    ResultSet rs = st.executeQuery();
                    int k = 0;
                    while (rs.next()) {
                        k = 1;

                    }

                    if (k == 0) {
                        out.writeInt(0);
                        out.flush();
                    } else {
                        out.writeInt(1);
                        out.flush();
                    }

                } else if (a == 2) {

                    String sql = "insert into account(username, name, password)" + " values(?, ?, ?)";
                    PreparedStatement st = con.c.prepareStatement(sql);
                    signinfo s2 = (signinfo) in.readObject();
                    String b = s2.getName();
                    String c = s2.getUsername();
                    String d = s2.getPassword();

                    st.setString(1, b);
                    st.setString(2, c);
                    st.setString(3, c);
                    int i = st.executeUpdate();

                } else if (a == 3) {

                    PreparedStatement s;
                    s = con.c.prepareStatement("Select * from Inventory");
                    ResultSet rs2 = s.executeQuery();

                    Vector<Productinfo> v = new Vector<Productinfo>();
                    while (rs2.next()) {

                        String tab1 = rs2.getString(1);
                        String tab2 = rs2.getString(2);
                        int tab3 = rs2.getInt(3);
                        int tab4 = rs2.getInt(4);
                        Productinfo productinfo = new Productinfo(tab1, tab2, tab3, tab4);
                        v.add(productinfo);

                    }
                    out.writeObject(v);
                    out.flush();

                } else if (a == 4) {
                    PreparedStatement s;
                    String name = in.readUTF();
                    s = con.c.prepareStatement("Delete from Inventory where name = ?");
                    s.setString(1, name);
                    s.executeUpdate();

                } else if (a == 5) {
                    PreparedStatement pst2;
                    pst2 = con.c.prepareStatement("Insert into Inventory values(?,?,?,?,?)");
                    Additem add = (Additem) in.readObject();
                    pst2.setString(1, add.getName());
                    pst2.setString(2, add.getCategory());
                    pst2.setInt(3, add.getPrice());
                    pst2.setInt(4, add.getQuantity());
                    pst2.setInt(5, add.getThreshold());

                    pst2.executeUpdate();
                } else if (a == 6) {

                    String name = (String) in.readUTF();
                    Productinfo product = (Productinfo) in.readObject();
                    PreparedStatement pst10, pst5;
                    pst10 = con.c.prepareStatement("Select *  from inventory where name  = ?");
                    pst10.setString(1, name);
                    ResultSet rs5 = pst10.executeQuery();
                    rs5.next();
                    int val = rs5.getInt("threshold");
                    out.writeInt(val);
                    out.flush();
                    int cc = in.readInt();
                    if (cc == 1) {
                        pst5 = con.c.prepareStatement("update Inventory set name = ?, category = ?, price = ?, quantity = ? where name = ?");
                        pst5.setString(1, product.getName());
                        pst5.setString(2, product.getCategory());
                        pst5.setInt(3, product.getPrice());
                        pst5.setInt(4, product.getQuantity());
                        pst5.setString(5, name);
                        pst5.executeUpdate();

                    }
                    out.flush();

                } else if (a == 7) {
                    String a2 = (String) in.readUTF();
                    String b = (String) in.readUTF();
                    PreparedStatement pst7;
                    if (a2.equals("") && b.equals("")) {
                        out.writeInt(0);
                        out.flush();

                    } else if (!(a2.equals(""))) {
                        pst7 = con.c.prepareStatement("Delete from Inventory WHERE name = ?");
                        pst7.setString(1, a2);
                        pst7.executeUpdate();
                        out.writeInt(1);
                        out.flush();

                    } else {

                        pst7 = con.c.prepareStatement("Delete from Inventory WHERE category = ?");
                        pst7.setString(1, b);
                        pst7.executeUpdate();
                        out.writeInt(1);
                        out.flush();
                    }

                } else if (a == 8) {
                    int val = (int) in.readInt();
                    if (val == 1) {
                        PreparedStatement s;
                        String a2 = (String) in.readUTF();
                        s = con.c.prepareStatement("Select * from Inventory where category = ?");
                        s.setString(1, a2);
                        ResultSet rs2 = s.executeQuery();

                        Vector<Productinfo> v = new Vector<Productinfo>();
                        while (rs2.next()) {

                            String tab1 = rs2.getString(1);
                            String tab2 = rs2.getString(2);
                            int tab3 = rs2.getInt(3);
                            int tab4 = rs2.getInt(4);
                            Productinfo productinfo = new Productinfo(tab1, tab2, tab3, tab4);
                            v.add(productinfo);

                        }

                        out.writeObject(v);
                        out.flush();
                    } else if (val == 2) {
                        PreparedStatement s;
                        String a2 = (String) in.readUTF();
                        s = con.c.prepareStatement("Select * from Inventory where name = ?");
                        s.setString(1, a2);
                        ResultSet rs2 = s.executeQuery();

                        Vector<Productinfo> v = new Vector<Productinfo>();
                        while (rs2.next()) {

                            String tab1 = rs2.getString(1);
                            String tab2 = rs2.getString(2);
                            int tab3 = rs2.getInt(3);
                            int tab4 = rs2.getInt(4);
                            Productinfo productinfo = new Productinfo(tab1, tab2, tab3, tab4);
                            v.add(productinfo);

                        }

                        out.writeObject(v);
                        out.flush();
                    } else if (val == 3) {
                        PreparedStatement s;
                        String a2 = (String) in.readUTF();
                        String a3 = (String) in.readUTF();
                        s = con.c.prepareStatement("Select * from Inventory where name = ? and category = ?");
                        s.setString(1, a2);
                        s.setString(2, a3);
                        ResultSet rs2 = s.executeQuery();
                        Vector<Productinfo> v = new Vector<Productinfo>();
                        while (rs2.next()) {

                            String tab1 = rs2.getString(1);
                            String tab2 = rs2.getString(2);
                            int tab3 = rs2.getInt(3);
                            int tab4 = rs2.getInt(4);
                            Productinfo productinfo = new Productinfo(tab1, tab2, tab3, tab4);
                            v.add(productinfo);

                        }

                        out.writeObject(v);
                        out.flush();
                    }
                    out.flush();
                } else if (a == 9) {
                    PreparedStatement s;
                    s = con.c.prepareStatement("Select * from Inventory");
                    ResultSet rs2 = s.executeQuery();

                    Vector<Productinfo> v = new Vector<Productinfo>();
                    while (rs2.next()) {

                        String tab1 = rs2.getString(1);
                        String tab2 = rs2.getString(2);
                        int tab3 = rs2.getInt(3);
                        int tab4 = rs2.getInt(4);
                        Productinfo productinfo = new Productinfo(tab1, tab2, tab3, tab4);
                        v.add(productinfo);

                    }
                    out.writeObject(v);
                    out.flush();
                }

            } catch (IOException | SQLException | ClassNotFoundException ex) {
                ex.printStackTrace();
                return;

            }
        }
    }
}
