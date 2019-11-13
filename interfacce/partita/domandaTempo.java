/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiz.interfacce.partita;

import guiz.modelli.Domanda;
import guiz.modelli.Utente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.Timer;

public class domandaTempo extends InterfacciaDomanda {

    static final String labelTipo = "DomandaTempo";

    Timer t;
    int conta;

    public domandaTempo(List<Utente> utenti, List<Domanda> domande, int indiceDomandaCorrente, int indiceUtenteCorrente) {
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        label1 = new java.awt.Label();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtTesto = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtRisposta = new javax.swing.JTextArea();
        btnRisposta = new java.awt.Button();
        lblPunteggio = new javax.swing.JLabel();
        lblTurno = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DomandaPerditutto");
        setBackground(java.awt.Color.orange);

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));

        jTextField1.setEditable(false);
        jTextField1.setBackground(java.awt.Color.cyan);
        jTextField1.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("TIMER");

        jButton1.setBackground(java.awt.Color.cyan);
        jButton1.setFont(new java.awt.Font("Arial Black", 0, 11)); // NOI18N
        jButton1.setText("PARTI!");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setBackground(java.awt.Color.cyan);
        label1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        label1.setText("DOMANDA A TEMPO!");

        txtTesto.setEditable(false);
        txtTesto.setBackground(java.awt.Color.cyan);
        txtTesto.setColumns(20);
        txtTesto.setFont(new java.awt.Font("Arial Black", 0, 13)); // NOI18N
        txtTesto.setLineWrap(true);
        txtTesto.setRows(5);
        txtTesto.setText("Ripresa stima di E_IN; esempio su sqrt(1-x). Generalizzazione della stima di E_IN nel caso di problemi f:R^n->R; numero/i di condizione. \nEsempi sulle operazioni aritmetiche di moltiplicazione e addizione fra numeri reali. \nEsempio: sqrt(x_1+x_2) - sqrt(x_1). Esempio: radici di un'equazione di secondo grado.\nRichiami sulle funzioni polinomiali. Valutazione numerica di una funzione polinomiale.");
        txtTesto.setToolTipText("");
        jScrollPane3.setViewportView(txtTesto);

        txtRisposta.setBackground(java.awt.Color.cyan);
        txtRisposta.setColumns(20);
        txtRisposta.setFont(new java.awt.Font("Arial Black", 0, 13)); // NOI18N
        txtRisposta.setLineWrap(true);
        txtRisposta.setRows(5);
        txtRisposta.setText("RISPOSTA GIOCATORE:\n");
        jScrollPane4.setViewportView(txtRisposta);

        btnRisposta.setActionCommand("RISPOSTA DEFINITIVA!");
        btnRisposta.setBackground(java.awt.Color.cyan);
        btnRisposta.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnRisposta.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        btnRisposta.setLabel("RISPOSTA DEFINITIVA!");
        btnRisposta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRispostaActionPerformed(evt);
            }
        });

        lblPunteggio.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lblPunteggio.setText("PUNTEGGIO ATTUALE: 150 PT");
        lblPunteggio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        lblTurno.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lblTurno.setText("<html> ORA E' IL TURNO DI: <br>GIOCATORE N   </html>\n\n");
        lblTurno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 549, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(127, 127, 127))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblTurno, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(85, 85, 85)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                                .addComponent(lblPunteggio, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane3))
                        .addGap(18, 18, 18))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(220, 220, 220)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRisposta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(315, 315, 315))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPunteggio, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addComponent(btnRisposta, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRispostaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRispostaActionPerformed
        this.successiva();
        this.dispose();

    }//GEN-LAST:event_btnRispostaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        conta = 10;
        ActionListener azione = (ActionEvent evt2) -> {
            jTextField1.setText(Integer.toString(conta));
            conta--;
            if (conta <= 0) {
                t.stop();
            }
        };
        t = new Timer(1000, azione);
        t.setRepeats(true);
        t.start();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnRisposta;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextField jTextField1;
    private java.awt.Label label1;
    private javax.swing.JLabel lblPunteggio;
    private javax.swing.JLabel lblTurno;
    private javax.swing.JTextArea txtRisposta;
    private javax.swing.JTextArea txtTesto;
    // End of variables declaration//GEN-END:variables
}
