package guiz.modelli;

public abstract class Domanda {
    protected String testo;
    protected long id;
    
    public abstract String getTipo();

    public String getTesto() {
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
