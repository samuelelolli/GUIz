package guiz.modelli;

import java.util.ArrayList;

public class DomandaChiusa extends Domanda {
    private ArrayList<OpzioneDomandaChiusa> opzioni;

    public DomandaChiusa(ArrayList<OpzioneDomandaChiusa> opzioni) {
        this.opzioni = opzioni;
    }
    
    public ArrayList<OpzioneDomandaChiusa> getOpzioni() {
        return opzioni;
    }

    public void setOpzioni(ArrayList<OpzioneDomandaChiusa> opzioni) {
        this.opzioni = opzioni;
    }
}
