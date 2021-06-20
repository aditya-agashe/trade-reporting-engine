package au.com.vanguard.tradereportingengine.parser;

import au.com.vanguard.tradereportingengine.model.Event;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class XMLParserTest {

    private XMLParser xmlParser;

    private Event event;

    @BeforeEach
    void setUp() {
        xmlParser = new XMLParser();
    }

    @Test
    void shouldReturnCorrectBuyerParty() {
        event = xmlParser.process("src/test/resources/eventXML/eventCorrect.xml");
        Assertions.assertEquals("LEFT_BANK", event.getBuyerParty());
    }

    @Test
    void shouldReturnEmptyBuyerParty_NoAttribute() {
        event = xmlParser.process("src/test/resources/eventXML/eventNoAttribute.xml");
        Assertions.assertEquals("", event.getBuyerParty());
    }

    @Test
    void shouldReturnEmptyBuyerParty_NoElement() {
        event = xmlParser.process("src/test/resources/eventXML/eventNoElement.xml");
        Assertions.assertEquals("", event.getBuyerParty());
    }

    @Test
    void shouldReturnEmptyBuyerParty_NoSuchFile() {
        event = xmlParser.process("src/test/resources/eventXML/randomFileDoesNotExist.xml");
        Assertions.assertEquals("", event.getBuyerParty());
    }

    @Test
    void shouldReturnCorrectSellerParty() {
        event = xmlParser.process("src/test/resources/eventXML/eventCorrect.xml");
        Assertions.assertEquals("EMU_BANK", event.getSellerParty());
    }

    @Test
    void shouldReturnEmptySellerParty_NoAttribute() {
        event = xmlParser.process("src/test/resources/eventXML/eventNoAttribute.xml");
        Assertions.assertEquals("", event.getSellerParty());
    }

    @Test
    void shouldReturnEmptySellerParty_NoElement() {
        event = xmlParser.process("src/test/resources/eventXML/eventNoElement.xml");
        Assertions.assertEquals("", event.getSellerParty());
    }

    @Test
    void shouldReturnEmptySellerParty_NoSuchFile() {
        event = xmlParser.process("src/test/resources/eventXML/randomFileDoesNotExist.xml");
        Assertions.assertEquals("", event.getSellerParty());
    }

    @Test
    void shouldReturnCorrectAmount() {
        event = xmlParser.process("src/test/resources/eventXML/eventCorrect.xml");
        Assertions.assertEquals("100.00", event.getAmount());
    }

    @Test
    void shouldReturnEmptyAmount_NoElement() {
        event = xmlParser.process("src/test/resources/eventXML/eventNoElement.xml");
        Assertions.assertEquals("", event.getAmount());
    }

    @Test
    void shouldReturnEmptyAmount_NoSuchFile() {
        event = xmlParser.process("src/test/resources/eventXML/randomFileDoesNotExist.xml");
        Assertions.assertEquals("", event.getAmount());
    }

    @Test
    void shouldReturnCorrectCurrency() {
        event = xmlParser.process("src/test/resources/eventXML/eventCorrect.xml");
        Assertions.assertEquals("AUD", event.getCurrency());
    }

    @Test
    void shouldReturnEmptyCurrency_NoElement() {
        event = xmlParser.process("src/test/resources/eventXML/eventNoElement.xml");
        Assertions.assertEquals("", event.getCurrency());
    }

    @Test
    void shouldReturnEmptyCurrency_NoSuchFile() {
        event = xmlParser.process("src/test/resources/eventXML/randomFileDoesNotExist.xml");
        Assertions.assertEquals("", event.getCurrency());
    }

}