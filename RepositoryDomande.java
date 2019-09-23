package guiz;

import guiz.modelli.Domanda;
import java.util.ArrayList;
import guiz.xmlutils.XMLHandler;
import java.util.Comparator;

public class RepositoryDomande {
    private static RepositoryDomande INSTANCE;
    
    private final ArrayList<Domanda> domande;
    private XMLHandler handler;
    
    private RepositoryDomande() {
        handler = new XMLHandler("C:\\GUIz\\domande.xml");
        domande = handler.leggiDomande();
        domande.sort(new Comparator<Domanda>(){
            @Override
            public int compare(Domanda d1, Domanda d2) {
                Long id1 = d1.getId(), id2 = d2.getId();
                return id1.compareTo(id2);
            }
        
        });
    }
   
    private long idDaInserire(){
        if (domande.isEmpty()) return 1;
        
        long max = domande.get(0).getId();
        
        for (Domanda d : domande){
            if (d.getId() > max) max = d.getId();
        }
        
        return max + 1;
    }
    
    public void aggiungiDomanda(Domanda domanda) throws Exception{
        domanda.setId(idDaInserire());
        domande.add(domanda);
        handler.aggiungiDomanda(domanda);
    }
    
    public void rimuoviDomanda(Domanda domanda){
        domande.remove(domanda);
        handler.rimuoviDomanda(domanda.getId());
    }
    
    public void modificaDomanda(Domanda domanda) throws Exception {
        Domanda toUpdate = getDomandaWhereIdIs(domanda.getId());
        if (toUpdate == null) return;
        
        handler.modificaDomanda(domanda);
        domande.remove(toUpdate);
        domande.add(domanda);
    }
    
    public static RepositoryDomande getInstance() {
        if (INSTANCE != null) return INSTANCE;
        
        INSTANCE = new RepositoryDomande();
        return INSTANCE;
    }

    public ArrayList<Domanda> getDomande() {
        return domande;
    }
    
    public Domanda getDomandaWhereIdIs(long id){
        for (Domanda d : domande)
            if (id == d.getId())
                return d;
        
        return null;
    }
}
