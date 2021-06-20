package au.com.vanguard.tradereportingengine.parser;

public class ParserFactory {

    public Parser getParser(String path){
        return new XMLParser(path);
    }
}
