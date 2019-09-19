package guiz;

import guiz.modelli.Domanda;
import java.util.ArrayList;
import guiz.xmlutils.XMLHandler;

public class RepositoryDomande {
    private final ArrayList<Domanda> domande;
    private XMLHandler handler;
    
    private RepositoryDomande() {
        handler = new XMLHandler("C:\\GUIz\\domande.xml");
        domande = handler.leggiDomande();
    }
   
    private long idDaInserire(){
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
    
    public static RepositoryDomande getInstance() {
        return RepositoryDomandeHolder.INSTANCE;
    }

    public ArrayList<Domanda> getDomande() {
        return domande;
    }
    
    public Domanda getDomandaWhereIdIs(int id){
        for (Domanda d : domande)
            if (id == d.getId())
                return d;
        
        return null;
    }
    
    private static class RepositoryDomandeHolder {
        private static final RepositoryDomande INSTANCE = new RepositoryDomande();
    }
    
    
}
