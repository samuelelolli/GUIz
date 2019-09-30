package guiz;

import guiz.modelli.OpzioneDomandaChiusa;
import java.time.Duration;
import java.util.ArrayList;

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
    
    public static String formatTempo(Duration d){
        long durataSecondi = d.toMillis() / 1000;
        return String.valueOf(durataSecondi + " second" + (durataSecondi > 1 ? "i" : "o"));
    }
}
