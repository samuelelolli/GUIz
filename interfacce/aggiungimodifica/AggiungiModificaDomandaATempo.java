package guiz.interfacce.aggiungimodifica;

import guiz.GUIzUtils;
import guiz.RepositoryDomande;
import guiz.interfacce.PannelloDiAmministrazione;
import guiz.modelli.DomandaATempo;
import java.time.Duration;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AggiungiModificaDomandaATempo extends javax.swing.JFrame {

    private DomandaATempo domanda;
    private boolean inModifica;
    private JTable tableToUpdate;
    private int rowToUpdate;

    private AggiungiModificaDomandaATempo() { //costruttore
        initComponents();
        setLocationRelativeTo(null);
    }

    public AggiungiModificaDomandaATempo(DomandaATempo d, JTable table) { //costruttore per AGGIUNGERE domanda nuova
        this();
        domanda = d;
        tableToUpdate = table;
        inModifica = (d != null);

        if (inModifica) {
            txtTesto.setText(domanda.getTesto());
            txtRisposta.setText(domanda.getRisposta());
            spnTempo.setValue(domanda.getTempo().toMillis());
            cmbDifficolta.setSelectedItem(domanda.getDifficolta().toString());
        }
    }

    public AggiungiModificaDomandaATempo(DomandaATempo d, JTable table, int rowToUpdate) {  //costruttore per MODIFICARE domanda esistente
        this(d, table);
        this.rowToUpdate = rowToUpdate;
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
        lblDifficolta = new javax.swing.JLabel();
        cmbDifficolta = new javax.swing.JComboBox<>();

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

        lblDifficolta.setText("Difficolta");

        cmbDifficolta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "facile", "media", "difficile"}));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTesto)
                    .addComponent(txtRisposta)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTesto)
                            .addComponent(jLabel2)
                            .addComponent(lblRisposta)
                            .addComponent(lblDifficolta)
                            .addComponent(cmbDifficolta, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 304, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(spnTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalva)))
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
                .addGap(18, 18, 18)
                .addComponent(lblDifficolta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbDifficolta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(spnTempo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalva))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvaActionPerformed
        if (Long.parseLong(spnTempo.getValue().toString()) <= 0) {
            return;
        }
        if (txtTesto.getText().trim().isEmpty() || txtRisposta.getText().trim().isEmpty()) {
            return;
        }

        DomandaATempo nuovaDomanda = new DomandaATempo(txtTesto.getText(), txtRisposta.getText(), Duration.ofMillis(Long.parseLong(spnTempo.getValue().toString())), GUIzUtils.estraiDifficolta(cmbDifficolta.getSelectedItem().toString()));
        DefaultTableModel model = (DefaultTableModel) tableToUpdate.getModel();

        try {
            if (!inModifica) {

                RepositoryDomande.getInstance().aggiungiDomanda(nuovaDomanda);

                String[] row = new String[7];
                row[PannelloDiAmministrazione.INDICE_TABELLA_ID] = String.valueOf(nuovaDomanda.getId());
                row[PannelloDiAmministrazione.INDICE_TABELLA_RISPOSTA] = nuovaDomanda.getRisposta();
                row[PannelloDiAmministrazione.INDICE_TABELLA_DIFFICOLTA] = nuovaDomanda.getDifficolta().toString();
                row[PannelloDiAmministrazione.INDICE_TABELLA_TEMPO] = GUIzUtils.formatTempo(nuovaDomanda.getTempo());
                row[PannelloDiAmministrazione.INDICE_TABELLA_TESTO] = nuovaDomanda.getTesto();
                row[PannelloDiAmministrazione.INDICE_TABELLA_TIPO] = nuovaDomanda.getTipo();

                model.addRow(row);
            } else {
                nuovaDomanda.setId(domanda.getId());
                RepositoryDomande.getInstance().modificaDomanda(nuovaDomanda);
                model.setValueAt(nuovaDomanda.getTesto(), rowToUpdate, PannelloDiAmministrazione.INDICE_TABELLA_TESTO);
                model.setValueAt(nuovaDomanda.getRisposta(), rowToUpdate, PannelloDiAmministrazione.INDICE_TABELLA_RISPOSTA);
                model.setValueAt(nuovaDomanda.getDifficolta().toString(), rowToUpdate, PannelloDiAmministrazione.INDICE_TABELLA_DIFFICOLTA);
                model.setValueAt(GUIzUtils.formatTempo(nuovaDomanda.getTempo()), rowToUpdate, PannelloDiAmministrazione.INDICE_TABELLA_TEMPO);
            }
        } catch (Exception ignored) {
            ignored.printStackTrace();
        }

        tableToUpdate.setModel(model);
        this.dispose();
    }//GEN-LAST:event_btnSalvaActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalva;
    private javax.swing.JComboBox<String> cmbDifficolta;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblDifficolta;
    private javax.swing.JLabel lblRisposta;
    private javax.swing.JLabel lblTesto;
    private javax.swing.JSpinner spnTempo;
    private javax.swing.JTextField txtRisposta;
    private javax.swing.JTextField txtTesto;
    // End of variables declaration//GEN-END:variables
}
