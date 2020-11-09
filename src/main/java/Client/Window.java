package Client;

import Classes.Productinfo;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.*;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Window extends javax.swing.JFrame {

    Client c1;

    public Window(Client c1) {
        this.c1 = c1;
        initComponents();
        tabb();

    }

    public void tabb() {
        try {

            ObjectOutputStream out = new ObjectOutputStream(c1.socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(c1.socket.getInputStream());
            out.writeInt(3);
            out.flush();
            DefaultTableModel d = (DefaultTableModel) table1.getModel();
            d.setRowCount(0);
            int cpp = 0;
            Vector<Productinfo> productinfo = (Vector<Productinfo>) in.readObject();
            while (cpp < productinfo.size()) {

                Vector v = new Vector();
                v.add(productinfo.get(cpp).name);
                v.add(productinfo.get(cpp).category);
                v.add(productinfo.get(cpp).price);
                v.add(productinfo.get(cpp).qty);
                d.addRow(v);

                cpp++;

            }
            table1.setModel(d);
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        addbtn = new javax.swing.JButton();
        editbtn = new javax.swing.JButton();
        removebtn = new javax.swing.JButton();
        searchbtn = new javax.swing.JButton();
        sortbtn = new javax.swing.JButton();
        signout = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setLocation(new java.awt.Point(190, 100));
        setPreferredSize(new java.awt.Dimension(1089, 640));

        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Category", "Price", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table1.setAutoCreateRowSorter(true);
        jScrollPane1.setViewportView(table1);

        addbtn.setBackground(new java.awt.Color(255, 255, 255));
        addbtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        addbtn.setText("Add an item");
        addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtnActionPerformed(evt);
            }
        });

        editbtn.setBackground(new java.awt.Color(255, 255, 255));
        editbtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        editbtn.setText("Edit");
        editbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editbtnActionPerformed(evt);
            }
        });

        removebtn.setBackground(new java.awt.Color(255, 255, 255));
        removebtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        removebtn.setText("Remove");
        removebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removebtnActionPerformed(evt);
            }
        });

        searchbtn.setBackground(new java.awt.Color(204, 204, 204));
        searchbtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        searchbtn.setText("Search");
        searchbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        searchbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchbtnActionPerformed(evt);
            }
        });

        sortbtn.setBackground(new java.awt.Color(204, 204, 204));
        sortbtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sortbtn.setText("Sort");
        sortbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        sortbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sortbtnActionPerformed(evt);
            }
        });

        signout.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        signout.setText("Sign out");
        signout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signoutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(searchbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sortbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(addbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
                    .addComponent(editbtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(removebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(signout)
                .addGap(35, 35, 35))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(134, 134, 134)
                .addComponent(addbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(editbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(removebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchbtn)
                    .addComponent(sortbtn))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(signout)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtnActionPerformed
        new additem(c1).setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_addbtnActionPerformed

    private void removebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removebtnActionPerformed
        DefaultTableModel d2 = (DefaultTableModel) table1.getModel();
        int idx = table1.getSelectedRow();
        if (idx >= 0) {

            try {
                ObjectOutputStream out = new ObjectOutputStream(c1.socket.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(c1.socket.getInputStream());
                String nm = (String) d2.getValueAt(idx, 0);
                String cat = (String) d2.getValueAt(idx, 1);
                int price = Integer.parseInt(d2.getValueAt(idx, 2).toString());
                int qty = Integer.parseInt(d2.getValueAt(idx, 3).toString());
                out.writeInt(4);
                out.flush();
                out.writeUTF(nm);
                out.flush();
                tabb();
            } catch (IOException ex) {
                ex.printStackTrace();
                return;
            }

        } else {
            new removeitem(c1).setVisible(true);
            setVisible(false);
        }
    }//GEN-LAST:event_removebtnActionPerformed
    public String editname;
    public String editcat;
    public int editprice;
    public int editqty;

    public String geteditname() {
        return editname;
    }

    public String geteditcat() {
        return editcat;
    }

    public int geteditprice() {
        return editprice;
    }

    public int geteditqty() {
        return editqty;
    }

    private void editbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editbtnActionPerformed
        DefaultTableModel d3 = (DefaultTableModel) table1.getModel();
        int idx = table1.getSelectedRow();
        if (idx == -1) {
            JOptionPane.showMessageDialog(null, "Select the item you want to edit");
        } else {

            editname = (String) d3.getValueAt(idx, 0);
            editcat = (String) d3.getValueAt(idx, 1);
            editprice = Integer.parseInt(d3.getValueAt(idx, 2).toString());
            editqty = Integer.parseInt(d3.getValueAt(idx, 3).toString());
            new edititem(c1, editname, editcat, editprice, editqty).setVisible(true);
            setVisible(false);
        }
    }//GEN-LAST:event_editbtnActionPerformed


    private void sortbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sortbtnActionPerformed
        new sortitem(c1).setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_sortbtnActionPerformed


    private void searchbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchbtnActionPerformed
        new searchitem(c1).setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_searchbtnActionPerformed


    private void signoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signoutActionPerformed
        new Login_user(c1).setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_signoutActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbtn;
    private javax.swing.JButton editbtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton removebtn;
    private javax.swing.JButton searchbtn;
    private javax.swing.JButton signout;
    private javax.swing.JButton sortbtn;
    public javax.swing.JTable table1;
    // End of variables declaration//GEN-END:variables
}
