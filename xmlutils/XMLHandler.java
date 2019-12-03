package guiz.xmlutils;

import guiz.SettingsRepository;
import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;

public abstract class XMLHandler {

    protected String filePath;
    protected Document doc;

    protected void salva() {

        try {
            TransformerFactory transformerFactory = TransformerFactory
                    .newInstance(); //Crea un oggetto factory, che serve per creare altri oggetti (è un design pattern)
            Transformer transformer = transformerFactory.newTransformer();
            /*crea un Transformer attraverso la factory.
            Un oggetto Transformer serve a trasformare un oggetto tree-based (ad esempio un oggetto per gestire xml) 
            verso una sorgente di diverso tipo. In questo caso, un file di testo viene usato per convertire il documento XML in un file di testo  */
            transformer.setOutputProperty(OutputKeys.INDENT, "yes"); //Imposta l'indentazione del file e lo stile da usare (in questo caso, XML)
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "5");

            DOMSource source = new DOMSource(doc); //Imposta un oggetto per gestire l'oggetto astratto (doc) come documento XML DOM, ovvero da leggere tramite un parser di tipo DOM (l'alternativa è un parser di tipo SAX)
            StreamResult result = new StreamResult(new File(filePath));
            /*StreamResult è un oggetto praticamente fatto ad-hoc per questo tipo di trasformazioni. 
                Citando dalla documentazione ufficiale: "Funge da  holder per il risultato di una trasformazione, la quale può riguardare, XML, testo, HTML o qualunque altro linguaggio/forma di markup"*/
            transformer.transform(source, result); //mappa il DOM document creato al result

        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
    }

    /* Serve ad inizializzare il file XML. E' astratto perchè dipende dall'implementazione (quello delle domande metterà un tag domande, quello delle impostazioni ne metterà altri ecc.) */
    protected abstract void initXMLFile() throws Exception;

    protected void init(String filePath) {
        this.filePath = filePath;
        try {
            File baseDir = new File(SettingsRepository.getSaveUrl());

            if (!baseDir.exists()) { //Crea la directory di base se non esiste
                baseDir.mkdir();
            }

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance(); /*Crea l'oggetto per costruire un XML Document a partire da un file. Il DocumentBuilder si occupa di fare il parsing
            del file XML, e per averlo bisogna usare il suo apposito Factory (DocumentBuilderFactory) */            
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            File file = new File(filePath); /* Crea e/o inizializza, gestendo i casi in cui non esiste o è vuoto */
            if (!file.exists()) {
                file.createNewFile();
                initXMLFile();
            } else {
                if (file.length() == 0) {
                    initXMLFile();
                }
            }
            doc = dBuilder.parse(file); //Crea l'oggetto che gestisce il documento XML, facendo il parsing del file
            doc.getDocumentElement().normalize(); //Gestisce il caricamento/salvataggio di tipi di dato particolari, scongiurando problemi in fase di caricamento o reloading 
        } catch (Exception ex) {
        }
    }
}
