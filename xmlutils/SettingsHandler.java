package guiz.xmlutils;

import guiz.RepositoryDomande;
import guiz.SettingsRepository;
import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class SettingsHandler extends XMLHandler {

    public SettingsHandler(String filePath) {
        super.init(filePath);
    }

    @Override
    protected void initXMLFile() throws Exception {
        try (PrintWriter out = new PrintWriter(new File(filePath))) {
            out.print("<impostazioni><domande_per_utente>10</domande_per_utente><utente_sceglie_domande_per_utente>no</utente_sceglie_domande_per_utente></impostazioni>");
            out.close();
        }
    }

    public Boolean puoScegliereDomandePerUtente() {
        NodeList nList = doc.getElementsByTagName("utente_sceglie_domande_per_utente");
        if (nList.getLength() <= 0) {
            return null;
        }

        Node node = nList.item(0);

        return "si".equals(node.getFirstChild().getNodeValue());
    }

    public Integer domandePerUtente() {
        NodeList nList = doc.getElementsByTagName("domande_per_utente");
        if (nList.getLength() <= 0) {
            return null;
        }

        Node node = nList.item(0);
        return Integer.parseInt(node.getFirstChild().getNodeValue());
    }

    public void modificaPuoScegliereDomandePerUtente(boolean b) {
        NodeList nList = doc.getElementsByTagName("utente_sceglie_domande_per_utente");
        if (nList.getLength() <= 0) {
            return;
        }

        nList.item(0).getFirstChild().setNodeValue(b ? "si" : "no");
        salva();
    }

    public void modificaDomandePerUtente(int n) {
        NodeList nList = doc.getElementsByTagName("domande_per_utente");
        if (nList.getLength() <= 0) {
            return;
        }

        nList.item(0).getFirstChild().setNodeValue(String.valueOf(n));
        salva();
    }

    public void importaDomande(Component caller) throws Exception {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("XML FILES", "xml", "xml");
        fileChooser.setFileFilter(filter);
        fileChooser.showOpenDialog(caller);

        File f = fileChooser.getSelectedFile();
        FileDomandeHandler xmlHandler = new FileDomandeHandler(f.getAbsolutePath());
        RepositoryDomande.getInstance().aggiungiDomande(xmlHandler.leggiDomande());
    }
}
