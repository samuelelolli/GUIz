/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiz.interfacce.aggiungimodifica;

import guiz.RepositoryDomande;
import guiz.interfacce.PannelloDiAmministrazione;
import guiz.modelli.DomandaATempo;
import guiz.modelli.DomandaPerdiTutto;
import java.time.Duration;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author daniele
 */
public class AggiungiModificaDomandaPerdiTutto extends javax.swing.JFrame {

    private DomandaPerdiTutto domanda;
    private boolean inModifica;
    private JTable tableToUpdate;

    private AggiungiModificaDomandaPerdiTutto() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public AggiungiModificaDomandaPerdiTutto(DomandaPerdiTutto d, JTable table) {
        this();
        domanda = d;
        inModifica = (d != null);
        tableToUpdate = table;

        if (inModifica) {
            txtTesto.setText(domanda.getTesto());
            txtRisposta.setText(domanda.getRisposta());
        }
    }

    AggiungiModificaDomandaPerdiTutto(Object object, JTable tableToUpdate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTesto = new javax.swing.JLabel();
        txtTesto = new javax.swing.JTextField();
        btnSalva = new javax.swing.JButton();
        txtRisposta = new javax.swing.JTextField();
        lblRisposta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblTesto.setText("Testo");

        btnSalva.setText("Salva");
        btnSalva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvaActionPerformed(evt);
            }
        });

        lblRisposta.setText("Risposta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTesto)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 457, Short.MAX_VALUE)
                        .addComponent(btnSalva))
                    .addComponent(txtRisposta)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTesto)
                            .addComponent(lblRisposta))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTesto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblRisposta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRisposta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalva)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvaActionPerformed
        if (txtTesto.getText().trim().isEmpty() || txtRisposta.getText().trim().isEmpty()) {
            return;
        }

        if (!inModifica) {
            DomandaPerdiTutto daInserire = new DomandaPerdiTutto(txtTesto.getText(), txtRisposta.getText());

            try {
                RepositoryDomande.getInstance().aggiungiDomanda(daInserire);
                DefaultTableModel model = (DefaultTableModel) tableToUpdate.getModel();
                String[] row = new String[6];

                row[PannelloDiAmministrazione.INDICE_TABELLA_ID] = String.valueOf(daInserire.getId());
                row[PannelloDiAmministrazione.INDICE_TABELLA_RISPOSTA] = daInserire.getRisposta();
                row[PannelloDiAmministrazione.INDICE_TABELLA_TESTO] = daInserire.getTesto();
                row[PannelloDiAmministrazione.INDICE_TABELLA_TIPO] = daInserire.getTipo();

                model.addRow(row);
                tableToUpdate.setModel(model);
                this.dispose();
            } catch (Exception ignored) {
            }
        }
    }//GEN-LAST:event_btnSalvaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalva;
    private javax.swing.JLabel lblRisposta;
    private javax.swing.JLabel lblTesto;
    private javax.swing.JTextField txtRisposta;
    private javax.swing.JTextField txtTesto;
    // End of variables declaration//GEN-END:variables
}
