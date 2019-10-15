package guiz.modelli;

public class DomandaPerdiTutto extends Domanda { //implementiamo la classe astratta domanda
    public static final String labelTipo = "Perdi tutto";
    
    private String risposta;  //variabile che mi serve per domanda perditutto
                              //oltre quelle gia inizializzate nella classe astratta domanda

    public DomandaPerdiTutto() {  //costruttore vuoto
    }
    
    public DomandaPerdiTutto(String testo, String risposta) { //costruttore
        this.testo = testo;
        this.risposta = risposta;
    }

    public String getRisposta() { //metodi set() & get()
        return risposta;
    }

    public void setRisposta(String risposta) {
        this.risposta = risposta;
    }

    @Override
    public String getTipo() { //sovrascritto il metodo astratto della classe domanda
        return labelTipo;     
    }
}
