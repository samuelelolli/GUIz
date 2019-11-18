package guiz.interfacce.partita;

import guiz.modelli.Domanda;
import guiz.modelli.DomandaATempo;
import guiz.modelli.DomandaChiusa;
import guiz.modelli.DomandaPerdiTutto;
import guiz.modelli.Utente;
import java.util.List;
import javax.swing.JFrame;

public class InterfacciaDomanda extends JFrame {
    protected List<Utente> utenti;
    protected List<Domanda> domande;
    protected int indiceDomandaCorrente;
    protected int indiceUtenteCorrente;

    
    public InterfacciaDomanda(List<Utente> utenti, List<Domanda> domande, int indiceDomandaCorrente, int indiceUtenteCorrente) {
        
        setLocationRelativeTo(null);
        
        this.utenti = utenti;
        this.domande = domande;
        this.indiceDomandaCorrente = indiceDomandaCorrente;
        this.indiceUtenteCorrente = indiceUtenteCorrente;
    }
    
    public void successiva() {
        if (indiceDomandaCorrente >= domande.size() - 1) {
            concludi();
            return;
        }
        
        indiceUtenteCorrente++;
        if (indiceUtenteCorrente >= utenti.size())
            indiceUtenteCorrente = 0;

        indiceDomandaCorrente++;
        Domanda successiva = domande.get(indiceDomandaCorrente);
        switch (successiva.getTipo()) {
            case DomandaPerdiTutto.labelTipo:
                new domandaChiusa(utenti, domande, indiceDomandaCorrente, indiceUtenteCorrente).setVisible(true);
                break;

            case DomandaATempo.labelTipo:
                new domandaTempo(utenti, domande, indiceDomandaCorrente, indiceUtenteCorrente).setVisible(true);
                break;

            case DomandaChiusa.labelTipo:
                new domandaChiusa(utenti, domande, indiceDomandaCorrente, indiceUtenteCorrente).setVisible(true);
                break;
        }

    }

    public void concludi() {
        System.out.println("Fine");
    }

    public List<Domanda> getDomande() {
        return domande;
    }

    public int getIndiceDomandaCorrente() {
        return indiceDomandaCorrente;
    }

    public List<Utente> getUtenti() {
        return utenti;
    }
}