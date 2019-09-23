package guiz.modelli;

public class DomandaPerdiTutto extends Domanda {
    public static final String labelTipo = "Perdi tutto";
    
    private String risposta;

    public DomandaPerdiTutto() {
    }
    
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

    @Override
    public String getTipo() {
        return labelTipo;
    }
}
