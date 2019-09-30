package guiz.xmlutils;

import guiz.modelli.Domanda;
import guiz.modelli.DomandaATempo;
import guiz.modelli.DomandaChiusa;
import guiz.modelli.DomandaPerdiTutto;
import guiz.modelli.OpzioneDomandaChiusa;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class XMLHandler {

    private String filePath;
    private Document doc;

    public XMLHandler(String filePath) {
        this.filePath = filePath;
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            File file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
                initXMLFile();
            } else {
                if (file.length() == 0) {
                    initXMLFile();
                }
            }
            doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();
        } catch (Exception ex) {
        }
    }

    private void initXMLFile() throws Exception {
        try (PrintWriter out = new PrintWriter(new File(filePath))) {
            out.print("<domande></domande>");
            out.close();
        }
    }

    private DomandaChiusa estraiDomandaChiusa(Node node) {
        NodeList proprietaDomandaChiusa = node.getChildNodes();
        DomandaChiusa domandaChiusa = new DomandaChiusa();
        for (int j = 0; j < proprietaDomandaChiusa.getLength(); j++) {
            Node proprieta = proprietaDomandaChiusa.item(j);
            if (!"id".equals(proprieta.getNodeName()) && !"testo".equals(proprieta.getNodeName()) && !"opzioni".equals(proprieta.getNodeName())) {
                continue;
            }

            if ("id".equals(proprieta.getNodeName())) {
                domandaChiusa.setId(Long.parseLong(proprieta.getFirstChild().getNodeValue()));
            }

            if ("testo".equals(proprieta.getNodeName())) {
                domandaChiusa.setTesto(proprieta.getFirstChild().getNodeValue());
            }

            if ("opzioni".equals(proprieta.getNodeName())) {
                NodeList opzioniDomandaChiusa = proprieta.getChildNodes();
                for (int k = 0; k < opzioniDomandaChiusa.getLength(); k++) {
                    Node nodoOpzione = opzioniDomandaChiusa.item(k);
                    if (!"opzione".equals(nodoOpzione.getNodeName())) {
                        continue;
                    }

                    String nomeOpzione = nodoOpzione.getFirstChild().getNodeValue();
                    boolean giusta = "si".equals(((Element) nodoOpzione).getAttribute("giusta"));

                    OpzioneDomandaChiusa opzione = new OpzioneDomandaChiusa(nomeOpzione, giusta);
                    domandaChiusa.getOpzioni().add(opzione);
                }

            }
        }

        return domandaChiusa;
    }

    private DomandaATempo estraiDomandaATempo(Node node) {
        NodeList proprietaDomandaATempo = node.getChildNodes();
        DomandaATempo domandaATempo = new DomandaATempo();
        for (int k = 0; k < proprietaDomandaATempo.getLength(); k++) {
            Node proprieta = proprietaDomandaATempo.item(k);
            if (!"id".equals(proprieta.getNodeName()) && !"tempo".equals(proprieta.getNodeName()) && !"testo".equals(proprieta.getNodeName()) && !"risposta".equals(proprieta.getNodeName())) {
                continue;
            }

            if ("id".equals(proprieta.getNodeName())) {
                domandaATempo.setId(Long.parseLong(proprieta.getFirstChild().getNodeValue()));
            }

            if ("tempo".equals(proprieta.getNodeName())) {
                long durata = Long.parseLong(proprieta.getFirstChild().getNodeValue());
                domandaATempo.setTempo(Duration.ofMillis(durata));
            }

            if ("testo".equals(proprieta.getNodeName())) {
                domandaATempo.setTesto(proprieta.getFirstChild().getNodeValue());
            }

            if ("risposta".equals(proprieta.getNodeName())) {
                domandaATempo.setRisposta(proprieta.getFirstChild().getNodeValue());
            }
        }

        return domandaATempo;
    }

    private DomandaPerdiTutto estraiDomandaPerdiTutto(Node node) {
        NodeList proprietaDomandaPerdiTutto = node.getChildNodes();
        DomandaPerdiTutto domandaPerdiTutto = new DomandaPerdiTutto();
        for (int k = 0; k < proprietaDomandaPerdiTutto.getLength(); k++) {
            Node proprieta = proprietaDomandaPerdiTutto.item(k);
            if (!"id".equals(proprieta.getNodeName()) && !"testo".equals(proprieta.getNodeName()) && !"risposta".equals(proprieta.getNodeName())) {
                continue;
            }

            if ("id".equals(proprieta.getNodeName())) {
                domandaPerdiTutto.setId(Long.parseLong(proprieta.getFirstChild().getNodeValue()));
            }

            if ("testo".equals(proprieta.getNodeName())) {
                domandaPerdiTutto.setTesto(proprieta.getFirstChild().getNodeValue());
            }

            if ("risposta".equals(proprieta.getNodeName())) {
                domandaPerdiTutto.setRisposta(proprieta.getFirstChild().getNodeValue());
            }
        }

        return domandaPerdiTutto;
    }

    public ArrayList<Domanda> leggiDomande() {
        ArrayList<Domanda> domande = new ArrayList<>();
        NodeList nList = doc.getElementsByTagName("domanda");
        for (int i = 0; i < nList.getLength(); i++) {
            Node node = nList.item(i);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                String tipo = element.getAttribute("tipo");

                switch (tipo) {
                    case DomandaChiusa.labelTipo:
                        domande.add(estraiDomandaChiusa(node));
                        break;

                    case DomandaPerdiTutto.labelTipo:
                        domande.add(estraiDomandaPerdiTutto(node));
                        break;

                    case DomandaATempo.labelTipo:
                        domande.add(estraiDomandaATempo(node));
                        break;
                }
            }
        }

        return domande;
    }

    private void aggiungiDomandaADocument(Domanda domanda) {
        Element nuovaDomanda = doc.createElement("domanda");

        Element id = doc.createElement("id");
        id.appendChild(doc.createTextNode(String.valueOf(domanda.getId())));
        Element testo = doc.createElement("testo");
        testo.appendChild(doc.createTextNode(domanda.getTesto()));

        nuovaDomanda.appendChild(id);
        nuovaDomanda.appendChild(testo);
        nuovaDomanda.setAttribute("tipo", domanda.getTipo());

        if (domanda instanceof DomandaChiusa) {
            Element opzioni = doc.createElement("opzioni");
            for (OpzioneDomandaChiusa opzione : ((DomandaChiusa) domanda).getOpzioni()) {
                Element nodoOpzione = doc.createElement("opzione");
                nodoOpzione.setAttribute("giusta", opzione.isEsatta() ? "si" : "no");
                nodoOpzione.appendChild(doc.createTextNode(opzione.getTesto()));
                opzioni.appendChild(nodoOpzione);
            }

            nuovaDomanda.appendChild(opzioni);
        }

        if (domanda instanceof DomandaPerdiTutto) {
            Element risposta = doc.createElement("risposta");
            risposta.appendChild(doc.createTextNode(((DomandaPerdiTutto) domanda).getRisposta()));

            nuovaDomanda.appendChild(risposta);
        }

        if (domanda instanceof DomandaATempo) {
            Element risposta = doc.createElement("risposta");
            risposta.appendChild(doc.createTextNode(((DomandaATempo) domanda).getRisposta()));
            Element tempo = doc.createElement("tempo");
            tempo.appendChild(doc.createTextNode(String.valueOf(((DomandaATempo) domanda).getTempo().toMillis())));

            nuovaDomanda.appendChild(risposta);
            nuovaDomanda.appendChild(tempo);
        }

        doc.getFirstChild().appendChild(nuovaDomanda);
    }

    public void aggiungiDomanda(Domanda domanda) throws Exception {
        aggiungiDomandaADocument(domanda);
        salva();
    }

    public void aggiungiDomande(List<Domanda> domande) throws Exception {
        for (Domanda d : domande) {
            aggiungiDomandaADocument(d);
        }
        salva();
    }

    public void rimuoviDomanda(long id) {
        NodeList nList = doc.getElementsByTagName("id");
        for (int i = 0; i < nList.getLength(); i++) {
            Node node = nList.item(i);

            if (Long.parseLong(node.getFirstChild().getNodeValue()) == id) {
                node.getParentNode().getParentNode().removeChild(node.getParentNode());
                salva();
                return;
            }
        }
    }

    public void modificaDomanda(Domanda d) throws Exception {
        rimuoviDomanda(d.getId());
        aggiungiDomanda(d);
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

        } catch (Exception ignored) {
            ignored.printStackTrace();
        }
    }
}
