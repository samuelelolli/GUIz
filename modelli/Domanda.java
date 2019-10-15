package guiz.modelli;

public abstract class Domanda {  //creiamo una classe astratta domanda che sarà implementata dai 3 tipi di domande
    protected String testo;    //variabili comuni a tutti e 3 i tipi di domande
    protected long id;
    
    public abstract String getTipo();   //verrà implementato nelle classi delle domande

    public String getTesto() {      //metoti set() & get()
        return testo;
    }

    public void setTesto(String testo) {
        this.testo = testo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
