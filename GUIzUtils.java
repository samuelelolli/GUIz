package guiz;

import guiz.modelli.Domanda;
import guiz.modelli.OpzioneDomandaChiusa;
import guiz.modelli.Utente;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GUIzUtils {

    public static String formatOpzioni(ArrayList<OpzioneDomandaChiusa> opzioni) {
        StringBuilder builderOpzioni = new StringBuilder("");
        for (OpzioneDomandaChiusa opzione : opzioni) {
            builderOpzioni.append(opzione.getTesto());
            builderOpzioni.append(" - ");
            builderOpzioni.append(opzione.isEsatta() ? "corretta" : "sbagliata");
            if (!opzione.equals(opzioni.get(opzioni.size() - 1))) {
                builderOpzioni.append(", ");
            }
        }

        return builderOpzioni.toString();
    }

    public static String formatTempo(Duration d) {
        long durataSecondi = d.toMillis() / 1000;
        return String.valueOf(durataSecondi + " second" + (durataSecondi > 1 ? "i" : "o"));
    }

    public static Domanda.Difficolta estraiDifficolta(String value) {
        switch (value) {
            case "facile":
                return Domanda.Difficolta.facile;

            case "media":
                return Domanda.Difficolta.media;

            case "difficile":
                return Domanda.Difficolta.difficile;
        }

        return Domanda.Difficolta.sconosciuta;
    }

    public static List<Utente> orderByPoints(List<Utente> u) {
        ArrayList utenti = new ArrayList<>(u);

        Comparator comparator = new Comparator<Utente>() {
            @Override
            public int compare(Utente u1, Utente u2) {
                if (u1.getPunteggio() > u2.getPunteggio())
                    return -1;
                else
                    if (u1.getPunteggio() == u2.getPunteggio())
                        return 0;
                    else
                        return 1;
            }
        };
        
        utenti.sort(comparator);
        
        return utenti;
    }
}
