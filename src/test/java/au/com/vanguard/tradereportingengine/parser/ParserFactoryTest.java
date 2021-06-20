package au.com.vanguard.tradereportingengine.parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ParserFactoryTest {
    private ParserFactory parserFactory;

    @BeforeEach
    void setUp() {
        parserFactory = new ParserFactory();
    }

    @Test
    void shouldReturnXMLParser() {
        Assertions.assertTrue((parserFactory.getParser()) instanceof XMLParser);
    }
}