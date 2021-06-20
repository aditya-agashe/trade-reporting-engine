package au.com.vanguard.tradereportingengine.parser;

import au.com.vanguard.tradereportingengine.model.Event;

public interface Parser {
    Event process(String filePath);
}
