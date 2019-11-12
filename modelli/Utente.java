package guiz.modelli;

public class Utente {
    String nome;
    int punteggio;

    public Utente(String nome) {
        this.nome = nome;
        this.punteggio = 0;
    }

    public Utente(String nome, int punteggio) {
        this(nome);
        this.punteggio = punteggio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }
}
