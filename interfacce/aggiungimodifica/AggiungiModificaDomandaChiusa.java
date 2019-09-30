/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiz.interfacce.aggiungimodifica;

import guiz.GUIzUtils;
import guiz.RepositoryDomande;
import guiz.interfacce.PannelloDiAmministrazione;
import guiz.modelli.DomandaChiusa;
import guiz.modelli.OpzioneDomandaChiusa;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author daniele
 */
public class AggiungiModificaDomandaChiusa extends javax.swing.JFrame {

    private DomandaChiusa domanda;
    private boolean inModifica;
    private JTable tableToUpdate;
    private int rowToUpdate;

    private AggiungiModificaDomandaChiusa() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public AggiungiModificaDomandaChiusa(DomandaChiusa d, JTable table) {
        this();
        domanda = d;
        inModifica = (d != null);
        tableToUpdate = table;

        DefaultListModel<String> model = new DefaultListModel<>();
        lstOpzioni.setModel(model);

        if (inModifica) {
            txtTesto.setText(domanda.getTesto());
            for (OpzioneDomandaChiusa opzione : domanda.getOpzioni()) {
                model.addElement(opzione.getTesto());
            }
        } else {
            domanda = new DomandaChiusa();
        }
    }

    public AggiungiModificaDomandaChiusa(DomandaChiusa d, JTable table, int rowToUpdate) {
        this(d, table);
        this.rowToUpdate = rowToUpdate;
    }

    private boolean isValidForm() {
        if (txtTesto.getText().trim().isEmpty() || lstOpzioni.getModel().getSize() == 0) {
            return false;
        }

        boolean correctFound = false;
        for (OpzioneDomandaChiusa opt : domanda.getOpzioni()) {
            if (opt.isEsatta()) {
                correctFound = true;
                break;
            }
        }
        
        if (!correctFound) {
            return false;
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTesto = new javax.swing.JLabel();
        txtTesto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstOpzioni = new javax.swing.JList<>();
        chbCorretta = new javax.swing.JCheckBox();
        btnSalva = new javax.swing.JButton();
        btnPiu = new javax.swing.JButton();
        btnMeno = new javax.swing.JButton();
        btnModifica = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblTesto.setText("Testo");

        lstOpzioni.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstOpzioniValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstOpzioni);

        chbCorretta.setText("Corretta");
        chbCorretta.setEnabled(false);

        btnSalva.setText("Salva");
        btnSalva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvaActionPerformed(evt);
            }
        });

        btnPiu.setText("+");
        btnPiu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPiuActionPerformed(evt);
            }
        });

        btnMeno.setText("-");
        btnMeno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenoActionPerformed(evt);
            }
        });

        btnModifica.setText("Modifica");
        btnModifica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificaActionPerformed(evt);
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
                        .addComponent(lblTesto)
                        .addGap(172, 172, 172))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTesto)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(btnMeno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 380, Short.MAX_VALUE)
                                .addComponent(btnSalva))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnPiu)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnModifica))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(chbCorretta)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTesto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(chbCorretta)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModifica)
                    .addComponent(btnMeno)
                    .addComponent(btnPiu)
                    .addComponent(btnSalva))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lstOpzioniValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstOpzioniValueChanged
        int selectedIndex = lstOpzioni.getSelectedIndex();

        if (selectedIndex >= 0) {
            chbCorretta.setSelected(domanda.getOpzioni().get(selectedIndex).isEsatta());
        }
    }//GEN-LAST:event_lstOpzioniValueChanged

    private void btnPiuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPiuActionPerformed
        new AggiungiModificaOpzioneDomandaChiusa(null, lstOpzioni, domanda, -1, null).setVisible(true);
    }//GEN-LAST:event_btnPiuActionPerformed

    private void btnMenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenoActionPerformed
        int selectedIndex = lstOpzioni.getSelectedIndex();
        if (selectedIndex >= 0) {
            DefaultListModel model = (DefaultListModel) lstOpzioni.getModel();
            model.remove(selectedIndex);
            domanda.getOpzioni().remove(selectedIndex);

            lstOpzioni.setModel(model);
            chbCorretta.setSelected(false);
        }
    }//GEN-LAST:event_btnMenoActionPerformed

    private void btnModificaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificaActionPerformed
        int selectedIndex = lstOpzioni.getSelectedIndex();
        if (selectedIndex >= 0) {
            new AggiungiModificaOpzioneDomandaChiusa(domanda.getOpzioni().get(selectedIndex), lstOpzioni, domanda, selectedIndex, chbCorretta).setVisible(true);
        }
    }//GEN-LAST:event_btnModificaActionPerformed

    private void btnSalvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvaActionPerformed
        if (!isValidForm()) return;
        
        DefaultTableModel model = (DefaultTableModel) tableToUpdate.getModel();
        domanda.setTesto(txtTesto.getText());
        
        try {
            if (!inModifica) {
                RepositoryDomande.getInstance().aggiungiDomanda(domanda);

                String[] row = new String[6];

                row[PannelloDiAmministrazione.INDICE_TABELLA_ID] = String.valueOf(domanda.getId());
                row[PannelloDiAmministrazione.INDICE_TABELLA_TESTO] = domanda.getTesto();
                row[PannelloDiAmministrazione.INDICE_TABELLA_TIPO] = domanda.getTipo();
                row[PannelloDiAmministrazione.INDICE_TABELLA_OPZIONI] = GUIzUtils.formatOpzioni(domanda.getOpzioni());
                model.addRow(row);
                tableToUpdate.setModel(model);

            } else {
                RepositoryDomande.getInstance().modificaDomanda(domanda);
                model.setValueAt(domanda.getTesto(), rowToUpdate, PannelloDiAmministrazione.INDICE_TABELLA_TESTO);
                model.setValueAt(GUIzUtils.formatOpzioni(domanda.getOpzioni()), rowToUpdate, PannelloDiAmministrazione.INDICE_TABELLA_OPZIONI);
            }
        } catch (Exception ignored) {
        }
        this.dispose();
    }//GEN-LAST:event_btnSalvaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMeno;
    private javax.swing.JButton btnModifica;
    private javax.swing.JButton btnPiu;
    private javax.swing.JButton btnSalva;
    private javax.swing.JCheckBox chbCorretta;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTesto;
    private javax.swing.JList<String> lstOpzioni;
    private javax.swing.JTextField txtTesto;
    // End of variables declaration//GEN-END:variables
}
