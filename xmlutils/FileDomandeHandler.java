package guiz.xmlutils;

import guiz.GUIzUtils;
import guiz.SettingsRepository;
import guiz.modelli.Domanda;
import guiz.modelli.Domanda.Difficolta;
import guiz.modelli.DomandaATempo;
import guiz.modelli.DomandaChiusa;
import guiz.modelli.DomandaPerdiTutto;
import guiz.modelli.OpzioneDomandaChiusa;
import java.io.File;
import java.io.PrintWriter;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class FileDomandeHandler extends XMLHandler {
    public FileDomandeHandler(String filePath) {
        super.init(filePath);
    }

    @Override
    protected void initXMLFile() throws Exception {
        try (PrintWriter out = new PrintWriter(new File(filePath))) {
            out.print("<domande></domande>");
            out.close();
        }
    }
    
    private DomandaChiusa estraiDomandaChiusa(Node node) {
        NodeList proprietaDomandaChiusa = node.getChildNodes();
        DomandaChiusa domandaChiusa = new DomandaChiusa();
        domandaChiusa.setDifficolta(Difficolta.sconosciuta);
        for (int j = 0; j < proprietaDomandaChiusa.getLength(); j++) {
            Node proprieta = proprietaDomandaChiusa.item(j);
            if (!"difficolta".equals(proprieta.getNodeName()) && !"id".equals(proprieta.getNodeName()) && !"testo".equals(proprieta.getNodeName()) && !"opzioni".equals(proprieta.getNodeName())) {
                continue;
            }

            if ("id".equals(proprieta.getNodeName())) {
                domandaChiusa.setId(Long.parseLong(proprieta.getFirstChild().getNodeValue()));
            }

            if ("testo".equals(proprieta.getNodeName())) {
                domandaChiusa.setTesto(proprieta.getFirstChild().getNodeValue());
            }
            
            if ("difficolta".equals(proprieta.getNodeName())) {
                String testoDifficolta = proprieta.getFirstChild().getNodeValue();
                
                domandaChiusa.setDifficolta(GUIzUtils.estraiDifficolta(testoDifficolta));
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
        domandaATempo.setDifficolta(Difficolta.sconosciuta);
        
        for (int k = 0; k < proprietaDomandaATempo.getLength(); k++) {
            Node proprieta = proprietaDomandaATempo.item(k);
            if (!"difficolta".equals(proprieta.getNodeName()) && !"id".equals(proprieta.getNodeName()) && !"tempo".equals(proprieta.getNodeName()) && !"testo".equals(proprieta.getNodeName()) && !"risposta".equals(proprieta.getNodeName())) {
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
            
                        
            if ("difficolta".equals(proprieta.getNodeName())) {
                String testoDifficolta = proprieta.getFirstChild().getNodeValue();
                
                domandaATempo.setDifficolta(GUIzUtils.estraiDifficolta(testoDifficolta));
            }
        }

        return domandaATempo;
    }

    private DomandaPerdiTutto estraiDomandaPerdiTutto(Node node) {
        NodeList proprietaDomandaPerdiTutto = node.getChildNodes();
        DomandaPerdiTutto domandaPerdiTutto = new DomandaPerdiTutto();
        domandaPerdiTutto.setDifficolta(Difficolta.sconosciuta);
        
        for (int k = 0; k < proprietaDomandaPerdiTutto.getLength(); k++) {
            Node proprieta = proprietaDomandaPerdiTutto.item(k);
            if (!"difficolta".equals(proprieta.getNodeName()) && !"id".equals(proprieta.getNodeName()) && !"testo".equals(proprieta.getNodeName()) && !"risposta".equals(proprieta.getNodeName())) {
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
            
            if ("difficolta".equals(proprieta.getNodeName())) {
                String testoDifficolta = proprieta.getFirstChild().getNodeValue();
                
                domandaPerdiTutto.setDifficolta(GUIzUtils.estraiDifficolta(testoDifficolta));
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
        Element difficolta = doc.createElement("difficolta");
        difficolta.appendChild(doc.createTextNode(domanda.getDifficolta().toString()));
        
        nuovaDomanda.appendChild(id);
        nuovaDomanda.appendChild(testo);       
        nuovaDomanda.appendChild(difficolta);
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

    
}
