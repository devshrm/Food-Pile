package Client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class removeitem extends javax.swing.JFrame {

    Client c1;

    public removeitem(Client c1) {
        this.c1 = c1;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        namermv = new javax.swing.JLabel();
        catrmv = new javax.swing.JLabel();
        nametxt = new javax.swing.JTextField();
        cattxt = new javax.swing.JTextField();
        rmvbtn = new javax.swing.JButton();
        cancelbtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(300, 180));

        namermv.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        namermv.setText("Name");

        catrmv.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        catrmv.setText("Category");

        nametxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nametxtActionPerformed(evt);
            }
        });

        rmvbtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        rmvbtn.setText("Remove");
        rmvbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rmvbtnActionPerformed(evt);
            }
        });

        cancelbtn.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        cancelbtn.setText("Cancel");
        cancelbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(143, 143, 143)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(namermv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(catrmv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nametxt, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                            .addComponent(cattxt)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(rmvbtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancelbtn)))
                .addContainerGap(177, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(namermv)
                        .addGap(18, 18, 18)
                        .addComponent(catrmv))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nametxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cattxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(53, 53, 53)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rmvbtn)
                    .addComponent(cancelbtn))
                .addContainerGap(114, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nametxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nametxtActionPerformed

    }//GEN-LAST:event_nametxtActionPerformed

    private void rmvbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rmvbtnActionPerformed

        try {
            ObjectOutputStream out = new ObjectOutputStream(c1.socket.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(c1.socket.getInputStream());
            out.writeInt(7);
            out.flush();
            String a = nametxt.getText();
            String b = cattxt.getText();
            out.writeUTF(a);
            out.flush();
            out.writeUTF(b);
            out.flush();
            int val = (int) in.readInt();
            if (val == 0) {
                JOptionPane.showMessageDialog(null, "Name and Category are required field");
            } else {
                JOptionPane.showMessageDialog(null, "Successful");

                setVisible(false);
                new Window(c1).setVisible(true);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
            return;
        }


    }//GEN-LAST:event_rmvbtnActionPerformed

    private void cancelbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelbtnActionPerformed
        new Window(c1).setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_cancelbtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelbtn;
    private javax.swing.JLabel catrmv;
    private javax.swing.JTextField cattxt;
    private javax.swing.JLabel namermv;
    private javax.swing.JTextField nametxt;
    private javax.swing.JButton rmvbtn;
    // End of variables declaration//GEN-END:variables
}
