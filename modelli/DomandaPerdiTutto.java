package guiz.modelli;

public class DomandaPerdiTutto extends Domanda {
    private String risposta;

    public DomandaPerdiTutto(String testo, String risposta) {
        this.testo = testo;
        this.risposta = risposta;
    }

    public String getRisposta() {
        return risposta;
    }

    public void setRisposta(String risposta) {
        this.risposta = risposta;
    }
}
