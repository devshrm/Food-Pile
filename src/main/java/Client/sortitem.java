package Client;

import Classes.Productinfo;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class sortitem extends javax.swing.JFrame {

    Client c1;

    public sortitem(Client c1) {
        this.c1 = c1;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        combo1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        asc = new javax.swing.JRadioButton();
        des = new javax.swing.JRadioButton();
        applybtn = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        sorttable = new javax.swing.JTable();
        backbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(190, 100));

        combo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Price", "Quantity" }));
        combo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Sort by");

        asc.setText("Smaller to Bigger");

        des.setText("Bigger to Smaller");
        des.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desActionPerformed(evt);
            }
        });

        applybtn.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        applybtn.setText("Apply");
        applybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applybtnActionPerformed(evt);
            }
        });

        sorttable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(sorttable);

        backbtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        backbtn.setText("←Back");
        backbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(combo1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(124, 124, 124)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(asc)
                                    .addComponent(des, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))))
                        .addGap(127, 127, 127))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addComponent(applybtn))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(backbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(backbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(combo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(21, 21, 21)
                .addComponent(asc)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(des)
                .addGap(26, 26, 26)
                .addComponent(applybtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(49, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void combo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo1ActionPerformed

    }//GEN-LAST:event_combo1ActionPerformed


    private void desActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desActionPerformed

    }//GEN-LAST:event_desActionPerformed

    private void applybtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applybtnActionPerformed
        try {
            ObjectOutputStream out = new ObjectOutputStream(c1.socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(c1.socket.getInputStream());
            out.writeInt(9);
            out.flush();
            int idx = combo1.getSelectedIndex();

            DefaultTableModel d7 = (DefaultTableModel) sorttable.getModel();
            d7.setRowCount(0);

            int cpp = 0;
            Vector<Productinfo> productinfo = (Vector<Productinfo>) in.readObject();
            while (cpp < productinfo.size()) {

                Vector v = new Vector();
                v.add(productinfo.get(cpp).name);
                v.add(productinfo.get(cpp).category);
                v.add(productinfo.get(cpp).price);
                v.add(productinfo.get(cpp).qty);
                System.out.println(productinfo.get(cpp).name);
                d7.addRow(v);

                cpp++;

            }

            if (idx == 0) {
                if (asc.isSelected()) {
                    TableRowSorter<TableModel> sorter = new TableRowSorter<>(sorttable.getModel());
                    sorttable.setRowSorter(sorter);
                    List<RowSorter.SortKey> sortKeys = new ArrayList<>();

                    int columnIndexToSort = 2;
                    sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));

                    sorter.setSortKeys(sortKeys);

                } else {
                    TableRowSorter<TableModel> sorter = new TableRowSorter<>(sorttable.getModel());
                    sorttable.setRowSorter(sorter);
                    List<RowSorter.SortKey> sortKeys = new ArrayList<>();

                    int columnIndexToSort = 2;
                    sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.DESCENDING));

                    sorter.setSortKeys(sortKeys);

                }
            } else {
                if (asc.isSelected()) {
                    TableRowSorter<TableModel> sorter = new TableRowSorter<>(sorttable.getModel());
                    sorttable.setRowSorter(sorter);
                    List<RowSorter.SortKey> sortKeys = new ArrayList<>();

                    int columnIndexToSort = 3;
                    sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.ASCENDING));

                    sorter.setSortKeys(sortKeys);

                } else {
                    TableRowSorter<TableModel> sorter = new TableRowSorter<>(sorttable.getModel());
                    sorttable.setRowSorter(sorter);
                    List<RowSorter.SortKey> sortKeys = new ArrayList<>();

                    int columnIndexToSort = 3;
                    sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.DESCENDING));

                    sorter.setSortKeys(sortKeys);

                }

            }

            sorttable.setModel(d7);
        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
            return;
        }
    }//GEN-LAST:event_applybtnActionPerformed

    private void backbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backbtnActionPerformed
        new Window(c1).setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_backbtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton applybtn;
    private javax.swing.JRadioButton asc;
    private javax.swing.JButton backbtn;
    private javax.swing.JComboBox<String> combo1;
    private javax.swing.JRadioButton des;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable sorttable;
    // End of variables declaration//GEN-END:variables
}
