/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiz;

import guiz.xmlutils.SettingsHandler;
import java.awt.Component;

public class SettingsRepository {
    public static final String baseSaveUrl = System.getProperty("user.home");
    public static final String saveDirectory = "Documents\\GUIz\\";
    
    private static final SettingsRepository INSTANCE = new SettingsRepository();
    
    SettingsHandler handler = new SettingsHandler(getSaveUrl() + "impostazioni.xml");
    
    int domandeAPartita;
    boolean puoModificareDomandeAPartita;
    
    private SettingsRepository() {
    }
    
    public static SettingsRepository getInstance() {
        return INSTANCE;
    }
    
    public Boolean puoScegliereDomandeAPartita(){
        return handler.puoScegliereDomandeAPartita();
    }
    
    public Integer domandeAPartita(){
        return handler.domandeAPartita();
    }
    
    public void modificaPuoScegliereDomandeAPartita(boolean puoScegliere){
        this.puoModificareDomandeAPartita = puoScegliere;
        handler.modificaPuoScegliereDomandeAPartita(puoScegliere);
    }
    
    public void modificaDomandaAPartita(int numeroDomande){
        this.domandeAPartita = numeroDomande;
        handler.modificaDomandaAPartita(numeroDomande);
    }
    
    public void importaDomande(Component caller) throws Exception{
        handler.importaDomande(caller);
    }
    
    public String getSaveUrl(){
        return baseSaveUrl + "\\" + saveDirectory;
    }
}
