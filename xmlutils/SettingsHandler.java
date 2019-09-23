package guiz.xmlutils;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
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

public class SettingsHandler {

    private String filePath;
    private Document doc;

    public SettingsHandler(String filePath) {
        this.filePath = filePath;
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
                try (PrintWriter out = new PrintWriter(file)) {
                    out.print("<impostazioni><domande_a_partita>10</domande_a_partita><utente_sceglie_domande_a_partita>no</utente_sceglie_domande_a_partita></impostazioni>");
                }
            }
            doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
        } catch (IOException | ParserConfigurationException | SAXException ex) {
        }
    }

    public Boolean puoScegliereDomandeAPartita() {
        NodeList nList = doc.getElementsByTagName("utente_sceglie_domande_a_partita");
        if (nList.getLength() <= 0) {
            return null;
        }

        Node node = nList.item(0);

        return "si".equals(node.getFirstChild().getNodeValue());
    }

    public Integer domandeAPartita() {
        NodeList nList = doc.getElementsByTagName("domande_a_partita");
        if (nList.getLength() <= 0) {
            return null;
        }

        Node node = nList.item(0);
        return Integer.parseInt(node.getFirstChild().getNodeValue());
    }

    public void modificaPuoScegliereDomandeAPartita(boolean b) {
        NodeList nList = doc.getElementsByTagName("utente_sceglie_domande_a_partita");
        if (nList.getLength() <= 0) {
            return;
        }

        nList.item(0).getFirstChild().setNodeValue(b ? "si" : "no");
        salva();
    }

    public void modificaDomandaAPartita(int n) {
        NodeList nList = doc.getElementsByTagName("domande_a_partita");
        if (nList.getLength() <= 0) {
            return;
        }

        nList.item(0).getFirstChild().setNodeValue(String.valueOf(n));
        salva();
    }

    private void salva() {

        try {
            TransformerFactory transformerFactory = TransformerFactory
                    .newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "5");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filePath));
            transformer.transform(source, result);

        } catch (IllegalArgumentException | TransformerException ignored) {
        }
    }

}
