/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiz.interfacce;

import guiz.GUIzUtils;
import guiz.RepositoryDomande;
import guiz.SettingsRepository;
import guiz.interfacce.aggiungimodifica.AggiungiHub;
import guiz.interfacce.aggiungimodifica.AggiungiModificaDomandaATempo;
import guiz.interfacce.aggiungimodifica.AggiungiModificaDomandaChiusa;
import guiz.interfacce.aggiungimodifica.AggiungiModificaDomandaPerdiTutto;
import guiz.modelli.Domanda;
import guiz.modelli.DomandaATempo;
import guiz.modelli.DomandaChiusa;
import guiz.modelli.DomandaPerdiTutto;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author notebook
 */
public class PannelloDiAmministrazione extends javax.swing.JFrame {
 
    //associo ad ogni campo delle domande un indice
    public final static int INDICE_TABELLA_ID = 0;     //campo comune a tutte le domande
    public final static int INDICE_TABELLA_TESTO = 1;  //campo comune a tutte le domande
    public final static int INDICE_TABELLA_TIPO = 2;   //campo comune a tutte le domande
    public final static int INDICE_TABELLA_DIFFICOLTA = 3;   //campo comune a tutte le domande    
    public final static int INDICE_TABELLA_RISPOSTA = 4;   //solo per domanda perditutto e a tempo
    public final static int INDICE_TABELLA_OPZIONI = 5;     //solo per domanda chiusa
    public final static int INDICE_TABELLA_TEMPO = 6;       //solo per domanda a tempo

    private void initTableRowCount(int count) { 
        DefaultTableModel model = (DefaultTableModel) tblDomande.getModel();//DefaultTableModel utilizza un vettore di vettori per memorizzare gli oggetti valore di cella.
        model.setRowCount(count); //Imposta il numero di righe nel modello
        tblDomande.setModel(model); //Imposta il modello per questa tabella.
        
    }

    private void initTabella() {
        ArrayList<Domanda> domande = RepositoryDomande.getInstance().getDomande(); //lista che contiene tutte le domande del GUIz

        initTableRowCount(domande.size()); //richiama il metodo che inizializza il numero delle righe pari al numero delle domande

        int riga = 0;
        for (Domanda d : domande) {  //cicla su tutte le domande "generiche" dentro alla lista
            tblDomande.getModel().setValueAt(d.getId(), riga, INDICE_TABELLA_ID); //setta l'ID delle domande nella tabella, alla giusta riga e nella colonna dell'indice giusto
            tblDomande.getModel().setValueAt(d.getTesto(), riga, INDICE_TABELLA_TESTO); //setta il testo delle domande nella tabella, alla giusta riga e nella colonna dell'indice giusto
            tblDomande.getModel().setValueAt(d.getTipo(), riga, INDICE_TABELLA_TIPO);  //setta il tipo delle domande nella tabella, alla giusta riga e nella colonna dell'indice giusto
            tblDomande.getModel().setValueAt(d.getDifficolta().toString(), riga, INDICE_TABELLA_DIFFICOLTA);
            
            if (d instanceof DomandaChiusa) { //se d è un'istanza di domanda chiusa = se la domanda è una domanda chiusa
                DomandaChiusa dc = (DomandaChiusa) d; //assegno a dc la domanda d CASTATA a domanda chiusa, in altre parole assegno la domanda d a una domanda chiusa dc
                tblDomande.getModel().setValueAt(GUIzUtils.formatOpzioni(dc.getOpzioni()), riga, INDICE_TABELLA_OPZIONI); //setta le opzioni alla giusta riga e alla giusta colonna
            }

            if (d instanceof DomandaPerdiTutto) { //se la domanda è una domanda perditutto
                DomandaPerdiTutto dpt = (DomandaPerdiTutto) d; //assegno a dpt la domanda d CASTATA a domanda perditutto
                tblDomande.getModel().setValueAt(dpt.getRisposta(), riga, INDICE_TABELLA_RISPOSTA); //setto la risposta alla giusta riga e alla giusta colonna
            }

            if (d instanceof DomandaATempo) { //se la domanda è una domanda a tempo
                DomandaATempo dt = (DomandaATempo) d; //assegno a dt la domanda d CASTATA a domanda a tempo
                tblDomande.getModel().setValueAt(dt.getRisposta(), riga, INDICE_TABELLA_RISPOSTA); //setto la risposta alla giusta riga e colonna
                long durataSecondi = dt.getTempo().toMillis() / 1000; //memorizzo in una variabile la durata della domanda in millisecondi e la converto in secondi
                tblDomande.getModel().setValueAt(durataSecondi + " second" + (durataSecondi > 1 ? "i" : "o"), riga, INDICE_TABELLA_TEMPO); //setto il tempo alla giusta riga e alla giusta colonna
            }

            riga++;   //faccio scorrere le righe
        }
    }

