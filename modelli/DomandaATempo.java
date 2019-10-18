package guiz.modelli;

import java.time.Duration;

public class DomandaATempo extends Domanda {    //implementiamo la classe astratta domanda 
    public static final String labelTipo = "A tempo";   
    
    private String risposta;  //variabili solo per la domanda a tempo
    private Duration tempo;   

    public DomandaATempo() {  //costruttore vuoto
    }
    
    public DomandaATempo(String testo, String risposta, Duration tempo, Difficolta difficolta) {  //costruttore 
        this.testo = testo;
        this.risposta = risposta;
        this.tempo = tempo;
        this.difficolta = difficolta;
    }

    public String getRisposta() {   //metodi set() & get()
        return risposta;
    }

    public void setRisposta(String risposta) {
        this.risposta = risposta;
    }

    public Duration getTempo() {
        return tempo;
    }

    public void setTempo(Duration tempo) {
        this.tempo = tempo;
    }

    @Override        
    public String getTipo() {   //sovrascritto il metodo astratto della classe domanda
        return labelTipo;       //ritorna la stringa col tipo della domanda
    }
    
    
}
