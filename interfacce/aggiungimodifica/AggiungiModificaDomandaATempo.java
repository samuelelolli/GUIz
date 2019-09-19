/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiz.interfacce.aggiungimodifica;

import guiz.RepositoryDomande;
import guiz.interfacce.PannelloDiAmministrazione;
import guiz.modelli.DomandaATempo;
import java.time.Duration;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author daniele
 */
public class AggiungiModificaDomandaATempo extends javax.swing.JFrame {

    private DomandaATempo domanda;
    private boolean inModifica;
    private JTable tableToUpdate;

    private AggiungiModificaDomandaATempo() {
        initComponents();
    }

    public AggiungiModificaDomandaATempo(DomandaATempo d, JTable table) {
        this();
        domanda = d;
        tableToUpdate = table;
        inModifica = (d != null);

        if (inModifica) {
            txtTesto.setText(domanda.getTesto());
            txtRisposta.setText(domanda.getRisposta());
            spnTempo.setValue(domanda.getTempo().toMillis());
        }
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtTesto = new javax.swing.JTextField();
        spnTempo = new javax.swing.JSpinner();
        lblTesto = new javax.swing.JLabel();
        btnSalva = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
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

        jLabel2.setText("Tempo");

        lblRisposta.setText("Risposta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTesto)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(spnTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 358, Short.MAX_VALUE)
                        .addComponent(btnSalva))
                    .addComponent(txtRisposta)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTesto)
                            .addComponent(jLabel2)
                            .addComponent(lblRisposta))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblTesto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblRisposta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtRisposta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spnTempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalva))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvaActionPerformed
        if (txtTesto.getText().trim().isEmpty()) return;
        
        if (!inModifica) {
            DomandaATempo daInserire = new DomandaATempo(txtTesto.getText(), txtRisposta.getText(), Duration.ofMillis(Long.parseLong(spnTempo.getValue().toString())));

            try {
                RepositoryDomande.getInstance().aggiungiDomanda(daInserire);
                DefaultTableModel model = (DefaultTableModel) tableToUpdate.getModel();
                String[] row = new String[6];

                row[PannelloDiAmministrazione.INDICE_TABELLA_ID] = String.valueOf(daInserire.getId());
                row[PannelloDiAmministrazione.INDICE_TABELLA_RISPOSTA] = daInserire.getRisposta();
                long durataSecondi = daInserire.getTempo().toMillis() / 1000;
                row[PannelloDiAmministrazione.INDICE_TABELLA_TEMPO] = String.valueOf(durataSecondi + " second" + (durataSecondi > 1 ? "i" : "o"));
                row[PannelloDiAmministrazione.INDICE_TABELLA_TESTO] = daInserire.getTesto();
                row[PannelloDiAmministrazione.INDICE_TABELLA_TIPO] = "A tempo";

                model.addRow(row);
                tableToUpdate.setModel(model);
                this.dispose();
            } catch (Exception ignored) {
            }
        }
    }//GEN-LAST:event_btnSalvaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalva;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblRisposta;
    private javax.swing.JLabel lblTesto;
    private javax.swing.JSpinner spnTempo;
    private javax.swing.JTextField txtRisposta;
    private javax.swing.JTextField txtTesto;
    // End of variables declaration//GEN-END:variables
}