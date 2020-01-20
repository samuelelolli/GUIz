package guiz;

import guiz.xmlutils.SettingsHandler;
import java.awt.Component;

public class SettingsRepository {

    public static final String baseSaveUrl = System.getProperty("user.home");
    public static final String saveDirectory = "Documents\\GUIz\\";

    private static final SettingsRepository INSTANCE = new SettingsRepository();

    SettingsHandler handler = new SettingsHandler(getSaveUrl() + "impostazioni.xml");

    int domandePerUtente;
    boolean puoModificareDomandePerUtente;

    private SettingsRepository() {
    }

    public static SettingsRepository getInstance() {
        return INSTANCE;
    }

    public Boolean puoScegliereDomandePerUtente() {
        return handler.puoScegliereDomandePerUtente();
    }

    public Integer domandePerUtente() {
        return handler.domandePerUtente();
    }

    public void modificaPuoScegliereDomandePerUtente(boolean puoScegliere) {
        this.puoModificareDomandePerUtente = puoScegliere;
        handler.modificaPuoScegliereDomandePerUtente(puoScegliere);
    }

    public void modificaDomandePerUtente(int numeroDomande) {
        this.domandePerUtente = numeroDomande;
        handler.modificaDomandePerUtente(numeroDomande);
    }

    public void importaDomande(Component caller) throws Exception {
        handler.importaDomande(caller);
    }

    public static String getSaveUrl() {
        return baseSaveUrl + "\\" + saveDirectory;
    }
}
