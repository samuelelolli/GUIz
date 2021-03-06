package guiz.interfacce;

import javax.swing.JOptionPane;

public class LoginPannello extends javax.swing.JFrame {

    private String password = "";  //definiamo la password come una variabile stringa per semplicità
    
    public LoginPannello() {  //costruttore del login al pannello, vengono inizializzati componenti del pannello
        initComponents();
        setLocationRelativeTo(null);  //centra la finestra sullo schermo
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPassword = new javax.swing.JPasswordField();
        lblPassword = new javax.swing.JLabel();
        btnOK = new javax.swing.JButton();

        setTitle("LOGIN");

        txtPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPasswordKeyPressed(evt);
            }
        });

        lblPassword.setText("Inserire la password");

        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnOK))
                    .addComponent(lblPassword))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(lblPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOK))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean convalidaPassword(String passwordDigitata){ //metodo booleano, ritorna vero se la password digitata è giusta
        return password.equals(passwordDigitata); 
    }
    
    private void vaiAlPannello(){ //metodo per entrare nel pannello di amministrazione dopo il login
        new PannelloDiAmministrazione().setVisible(true); //rende visibile la finestra del pannello di amministrazione
        this.setVisible(false); //rende NON più visibile la finestrina del login 
        this.dispose(); //fa sì che la finestra venga distrutta e ripulita dal sistema operativo. 
    }
    
    //metodo per gestire il click sul bottone "OK" dopo aver digitato la password
    private void btnOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOKActionPerformed
        if (convalidaPassword(String.valueOf(txtPassword.getPassword()))){ //se la password digitata corrisponde a quella giusta
            vaiAlPannello(); // entra nel pannello
        }
        else  //altrimenti mostra una finestrella di errore, permettendo di digitare nuovamente la password
            JOptionPane.showMessageDialog(this, "Password sbagliata", "Errore", JOptionPane.ERROR_MESSAGE);
    }//GEN-LAST:event_btnOKActionPerformed

    //metodo per gestire il clic sul pulsante "invio" per confermare la password
    private void txtPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPasswordKeyPressed
        if (evt.getKeyChar() == '\n')  //se si clicca su invio dopo aver digitata la password
        {
            if (convalidaPassword(String.valueOf(txtPassword.getPassword()))){  //viene verificata la correttezza della password
                vaiAlPannello(); //nel caso sia corretta entra nel pannello
            }
            else  //altrimenti mostra una finestrella di errore, permettendo di digitare nuovamente la password
                JOptionPane.showMessageDialog(this, "Password sbagliata", "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_txtPasswordKeyPressed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnOK;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
