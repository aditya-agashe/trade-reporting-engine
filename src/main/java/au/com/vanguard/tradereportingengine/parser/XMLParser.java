package au.com.vanguard.tradereportingengine.parser;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import au.com.vanguard.tradereportingengine.model.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.*;
import org.xml.sax.SAXException;
import java.io.File;
import java.io.IOException;

public class XMLParser implements Parser {

    Logger logger = LoggerFactory.getLogger(XMLParser.class);

    private File inputFile;

    public Event process(String pathToXML) {
        this.inputFile = new File(pathToXML);
        return new Event.Builder()
                .withId(-1)
                .withBuyerParty(getBuyerParty())
                .withSellerParty(getSellerParty())
                .withAmount(getAmount())
                .withCurrency(getCurrency())
                .build();
    }

    private String getBuyerParty() {
        return getValueByXPath("//buyerPartyReference/@href", "attribute");
    }

    private String getSellerParty() {
        return getValueByXPath("//sellerPartyReference/@href", "attribute");
    }

    private String getAmount() {
        return getValueByXPath("//paymentAmount/amount", "element");
    }

    private String getCurrency() {
        return getValueByXPath("//paymentAmount/currency", "element");
    }

    private String getValueByXPath(String expression, String nodeType) {
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder;

        try {
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();

            XPath xPath =  XPathFactory.newInstance().newXPath();

            NodeList nodeList = (NodeList) xPath.compile(expression).evaluate(
                    doc, XPathConstants.NODESET);
            if (nodeList != null && nodeList.getLength() > 0) {
                String value;
                if ("attribute".equals(nodeType)) {
                    Attr e = (Attr) nodeList.item(0);
                    value = e.getTextContent();
                } else {
                    Element e = (Element) nodeList.item(0);
                    value = e.getTextContent();
                }
                return value;
            } else {
                return "";
            }
        } catch (ParserConfigurationException | IOException | SAXException | XPathExpressionException e) {
            logger.error("Error occurred while processing file: {} ", inputFile.getAbsolutePath(), e);
        }

        return "";
    }

}
