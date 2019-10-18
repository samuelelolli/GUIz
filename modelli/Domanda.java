package guiz.modelli;

public abstract class Domanda {  //creiamo una classe astratta domanda che sarà implementata dai 3 tipi di domande
    public enum Difficolta{
        facile,
        media,
        difficile,
        sconosciuta
    }
    
    protected String testo;    //variabili comuni a tutti e 3 i tipi di domande
    protected long id;
    protected Difficolta difficolta; 
    
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

    public Difficolta getDifficolta() {
        return difficolta;
    }

    public void setDifficolta(Difficolta difficolta) { 
        this.difficolta = difficolta;
    }
}