    private void initImpostazioni() {
        spnDomandeAPartita.setValue(SettingsRepository.getInstance().domandeAPartita());   //setto uno spinner con il numero delle domande a partita
        chbDifficolta.setSelected(SettingsRepository.getInstance().puoScegliereDomandeAPartita()); //setto una checkbox a seconda di se posso scegliere o meno la difficoltà ad inizio partita
    }

    public PannelloDiAmministrazione() {  //costruttore
        initComponents();   //inizializzo i componenti
        initTabella();  //inizializzo la tabella
        initImpostazioni(); //inizializzo le impostazioni
        setLocationRelativeTo(null);  //centro la finestra nello schermo
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDomande = new javax.swing.JTable();
        btnModifica = new javax.swing.JButton();
        btnImporta = new javax.swing.JButton();
        lblImporta = new javax.swing.JLabel();
        chbDifficolta = new javax.swing.JCheckBox();
        spnDomandeAPartita = new javax.swing.JSpinner();
        lblNumeroDomande = new javax.swing.JLabel();
        btnSalva = new javax.swing.JButton();
        cmbOpzioni = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        tblDomande.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Testo", "Tipo", "Difficolta",  "Risposta", "Opzioni", "Tempo",
            }
        ));
        jScrollPane1.setViewportView(tblDomande);

        btnModifica.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        btnModifica.setText("Modifica");
        btnModifica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificaActionPerformed(evt);
            }
        });

        btnImporta.setText("Importa");
        btnImporta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImportaActionPerformed(evt);
            }
        });

        lblImporta.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        lblImporta.setText("Importa domande da file esterno:");

        chbDifficolta.setBackground(new java.awt.Color(204, 255, 204));
        chbDifficolta.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        chbDifficolta.setText("Permetti all'utente di selezionare il livello di difficoltà");

        lblNumeroDomande.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        lblNumeroDomande.setText("Domande a partita:");

        btnSalva.setText("Salva");
        btnSalva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvaActionPerformed(evt);
            }
        });

        cmbOpzioni.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        cmbOpzioni.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cancella", "Aggiungi", "Esporta" }));
        cmbOpzioni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbOpzioniActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel1.setText("PANNELLO DI AMMINISTRAZIONE");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(214, 214, 214)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblNumeroDomande)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 865, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(spnDomandeAPartita, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblImporta)
                            .addComponent(btnImporta)
                            .addComponent(chbDifficolta))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnModifica)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbOpzioni, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSalva)
                .addGap(389, 389, 389))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModifica)
                    .addComponent(cmbOpzioni, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(lblNumeroDomande)
                .addGap(18, 18, 18)
                .addComponent(spnDomandeAPartita, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(lblImporta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnImporta)
                .addGap(30, 30, 30)
                .addComponent(chbDifficolta)
                .addGap(18, 18, 18)
                .addComponent(btnSalva)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
       //evento sulla combobox
    private void cmbOpzioniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbOpzioniActionPerformed
        switch (cmbOpzioni.getSelectedItem().toString()) { //sfrutto lo switch all'interno della combobox a seconda della scelta dell'utente
            case "Aggiungi":
                new AggiungiHub(tblDomande).setVisible(true); //viene caricata l'hub di scelta del tipo di domanda per poi aggiungerla
                break;

            case "Cancella":  
                int selectedRow = tblDomande.getSelectedRow();  //salvo in una variabile la riga selezionata che l'utente vuole cancellare
                if (selectedRow >= 0) {  //se la riga è 0 o maggiore
                    RepositoryDomande.getInstance().rimuoviDomanda(RepositoryDomande.getInstance().getDomande().get(selectedRow)); //viene rimossa la domanda dal repository

                    DefaultTableModel model = (DefaultTableModel) tblDomande.getModel();
                    model.removeRow(selectedRow);  //viene rimossa la riga della domanda selezionata
                    tblDomande.setModel(model);  //viene ri-settato il modello senza la riga cancellata
                }
                break;

            case "Esporta": {
                try {
                    RepositoryDomande.getInstance().esporta(this); //viene richiamata la funzione esporta del repository che permette di salvare su un file esterno le domande
                } catch (Exception ex) {  //gestione eccezioni
                    Logger.getLogger(PannelloDiAmministrazione.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
        }
    }//GEN-LAST:event_cmbOpzioniActionPerformed
   //evento quando si clicca sul bottone "modifica" avendo selezionato la domanda da modificare
    private void btnModificaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificaActionPerformed
        int selectedRow = tblDomande.getSelectedRow(); //viene salvato in una variabile l'indice della riga selezionata nella tabella
        TableModel model = tblDomande.getModel();  

        if (selectedRow >= 0) { //se la riga selezionata è maggiore o = a 0
            int idDomanda = Integer.parseInt(model.getValueAt(selectedRow, INDICE_TABELLA_ID).toString()); //salva in una variabile l'id della domanda selezionata
            switch (model.getValueAt(selectedRow, INDICE_TABELLA_TIPO).toString()) { //uso uno switch per distinguere il tipo di domanda e collegarlo all'interfaccia di modifica corrispondente
                case DomandaChiusa.labelTipo: // se è una domanda chiusa
                    DomandaChiusa domandaChiusa = (DomandaChiusa) RepositoryDomande.getInstance().getDomandaWhereIdIs(idDomanda);
                    new AggiungiModificaDomandaChiusa(domandaChiusa, tblDomande, selectedRow).setVisible(true);  //apro l'interfaccia di modifica di questo tipo di domanda
                    break;
                case DomandaPerdiTutto.labelTipo: //se è una domanda perditutto
                    DomandaPerdiTutto domandaPerdiTutto = (DomandaPerdiTutto) RepositoryDomande.getInstance().getDomandaWhereIdIs(idDomanda);
                    new AggiungiModificaDomandaPerdiTutto(domandaPerdiTutto, tblDomande, selectedRow).setVisible(true); //apro l'interfaccia di modifica di questo tipo di domanda
                    break;
                case DomandaATempo.labelTipo: //se è una domanda a tempo
                    DomandaATempo domandaATempo = (DomandaATempo) RepositoryDomande.getInstance().getDomandaWhereIdIs(idDomanda);
                    new AggiungiModificaDomandaATempo(domandaATempo, tblDomande, selectedRow).setVisible(true); //apro l'interfaccia di modifica di questo tipo di domanda
                    break;
            }
        }
    }//GEN-LAST:event_btnModificaActionPerformed
    //evento al clic del bottone salva
    private void btnSalvaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvaActionPerformed
        boolean puoSceglere = chbDifficolta.isSelected(); //salvo in una variabile booleana la scelta della difficoltà nella checkbox, true se l'utente può scegliere, false se non può.
        int domandeAPartita = Integer.valueOf(spnDomandeAPartita.getValue().toString()); //salvo in una variabile il numero delle domande a partita selezionate nello spinner

        SettingsRepository.getInstance().modificaDomandaAPartita(domandeAPartita);   //richiamati metodi che vanno a modificare nel repository il numero delle domande e la scelta
        SettingsRepository.getInstance().modificaPuoScegliereDomandeAPartita(puoSceglere);
    }//GEN-LAST:event_btnSalvaActionPerformed
    //evento sul clic del bottone "Importa"
    private void btnImportaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImportaActionPerformed
        try {
            SettingsRepository.getInstance().importaDomande(this);  //richiamato il metodo per importare la domanda.
            this.initTabella();
        } catch (Exception ignored) {  //gestione eccezione con messaggio di errore in caso di errore nell'importazione
            JOptionPane.showMessageDialog(this, "Errore durante l'importazione del file", "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnImportaActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImporta;
    private javax.swing.JButton btnModifica;
    private javax.swing.JButton btnSalva;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox chbDifficolta;
    private javax.swing.JComboBox<String> cmbOpzioni;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblImporta;
    private javax.swing.JLabel lblNumeroDomande;
    private javax.swing.JSpinner spnDomandeAPartita;
    private javax.swing.JTable tblDomande;
    // End of variables declaration//GEN-END:variables
}
