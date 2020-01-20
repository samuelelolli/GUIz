/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiz.interfacce.partita;


import guiz.modelli.Domanda;
import guiz.modelli.DomandaChiusa;
import guiz.modelli.DomandaPerdiTutto;
import guiz.modelli.Utente;
import java.util.List;
import javax.swing.JOptionPane;

public class domandaPT extends InterfacciaDomanda {

    DomandaPerdiTutto domanda;
    
    boolean isAnswerCorrect() {
        return domanda.getRisposta().trim().toLowerCase().equals(txtRisposta.getText().trim().toLowerCase());
    }

    void evaluateAndProceed() {
        if (isAnswerCorrect()) {
            JOptionPane.showMessageDialog(rootPane, "Risposta esatta! +10 punti");
            utenti.get(indiceUtenteCorrente).setPunteggio(utenti.get(indiceUtenteCorrente).getPunteggio() + 10);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Risposta sbagliata! Perdi tutti i punti");
            utenti.get(indiceUtenteCorrente).setPunteggio(0);
        }

        this.dispose();
        this.successiva();
    }
    
    public domandaPT(List<Utente> utenti, List<Domanda> domande, int indiceDomandaCorrente, int indiceUtenteCorrente) {
        super(utenti, domande, indiceDomandaCorrente, indiceUtenteCorrente);
        initComponents();
        setLocationRelativeTo(null);
        lblTurno.setText("E' IL TURNO DI " + utenti.get(indiceUtenteCorrente).getNome());
        txtTesto.setText(domande.get(indiceDomandaCorrente).getTesto());
        lblPunteggio.setText(String.valueOf(utenti.get(indiceUtenteCorrente).getPunteggio()));
        
        domanda = (DomandaPerdiTutto) domande.get(indiceDomandaCorrente);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        lblTurno = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        lblPunteggio = new javax.swing.JTextPane();
        label1 = new java.awt.Label();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtTesto = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtRisposta = new javax.swing.JTextArea();
        btnRisposta = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DOMANDA PERDITUTTO");
        setBackground(java.awt.Color.orange);

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));

        lblTurno.setEditable(false);
        lblTurno.setBackground(java.awt.Color.orange);
        lblTurno.setBorder(new javax.swing.border.MatteBorder(null));
        lblTurno.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lblTurno.setText("ORA E' IL TURNO DI:\n     GIOCATORE N");
        lblTurno.setAlignmentX(3.0F);
        lblTurno.setAlignmentY(3.0F);
        jScrollPane1.setViewportView(lblTurno);

        lblPunteggio.setEditable(false);
        lblPunteggio.setBackground(java.awt.Color.orange);
        lblPunteggio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblPunteggio.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lblPunteggio.setText("PUNTEGGIO ATTUALE:\n          150 PUNTI");
        jScrollPane2.setViewportView(lblPunteggio);

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setBackground(java.awt.Color.orange);
        label1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        label1.setText("DOMANDA PERDITUTTO!");

        txtTesto.setEditable(false);
        txtTesto.setBackground(java.awt.Color.orange);
        txtTesto.setColumns(20);
        txtTesto.setFont(new java.awt.Font("Arial Black", 0, 13)); // NOI18N
        txtTesto.setLineWrap(true);
        txtTesto.setRows(5);
        txtTesto.setText("TESTO DOMANDA:\n\nRipresa stima di E_IN; esempio su sqrt(1-x). Generalizzazione della stima di E_IN nel caso di problemi f:R^n->R; numero/i di condizione. \nEsempi sulle operazioni aritmetiche di moltiplicazione e addizione fra numeri reali. \nEsempio: sqrt(x_1+x_2) - sqrt(x_1). Esempio: radici di un'equazione di secondo grado.\nRichiami sulle funzioni polinomiali. Valutazione numerica di una funzione polinomiale.");
        txtTesto.setToolTipText("");
        jScrollPane3.setViewportView(txtTesto);

        txtRisposta.setBackground(java.awt.Color.orange);
        txtRisposta.setColumns(20);
        txtRisposta.setFont(new java.awt.Font("Arial Black", 0, 13)); // NOI18N
        txtRisposta.setLineWrap(true);
        txtRisposta.setRows(5);
        jScrollPane4.setViewportView(txtRisposta);

        btnRisposta.setActionCommand("RISPOSTA DEFINITIVA!");
        btnRisposta.setBackground(java.awt.Color.orange);
        btnRisposta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRisposta.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        btnRisposta.setLabel("RISPOSTA DEFINITIVA!");
        btnRisposta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRispostaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 576, Short.MAX_VALUE)
                    .addComponent(jScrollPane4))
                .addGap(92, 92, 92))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(279, 279, 279)
                .addComponent(btnRisposta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnRisposta, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
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
        evaluateAndProceed();
        
    }//GEN-LAST:event_btnRispostaActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnRisposta;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private java.awt.Label label1;
    private javax.swing.JTextPane lblPunteggio;
    private javax.swing.JTextPane lblTurno;
    private javax.swing.JTextArea txtRisposta;
    private javax.swing.JTextArea txtTesto;
    // End of variables declaration//GEN-END:variables
}
