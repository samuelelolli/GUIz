package guiz;

import guiz.modelli.Domanda;
import java.util.ArrayList;
import guiz.xmlutils.LettoreXMLDomande;

public class RepositoryDomande {
    private final ArrayList<Domanda> domande;
    
    private RepositoryDomande() {
        LettoreXMLDomande lettore = new LettoreXMLDomande("C:\\GUIz\\domande.xml");
        domande = lettore.leggiDomande();
    }
    
    public static RepositoryDomande getInstance() {
        return RepositoryDomandeHolder.INSTANCE;
    }

    public ArrayList<Domanda> getDomande() {
        return domande;
    }
    
    private static class RepositoryDomandeHolder {
        private static final RepositoryDomande INSTANCE = new RepositoryDomande();
    }
    
    
}
