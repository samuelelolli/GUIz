/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiz.interfacce.partita;
import guiz.modelli.Domanda;
import guiz.modelli.DomandaATempo;
import guiz.modelli.Utente;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class domandaTempo extends InterfacciaDomanda {

    Timer t;
    long tempoRimanente; //Gestita non come Duration per alleggerire il carico
    boolean tempoScaduto = false;

    boolean isAnswerCorrect() {
        String risposta = txtRisposta.getText().trim().toLowerCase();
        String rispostaEsatta = ((DomandaATempo) domande.get(indiceDomandaCorrente)).getRisposta().trim().toLowerCase();

        return risposta.equals(rispostaEsatta);
    }

    void evaluateAndProceed() {
        if (isAnswerCorrect()) {
            JOptionPane.showMessageDialog(rootPane, "Risposta esatta! +10 punti");
            utenti.get(indiceUtenteCorrente).setPunteggio(utenti.get(indiceUtenteCorrente).getPunteggio() + 10);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Risposta sbagliata!");
        }

        t.stop();
        this.dispose();
        this.successiva();
    }

    void createTimeTimer() {
        ActionListener azione = (ActionEvent evt2) -> {
            lblTempo.setText(Long.toString(tempoRimanente / 1000));
            tempoRimanente -= 1000;
            if (tempoRimanente <= 0) {
                tempoScaduto = true;
                t.stop();
                evaluateAndProceed();
            }
        };
        t = new Timer(1000, azione);
        t.setRepeats(true);
        t.start();
    }

    public domandaTempo(List<Utente> utenti, List<Domanda> domande, int indiceDomandaCorrente, int indiceUtenteCorrente) {
        super(utenti, domande, indiceDomandaCorrente, indiceUtenteCorrente);
        initComponents();

        lblTurno.setText("E' IL TURNO DI " + utenti.get(indiceUtenteCorrente).getNome());
        txtTesto.setText(domande.get(indiceDomandaCorrente).getTesto());
        lblPunteggio.setText("PT: " + String.valueOf(utenti.get(indiceUtenteCorrente).getPunteggio()));
        tempoRimanente = ((DomandaATempo) domande.get(indiceDomandaCorrente)).getTempo().toMillis();
        lblTempo.setText(Long.toString(tempoRimanente / 1000));

        createTimeTimer();
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lblTurno = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        lblPunteggio = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtTesto = new javax.swing.JTextArea();
        btnRisposta = new java.awt.Button();
        label1 = new java.awt.Label();
        lblTempo = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtRisposta = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("DomandaPerditutto");
        setBackground(java.awt.Color.orange);

        lblTurno.setEditable(false);
        lblTurno.setBackground(java.awt.Color.cyan);
        lblTurno.setBorder(new javax.swing.border.MatteBorder(null));
        lblTurno.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lblTurno.setText("ORA E' IL TURNO DI:\n     GIOCATORE N");
        lblTurno.setAlignmentX(3.0F);
        lblTurno.setAlignmentY(3.0F);
        jScrollPane1.setViewportView(lblTurno);

        lblPunteggio.setEditable(false);
        lblPunteggio.setBackground(java.awt.Color.cyan);
        lblPunteggio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        lblPunteggio.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lblPunteggio.setText("PUNTEGGIO ATTUALE:\n          150 PUNTI");
        jScrollPane2.setViewportView(lblPunteggio);

        txtTesto.setEditable(false);
        txtTesto.setBackground(java.awt.Color.cyan);
        txtTesto.setColumns(20);
        txtTesto.setFont(new java.awt.Font("Arial Black", 0, 13)); // NOI18N
        txtTesto.setLineWrap(true);
        txtTesto.setRows(5);
        txtTesto.setText("TESTO DOMANDA:\n\nRipresa stima di E_IN; esempio su sqrt(1-x). Generalizzazione della stima di E_IN nel caso di problemi f:R^n->R; numero/i di condizione. \nEsempi sulle operazioni aritmetiche di moltiplicazione e addizione fra numeri reali. \nEsempio: sqrt(x_1+x_2) - sqrt(x_1). Esempio: radici di un'equazione di secondo grado.\nRichiami sulle funzioni polinomiali. Valutazione numerica di una funzione polinomiale.");
        txtTesto.setToolTipText("");
        jScrollPane3.setViewportView(txtTesto);

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

        label1.setAlignment(java.awt.Label.CENTER);
        label1.setBackground(java.awt.Color.cyan);
        label1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        label1.setText("DOMANDA A TEMPO!");

        lblTempo.setEditable(false);
        lblTempo.setBackground(java.awt.Color.cyan);
        lblTempo.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        lblTempo.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lblTempo.setText("TIMER");

        txtRisposta.setColumns(20);
        txtRisposta.setRows(5);
        jScrollPane5.setViewportView(txtRisposta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRisposta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(281, 281, 281))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(lblTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(187, 187, 187)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
                            .addComponent(jScrollPane5))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2)))
                    .addComponent(lblTempo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(btnRisposta, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRispostaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRispostaActionPerformed
        if (!tempoScaduto){
            t.stop();
            evaluateAndProceed();
        }
        
    }//GEN-LAST:event_btnRispostaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button btnRisposta;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private java.awt.Label label1;
    private javax.swing.JTextPane lblPunteggio;
    private javax.swing.JTextField lblTempo;
    private javax.swing.JTextPane lblTurno;
    private javax.swing.JTextArea txtRisposta;
    private javax.swing.JTextArea txtTesto;
    // End of variables declaration//GEN-END:variables
}
