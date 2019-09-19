/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiz.interfacce.aggiungimodifica;

import javax.swing.JTable;

/**
 *
 * @author daniele
 */
public class AggiungiHub extends javax.swing.JFrame {

    /**
     * Creates new form AggiungiHub
     */
    
    JTable tableToUpdate;
    
    public AggiungiHub(JTable table) {
        initComponents();
        tableToUpdate = table;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnDomandaChiusa = new javax.swing.JButton();
        btnDomandaATempo = new javax.swing.JButton();
        btnDomandaPerdiTutto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnDomandaChiusa.setText("Domanda chiusa");
        btnDomandaChiusa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDomandaChiusaActionPerformed(evt);
            }
        });

        btnDomandaATempo.setText("Domanda a tempo");
        btnDomandaATempo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDomandaATempoActionPerformed(evt);
            }
        });

        btnDomandaPerdiTutto.setText("Domanda perdi tutto");
        btnDomandaPerdiTutto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDomandaPerdiTuttoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnDomandaATempo)
                .addGap(18, 18, 18)
                .addComponent(btnDomandaPerdiTutto)
                .addGap(18, 18, 18)
                .addComponent(btnDomandaChiusa)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDomandaATempo)
                    .addComponent(btnDomandaPerdiTutto)
                    .addComponent(btnDomandaChiusa))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDomandaATempoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDomandaATempoActionPerformed
        new AggiungiModificaDomandaATempo(null, tableToUpdate).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDomandaATempoActionPerformed

    private void btnDomandaPerdiTuttoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDomandaPerdiTuttoActionPerformed
        new AggiungiModificaDomandaPerdiTutto(null, tableToUpdate).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDomandaPerdiTuttoActionPerformed

    private void btnDomandaChiusaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDomandaChiusaActionPerformed
        new AggiungiModificaDomandaChiusa(null, tableToUpdate).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnDomandaChiusaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDomandaATempo;
    private javax.swing.JButton btnDomandaChiusa;
    private javax.swing.JButton btnDomandaPerdiTutto;
    // End of variables declaration//GEN-END:variables
}
