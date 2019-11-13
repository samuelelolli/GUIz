/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiz.interfacce.partita;

import guiz.modelli.Domanda;
import guiz.modelli.Utente;
import java.util.List;

/**
 *
 * @author notebook
 */
public class domandaChiusa extends InterfacciaDomanda {

    static final String labelTipo = "DomandaChiusa";

    public domandaChiusa(List<Utente> utenti, List<Domanda> domande, int indiceDomandaCorrente, int indiceUtenteCorrente) {
        initComponents();
        setLocationRelativeTo(null);
        
        this.utenti = utenti;
        this.domande = domande;
        this.indiceDomandaCorrente = indiceDomandaCorrente;
        this.indiceUtenteCorrente = indiceUtenteCorrente;
        
        lblTurno.setText("E' IL TURNO DI " + utenti.get(indiceUtenteCorrente).getNome());
    }

    @Override
    public String getTipo() {
        return labelTipo;
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
        label1 = new java.awt.Label();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtTesto = new javax.swing.JTextArea();
        btnRisposta = new java.awt.Button();
        lblTurno = new javax.swing.JLabel();
        lblPunteggio = new javax.swing.JLabel();
        cmbRisposta = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setBackground(java.awt.Color.pink);
        label1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        label1.setText("DOMANDA CHIUSA!");

        txtTesto.setBackground(java.awt.Color.pink);
        txtTesto.setColumns(20);
        txtTesto.setFont(new java.awt.Font("Arial Black", 0, 13)); // NOI18N
        txtTesto.setLineWrap(true);
        txtTesto.setRows(5);
        txtTesto.setText("TESTO DOMANDA:\n\nRipresa stima di E_IN; esempio su sqrt(1-x). Generalizzazione della stima di E_IN nel caso di problemi f:R^n->R; numero/i di condizione. \nEsempi sulle operazioni aritmetiche di moltiplicazione e addizione fra numeri reali. \nEsempio: sqrt(x_1+x_2) - sqrt(x_1). Esempio: radici di un'equazione di secondo grado.\nRichiami sulle funzioni polinomiali. Valutazione numerica di una funzione polinomiale.");
        jScrollPane3.setViewportView(txtTesto);

        btnRisposta.setActionCommand("RISPOSTA DEFINITIVA!");
        btnRisposta.setBackground(java.awt.Color.pink);
        btnRisposta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRisposta.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        btnRisposta.setLabel("RISPOSTA DEFINITIVA!");
        btnRisposta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRispostaActionPerformed(evt);
            }
        });

        lblTurno.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lblTurno.setText("<html> ORA E' IL TURNO DI: <br>GIOCATORE N   </html>\n\n");
        lblTurno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblPunteggio.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lblPunteggio.setText("PUNTEGGIO ATTUALE: 150 PT");
        lblPunteggio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        cmbRisposta.setBackground(new java.awt.Color(255, 153, 153));
        cmbRisposta.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3", "4", "5" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(lblPunteggio))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 650, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(cmbRisposta, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(307, 307, 307)
                        .addComponent(btnRisposta, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPunteggio, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(cmbRisposta, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btnRisposta, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRispostaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRispostaActionPerformed
        this.successiva();
        this.dispose();
    }//GEN-LAST:event_btnRispostaActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnRisposta;
    private javax.swing.JComboBox<String> cmbRisposta;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private java.awt.Label label1;
    private javax.swing.JLabel lblPunteggio;
    private javax.swing.JLabel lblTurno;
    private javax.swing.JTextArea txtTesto;
    // End of variables declaration//GEN-END:variables
}
