package guiz.modelli;

import java.time.Duration;

public class DomandaATempo extends Domanda {
    private String risposta;
    private Duration tempo;

    public DomandaATempo() {
    }
    
    public DomandaATempo(String testo, String risposta, Duration tempo) {
        this.testo = testo;
        this.risposta = risposta;
        this.tempo = tempo;
    }

    public String getRisposta() {
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
}
