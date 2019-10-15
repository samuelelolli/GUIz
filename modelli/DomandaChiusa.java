package guiz.modelli;

import java.util.ArrayList;

public class DomandaChiusa extends Domanda { //implementiamo la classe astratta domanda 
    public static final String labelTipo = "Chiusa";
    
    private ArrayList<OpzioneDomandaChiusa> opzioni;   //lista di oggetti OpzioneDomandaChiusa(è una classe)
                                                       //in cui contenere le opzioni multiple della domanda chiusa

    public DomandaChiusa() { //costruttore, se non gli passo niente mi inizializza l'arraylist a 10 posti circa
        this.opzioni = new ArrayList<>(10);
    }    
    
    public DomandaChiusa(ArrayList<OpzioneDomandaChiusa> opzioni) { //costruttore, se gli passo la lista con le opzioni domanda chiusa
        this.opzioni = opzioni;                                  
    }
    
    public ArrayList<OpzioneDomandaChiusa> getOpzioni() {  //metodi get() & set()
        return opzioni;
    }

    public void setOpzioni(ArrayList<OpzioneDomandaChiusa> opzioni) {
        this.opzioni = opzioni;
    }

    @Override             
    public String getTipo() {    //sovrascritto il metodo astratto della classe domanda
        return labelTipo;       //ritorna la stringa col tipo della domanda
    }
}
