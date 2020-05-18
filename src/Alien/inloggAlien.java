/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import testande.AnvandarStartsida;
import testande.Validering;

/**
 *
 * @author marku
 */
public class inloggAlien extends javax.swing.JFrame {

    /**
     * Creates new form inloggAlien
     */
    public inloggAlien() {
        initComponents();
        this.setLocationRelativeTo(null);
        lblFelMeddelande.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFelMeddelande = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtFieldEmail = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtFieldPw = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Email:");

        jLabel2.setText("Password:");

        jButton1.setText("Log in");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtFieldPw.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtFieldPwKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFieldEmail)
                    .addComponent(txtFieldPw, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE))
                .addGap(198, 198, 198))
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(lblFelMeddelande, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtFieldPw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblFelMeddelande, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButton1)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
                lblFelMeddelande.setText("");
        String epost = txtFieldEmail.getText();
        String losenord = new String(txtFieldPw.getPassword());

        if (Validering.textFaltHarVarde(txtFieldEmail) && Validering.textFaltHarVarde(txtFieldPw)) {
            try {
                String fraga = "SELECT Losenord from AlIEN where Epost = '" + epost + "'";
                String fraga2 = "SELECT ALIENID from ALIEN where Epost = '" + epost + "'";

                String losenord2 = GetQuery(fraga);
                String anvandarID = GetQuery(fraga2);

                if (losenord.equals(losenord2)) {
                    dispose();
                    new AnvandarStartsida(epost).setVisible(true);

                } else {
                    lblFelMeddelande.setText("Felaktigt användarnamn eller lösenord");
                }
            } catch (Exception ex) {
                lblFelMeddelande.setText("Något gick fel");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    public String GetQuery(String s) {
        DB_connection.DB_Connection obj_DB_Connection = new DB_connection.DB_Connection();
        Connection connection = obj_DB_Connection.get_connection();
        PreparedStatement ps = null;
        String losen = null;
        try {
            String query = s;
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                losen = rs.getString(1);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return losen;
    }
    
    private void txtFieldPwKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFieldPwKeyPressed
        // TODO add your handling code here:                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            lblFelMeddelande.setText("");
            String epost = txtFieldEmail.getText();
            String losenord = new String(txtFieldPw.getPassword());

            if (Validering.textFaltHarVarde(txtFieldEmail) && Validering.textFaltHarVarde(txtFieldPw)) {
                try {
                    String fraga = "SELECT Losenord from ANVANDARE where Epost = '" + epost + "'";
                    String fraga2 = "SELECT AnvandarID from ANVANDARE where Epost = '" + epost + "'";

                    String losenord2 = GetQuery(fraga);
                    String anvandarID = GetQuery(fraga2);

                    if (losenord.equals(losenord2)) {
                        dispose();
                        new AnvandarStartsida(epost).setVisible(true);

                    } else {
                        lblFelMeddelande.setText("Felaktigt användarnamn eller lösenord");
                    }
                } catch (Exception ex) {
                    lblFelMeddelande.setText("Något gick fel");
                }
            }
        
    }//GEN-LAST:event_txtFieldPwKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblFelMeddelande;
    private javax.swing.JTextField txtFieldEmail;
    private javax.swing.JPasswordField txtFieldPw;
    // End of variables declaration//GEN-END:variables
}
