package guiz;

import guiz.modelli.Domanda;
import java.util.ArrayList;
import guiz.xmlutils.FileDomandeHandler;
import java.awt.Component;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import javax.swing.JFileChooser;

public class RepositoryDomande {

    private static RepositoryDomande INSTANCE;
    private final ArrayList<Domanda> domande;
    private FileDomandeHandler handler;

    private RepositoryDomande() {        
        String saveUrl = SettingsRepository.getSaveUrl() + "domande.xml";
        
        handler = new FileDomandeHandler(saveUrl);
        domande = handler.leggiDomande();
        domande.sort((Domanda d1, Domanda d2) -> {
            Long id1 = d1.getId(), id2 = d2.getId();
            return id1.compareTo(id2);
        });
    }

    private long idDaInserire() {
        if (domande.isEmpty()) {
            return 1;
        }

        long max = domande.get(0).getId();

        for (Domanda d : domande) {
            if (d.getId() > max) {
                max = d.getId();
            }
        }

        return max + 1;
    }

    public void aggiungiDomanda(Domanda domanda) throws Exception {
        domanda.setId(idDaInserire());
        domande.add(domanda);
        handler.aggiungiDomanda(domanda);
    }

    public void aggiungiDomande(List<Domanda> domandeDaAggiungere) throws Exception {
        long idDaInserire = idDaInserire();
        for (Domanda d : domandeDaAggiungere) {
            d.setId(idDaInserire++);
            domande.add(d);
        }
        handler.aggiungiDomande(domande);
    }

    public void rimuoviDomanda(Domanda domanda) {
        domande.remove(domanda);
        handler.rimuoviDomanda(domanda.getId());
    }

    public void modificaDomanda(Domanda domanda) throws Exception {
        Domanda toUpdate = getDomandaWhereIdIs(domanda.getId());
        if (toUpdate == null) {
            return;
        }

        handler.modificaDomanda(domanda);
        domande.remove(toUpdate);
        domande.add(domanda);
    }

    public static RepositoryDomande getInstance() {
        if (INSTANCE != null) {
            return INSTANCE;
        }

        INSTANCE = new RepositoryDomande();
        return INSTANCE;
    }

    public ArrayList<Domanda> getDomande() {
        return domande;
    }

    public Domanda getDomandaWhereIdIs(long id) {
        for (Domanda d : domande) {
            if (id == d.getId()) {
                return d;
            }
        }

        return null;
    }
    
    public void esporta(Component caller) throws Exception {
        String saveUrl = SettingsRepository.getSaveUrl() + "domande.xml";
        
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.showOpenDialog(caller);
        File dstDir = chooser.getSelectedFile();
        File dstFile = new File(dstDir.getAbsolutePath() + "\\GUIz_export.xml");
        if (!dstFile.exists()) dstFile.createNewFile();
        Files.copy(Paths.get(saveUrl), Paths.get(dstFile.getAbsolutePath()), StandardCopyOption.REPLACE_EXISTING);
    }
}