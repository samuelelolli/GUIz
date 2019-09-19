/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiz.interfacce.aggiungimodifica;

import guiz.modelli.DomandaChiusa;
import guiz.modelli.OpzioneDomandaChiusa;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.ListModel;

/**
 *
 * @author daniele
 */
public class AggiungiModificaOpzioneDomandaChiusa extends javax.swing.JFrame {

    private OpzioneDomandaChiusa opzione;
    private boolean inModifica;
    private JList<String> listToUpdate;
    private DomandaChiusa domandaToUpdate;
    private int selectedIndex;
    private JCheckBox checkBoxToUpdate;

    private AggiungiModificaOpzioneDomandaChiusa() {
        initComponents();
    }

    public AggiungiModificaOpzioneDomandaChiusa(OpzioneDomandaChiusa opzione, JList<String> toUpdate, DomandaChiusa domandaToUpdate, int selectedIndex, JCheckBox checkBoxToUpdate) {
        this();
        this.opzione = opzione;
        this.listToUpdate = toUpdate;
        this.domandaToUpdate = domandaToUpdate;
        this.selectedIndex = selectedIndex;
        this.checkBoxToUpdate = checkBoxToUpdate;
        
        inModifica = opzione != null;

        if (inModifica) {
            txtTestoOpzione.setText(opzione.getTesto());
            chbCorretta.setSelected(opzione.isEsatta());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTestoOpzione = new javax.swing.JTextField();
        lblTestoOpzione = new javax.swing.JLabel();
        chbCorretta = new javax.swing.JCheckBox();
        btnSalva = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblTestoOpzione.setText("Testo opzione");

        chbCorretta.setText("Corretta");

        btnSalva.setText("Salva");
        btnSalva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTestoOpzione)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTestoOpzione)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chbCorretta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 252, Short.MAX_VALUE)
                        .addComponent(btnSalva)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(lblTestoOpzione)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTestoOpzione, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chbCorretta)
                    .addComponent(btnSalva))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvaActionPerformed
        if (txtTestoOpzione.getText().trim().isEmpty()) return;
        
        if (!inModifica) {
            OpzioneDomandaChiusa daAggiungere = new OpzioneDomandaChiusa(txtTestoOpzione.getText(), chbCorretta.isSelected());

            ListModel<String> listModel = listToUpdate.getModel();
            DefaultListModel<String> model = (DefaultListModel<String>) listModel;

            model.addElement(daAggiungere.getTesto());
            domandaToUpdate.getOpzioni().add(daAggiungere);

            listToUpdate.setModel(model);
        }
        else
        {
            opzione.setTesto(txtTestoOpzione.getText());
            opzione.setEsatta(chbCorretta.isSelected());
            
            ListModel<String> listModel = listToUpdate.getModel();
            DefaultListModel<String> model = (DefaultListModel<String>) listModel;
            model.setElementAt(opzione.getTesto(), selectedIndex);
            checkBoxToUpdate.setSelected(opzione.isEsatta());
        }

        this.dispose();
    }//GEN-LAST:event_btnSalvaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalva;
    private javax.swing.JCheckBox chbCorretta;
    private javax.swing.JLabel lblTestoOpzione;
    private javax.swing.JTextField txtTestoOpzione;
    // End of variables declaration//GEN-END:variables
}
