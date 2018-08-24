
import Connection.DbHandler;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

public class GPA extends javax.swing.JFrame {

    /**
     * Creates new form GPA
     */
    public GPA() {
        initComponents();
        this.setPreferredSize(new Dimension(900, 650));
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        GpaCurrentCredit.setText(Integer.toString(getTotalCredits()));
        CurGPA.setText(Double.toString(getCurrentGPA()));
    }

    // get the total credit
    public int getTotalCredits() {
        int rowsCount = jTableviewresults.getRowCount();
        int sum = 0;
        for (int i = 0; i < rowsCount; i++) {
            sum = sum + Integer.parseInt(jTableviewresults.getValueAt(i, 2).toString());
        }
        return sum;
    }

    public Double getCurrentGPA() {
        double totalcredit = getTotalCredits();
        double gpa = 0.00;
        double result = 0.00;
        String sub1gradecredit = null;
        int rowsCount = jTableviewresults.getRowCount();

        for (int i = 0; i < rowsCount; i++) {

            sub1gradecredit = jTableviewresults.getValueAt(i, 1).toString();
            double subcredit = Double.parseDouble(jTableviewresults.getValueAt(i, 2).toString());

            if (sub1gradecredit.equals("A")) {
                result = 4.000 * subcredit;
            } else if (sub1gradecredit.equals("A-")) {
                result = 3.670 * subcredit;
            } else if (sub1gradecredit.equals("B+")) {
                result = 3.330 * subcredit;
            } else if (sub1gradecredit.equals("B")) {
                result = 3.00 * subcredit;
            } else if (sub1gradecredit.equals("B-")) {
                result = 2.670 * subcredit;
            } else if (sub1gradecredit.equals("C+")) {
                result = 2.330 * subcredit;
            } else if (sub1gradecredit.equals("C")) {
                result = 2.000;
            } else if (sub1gradecredit.equals("C-")) {
                result = 1.6700 * subcredit;
            } else if (sub1gradecredit.equals("D+")) {
                result = 1.3300 * subcredit;
            } else if (sub1gradecredit.equals("D")) {
                result = 1.000 * subcredit;
            } else if (sub1gradecredit.equals("E")) {
                result = 0.00 * subcredit;
            }
            result += result;
            gpa = result / totalcredit;
        }

        return gpa;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableviewresults = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelHomeback = new javax.swing.JLabel();
        jButtonGpaStd = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        GpaSid = new javax.swing.JTextField();
        GpaCurrentCredit = new javax.swing.JTextField();
        jButtonTotalCredit = new javax.swing.JButton();
        CurGPA = new javax.swing.JTextField();
        jButtonCalGPA = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableviewresults.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Subject Code", "Grade", "Credits"
            }
        ));
        jScrollPane2.setViewportView(jTableviewresults);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 861, 408));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Current Gpa:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Current Credits:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabelHomeback.setBackground(new java.awt.Color(153, 153, 153));
        jLabelHomeback.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabelHomeback.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Back_Arrow_30px.png"))); // NOI18N
        jLabelHomeback.setText("Back");
        jLabelHomeback.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelHomeback.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelHomebackMouseClicked(evt);
            }
        });
        jPanel1.add(jLabelHomeback, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 77, -1));

        jButtonGpaStd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButtonGpaStd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8_Search_30px_1.png"))); // NOI18N
        jButtonGpaStd.setText("Search");
        jButtonGpaStd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGpaStdActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonGpaStd, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Student ID");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 85, -1, -1));

        GpaSid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GpaSidActionPerformed(evt);
            }
        });
        jPanel1.add(GpaSid, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 80, 220, -1));
        jPanel1.add(GpaCurrentCredit, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 220, -1));

        jButtonTotalCredit.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonTotalCredit.setText("Get Total Credits");
        jButtonTotalCredit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTotalCreditActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonTotalCredit, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 140, -1, -1));
        jPanel1.add(CurGPA, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 80, 160, -1));

        jButtonCalGPA.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButtonCalGPA.setText("Calculate GPA");
        jButtonCalGPA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCalGPAActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonCalGPA, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 140, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 932, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 629, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelHomebackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelHomebackMouseClicked

        Studentsmanage rfg2 = new Studentsmanage();
        rfg2.setVisible(true);
        rfg2.pack();
        rfg2.setLocationRelativeTo(null);
        rfg2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.dispose();
    }//GEN-LAST:event_jLabelHomebackMouseClicked

    private void jButtonGpaStdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGpaStdActionPerformed

        String StudentSid = GpaSid.getText();

        try {
            ResultSet rs = DbHandler.getData("Select f.subcode,f.grade,s.credit,s.subcode from grup_project.subject s,grup_project.finalsemmarks f where f.subcode=s.subcode and f.sid= '" + StudentSid + "'");

            DefaultTableModel dt = (DefaultTableModel) jTableviewresults.getModel();
            int row = dt.getRowCount();
            Vector data = new Vector();

            for (int i = 0; i < row; i++) {
                dt.removeRow(i);
            }

            while (rs.next()) {

                Object pq[] = {rs.getString(1), rs.getString(2), rs.getString(3)};
                dt.addRow(pq);
            }
            //  Get row data
            while (rs.next()) {
                Vector row1 = new Vector(row);
                for (int i = 1; i <= row; i++) {
                    row1.addElement(rs.getObject(i));
                }
                data.addElement(row1);
            }
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(GPA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GPA.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ArrayIndexOutOfBoundsException ex) {
            Logger.getLogger(GPA.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButtonGpaStdActionPerformed

    private void GpaSidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GpaSidActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GpaSidActionPerformed

    private void jButtonTotalCreditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTotalCreditActionPerformed
        // TODO add your handling code here:
        GpaCurrentCredit.setText(Integer.toString(getTotalCredits()));

    }//GEN-LAST:event_jButtonTotalCreditActionPerformed

    private void jButtonCalGPAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCalGPAActionPerformed
        // TODO add your handling code here:
        CurGPA.setText(Double.toString(getCurrentGPA()));
    }//GEN-LAST:event_jButtonCalGPAActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GPA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GPA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GPA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GPA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GPA().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CurGPA;
    private javax.swing.JTextField GpaCurrentCredit;
    private javax.swing.JTextField GpaSid;
    private javax.swing.JButton jButtonCalGPA;
    private javax.swing.JButton jButtonGpaStd;
    private javax.swing.JButton jButtonTotalCredit;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelHomeback;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableviewresults;
    // End of variables declaration//GEN-END:variables
}
