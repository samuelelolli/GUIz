package guiz.modelli;

import java.util.ArrayList;

public class DomandaChiusa extends Domanda {
    public static final String labelTipo = "Chiusa";
    
    private ArrayList<OpzioneDomandaChiusa> opzioni;

    public DomandaChiusa() {
        this.opzioni = new ArrayList<>(10);
    }    
    
    public DomandaChiusa(ArrayList<OpzioneDomandaChiusa> opzioni) {
        this.opzioni = opzioni;
    }
    
    public ArrayList<OpzioneDomandaChiusa> getOpzioni() {
        return opzioni;
    }

    public void setOpzioni(ArrayList<OpzioneDomandaChiusa> opzioni) {
        this.opzioni = opzioni;
    }

    @Override
    public String getTipo() {
        return labelTipo;
    }
}
