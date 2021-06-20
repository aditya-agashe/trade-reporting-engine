package au.com.vanguard.tradereportingengine.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class XMLParserTest {

    private XMLParser xmlParser;
    @BeforeEach
    void setUp() {
    }

    @Test
    void shouldReturnCorrectBuyerParty() {
        xmlParser = new XMLParser("src/test/resources/eventXML/eventCorrect.xml");
        Assertions.assertEquals("LEFT_BANK", xmlParser.getBuyerParty());
    }

    @Test
    void shouldReturnEmptyBuyerParty_NoAttribute() {
        xmlParser = new XMLParser("src/test/resources/eventXML/eventNoAttribute.xml");
        Assertions.assertEquals("", xmlParser.getBuyerParty());
    }

    @Test
    void shouldReturnEmptyBuyerParty_NoElement() {
        xmlParser = new XMLParser("src/test/resources/eventXML/eventNoElement.xml");
        Assertions.assertEquals("", xmlParser.getBuyerParty());
    }

    @Test
    void shouldReturnEmptyBuyerParty_NoSuchFile() {
        xmlParser = new XMLParser("src/test/resources/eventXML/randomFileDoesNotExist.xml");
        Assertions.assertEquals("", xmlParser.getBuyerParty());
    }

    @Test
    void shouldReturnCorrectSellerParty() {
        xmlParser = new XMLParser("src/test/resources/eventXML/eventCorrect.xml");
        Assertions.assertEquals("EMU_BANK", xmlParser.getSellerParty());
    }

    @Test
    void shouldReturnEmptySellerParty_NoAttribute() {
        xmlParser = new XMLParser("src/test/resources/eventXML/eventNoAttribute.xml");
        Assertions.assertEquals("", xmlParser.getSellerParty());
    }

    @Test
    void shouldReturnEmptySellerParty_NoElement() {
        xmlParser = new XMLParser("src/test/resources/eventXML/eventNoElement.xml");
        Assertions.assertEquals("", xmlParser.getSellerParty());
    }

    @Test
    void shouldReturnEmptySellerParty_NoSuchFile() {
        xmlParser = new XMLParser("src/test/resources/eventXML/randomFileDoesNotExist.xml");
        Assertions.assertEquals("", xmlParser.getSellerParty());
    }

    @Test
    void shouldReturnCorrectAmount() {
        xmlParser = new XMLParser("src/test/resources/eventXML/eventCorrect.xml");
        Assertions.assertEquals("100.00", xmlParser.getAmount());
    }

    @Test
    void shouldReturnEmptyAmount_NoElement() {
        xmlParser = new XMLParser("src/test/resources/eventXML/eventNoElement.xml");
        Assertions.assertEquals("", xmlParser.getAmount());
    }

    @Test
    void shouldReturnEmptyAmount_NoSuchFile() {
        xmlParser = new XMLParser("src/test/resources/eventXML/randomFileDoesNotExist.xml");
        Assertions.assertEquals("", xmlParser.getAmount());
    }

    @Test
    void shouldReturnCorrectCurrency() {
        xmlParser = new XMLParser("src/test/resources/eventXML/eventCorrect.xml");
        Assertions.assertEquals("AUD", xmlParser.getCurrency());
    }

    @Test
    void shouldReturnEmptyCurrency_NoElement() {
        xmlParser = new XMLParser("src/test/resources/eventXML/eventNoElement.xml");
        Assertions.assertEquals("", xmlParser.getCurrency());
    }

    @Test
    void shouldReturnEmptyCurrency_NoSuchFile() {
        xmlParser = new XMLParser("src/test/resources/eventXML/randomFileDoesNotExist.xml");
        Assertions.assertEquals("", xmlParser.getCurrency());
    }
}