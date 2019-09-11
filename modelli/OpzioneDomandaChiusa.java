/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiz.modelli;

/**
 *
 * @author daniele
 */
public class OpzioneDomandaChiusa {
    private String testo;
    private boolean esatta;

    public OpzioneDomandaChiusa(String testo, boolean esatta) {
        this.testo = testo;
        this.esatta = esatta;
    }
    
    public String getTesto() {
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public boolean isEsatta() {
        return esatta;
    }

    public void setEsatta(boolean esatta) {
        this.esatta = esatta;
    }
}
