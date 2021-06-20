package au.com.vanguard.tradereportingengine.parser;

import org.springframework.stereotype.Component;

@Component
public class ParserFactory {
    public Parser getParser(){
        return new XMLParser();
    }
}
