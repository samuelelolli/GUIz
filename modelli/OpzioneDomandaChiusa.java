/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiz.modelli;

public class OpzioneDomandaChiusa {  //classe per le opzioni domanda chiusa
    private String testo;     //utilizzo due varibili che mi servono per la domanda chiusa: il testo della domanda
    private boolean esatta;   //e un boolean per la risposta giusta

    public OpzioneDomandaChiusa(String testo, boolean esatta) { //costruttore
        this.testo = testo;
        this.esatta = esatta;
    }
    
    public String getTesto() {  //metodi set() & get()
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public boolean isEsatta() {    //metodo che ritorna true o false se la risposta è esatta o meno
        return esatta;
    }

    public void setEsatta(boolean esatta) {  //metodo per settare se una risposta è giusta o meno
        this.esatta = esatta;
    }
}
