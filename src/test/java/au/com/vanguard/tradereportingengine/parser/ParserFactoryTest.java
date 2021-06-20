package au.com.vanguard.tradereportingengine.parser;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParserFactoryTest {
    private ParserFactory parserFactory;

    @BeforeEach
    void setUp() {
        parserFactory = new ParserFactory();
    }

    @Test
    void getParser() {
        Assertions.assertTrue((parserFactory.getParser("some path")) instanceof XMLParser);
    }
}