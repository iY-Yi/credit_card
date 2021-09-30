package creditcard;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.*;

public class FileHandlerXml extends FileAbstract{
    public List<CardInfo> readFile(String fileName) {
        List<CardInfo> records = new ArrayList();
        try {
            File file = new File(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);

            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("row");
            for (int i=0; i < nList.getLength(); i++) {
                Node node = nList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;
                    String number = element.getElementsByTagName("CardNumber").item(0).getTextContent();
                    number = number.replaceAll("\\s", "");
                    String exp = element.getElementsByTagName("ExpirationDate").item(0).getTextContent();
                    exp = exp.replaceAll("\\s", "");
                    String name = element.getElementsByTagName("NameOfCardholder").item(0).getTextContent();
                    CardInfo record = new CardInfo(number, exp, name);
                    records.add(record);
                }
            }

        } catch (Exception err) {
            System.out.println(err);
            System.out.println("File read error.");
        }
        return records;
    }

    public void writeFile(List<CreditCard> cards, String fileName) {
        try {
            File file = new File(fileName);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.newDocument();

            Element root = doc.createElement("root");
            doc.appendChild(root);

            ListIterator<CreditCard> it = cards.listIterator();
            while (it.hasNext()) {
                CreditCard card = it.next();
                Element row = doc.createElement("row");
                root.appendChild(row);

                Element number = doc.createElement("CardNumber");
                number.appendChild(doc.createTextNode(card.getNumber()));
                row.appendChild(number);

                Element type = doc.createElement("CardType");
                type.appendChild(doc.createTextNode(card.getType()));
                row.appendChild(type);

                if (card.getType() == "Invalid") {
                    Element error = doc.createElement("Error");
                    error.appendChild(doc.createTextNode("Invalid"));
                    row.appendChild(error);
                }
            }
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty(OutputKeys.METHOD, "xml");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            DOMSource domSource = new DOMSource(doc);
            StreamResult streamResult = new StreamResult(file);
            transformer.transform(domSource, streamResult);

            System.out.println("File write is completed.");
        } catch (ParserConfigurationException e) {
            System.out.println("File write error: ParseConfiguration.");
        } catch (TransformerException e) {
            System.out.println(e);
            System.out.println("File write error: Transformer.");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("File write error.");
        }
    }
}
