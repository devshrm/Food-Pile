package Client;

import Classes.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Login_user extends JFrame implements ActionListener {

    private JPanel panel;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton b1, b2;
    Client c1;

    public Login_user(Client c1) {
        this.c1 = c1;
        setBackground(new Color(169, 169, 169));
        setBounds(600, 300, 600, 400);

        panel = new JPanel();
        panel.setBackground(new Color(176, 224, 230));
        setContentPane(panel);
        panel.setLayout(null);

        JLabel l1 = new JLabel("Username : ");
        l1.setBounds(124, 89, 95, 24);
        panel.add(l1);

        JLabel l2 = new JLabel("Password : ");
        l2.setBounds(124, 124, 95, 24);
        panel.add(l2);

        textField = new JTextField();
        textField.setBounds(210, 93, 157, 20);
        panel.add(textField);

        passwordField = new JPasswordField();
        passwordField.setBounds(210, 128, 157, 20);
        panel.add(passwordField);

        JLabel l3 = new JLabel("");
        l3.setBounds(377, 79, 46, 34);
        panel.add(l3);

        JLabel l4 = new JLabel("");
        l4.setBounds(377, 124, 46, 34);
        panel.add(l3);

        b1 = new JButton("Login");
        b1.addActionListener(this);

        b1.setForeground(new Color(46, 139, 87));
        b1.setBackground(new Color(250, 250, 210));
        b1.setBounds(149, 181, 113, 39);
        panel.add(b1);
        b1.setOpaque(true);
        b1.setBorderPainted(false);

        b2 = new JButton("Sign up");
        b2.addActionListener(this);

        b2.setForeground(new Color(139, 69, 19));
        b2.setBackground(new Color(255, 235, 205));
        b2.setBounds(289, 181, 113, 39);
        panel.add(b2);
        b2.setOpaque(true);
        b2.setBorderPainted(false);

        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(176, 224, 230));
        panel2.setBounds(24, 40, 434, 263);
        panel.add(panel2);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == b1) {
            String a = textField.getText();
            String password = passwordField.getText();
            Logininfo log = new Logininfo(a, password);

            try {

                try {
                    ObjectOutputStream out = new ObjectOutputStream(c1.socket.getOutputStream());
                    out.writeInt(1);
                    out.writeObject(log);
                    out.flush();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ObjectInputStream in = new ObjectInputStream(c1.socket.getInputStream());
                int input = in.readInt();
                System.out.println(input);
                if (input == 1) {
                    this.setVisible(false);
                    new Window(c1).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Login");
                }

            } catch (HeadlessException | IOException e2) {
                e2.printStackTrace();
                return;
            }
        }
        if (ae.getSource() == b2) {
            setVisible(false);
            Signup su = new Signup(c1);
            su.setVisible(true);
        }

    }

    // public static void main(String[] args) {new Login_user().setVisible(true);}
}
