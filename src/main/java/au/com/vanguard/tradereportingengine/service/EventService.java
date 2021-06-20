package au.com.vanguard.tradereportingengine.service;

import au.com.vanguard.tradereportingengine.filter.criteria.FilterCriteria;
import au.com.vanguard.tradereportingengine.filter.criteria.FilterCriteriaFactory;
import au.com.vanguard.tradereportingengine.model.Event;
import au.com.vanguard.tradereportingengine.parser.Parser;
import au.com.vanguard.tradereportingengine.parser.ParserFactory;
import au.com.vanguard.tradereportingengine.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    private final ParserFactory parserFactory;

    private final FilterCriteriaFactory filterCriteriaFactory;

    public EventService(EventRepository eventRepository, ParserFactory parserFactory, FilterCriteriaFactory filterCriteriaFactory) {
        this.eventRepository = eventRepository;
        this.parserFactory = parserFactory;
        this.filterCriteriaFactory = filterCriteriaFactory;
    }

    public List<Event> processXMLFiles(String dir) {
        eventRepository.deleteAll();
        List<File> filePaths = getFilesInDir(dir);
        Parser parser = parserFactory.getParser();
        filePaths.forEach(file -> {
            Event event = parser.process(file.getAbsolutePath());
            eventRepository.save(event);
        });

        FilterCriteria filterCriteria = filterCriteriaFactory.getFilterCriteria();
        return filterCriteria.filterEvents(eventRepository.findAll());
    }

    List<File> getFilesInDir(String dir) {
        File f = new File(dir);
        if (f.listFiles() != null) {
            return Arrays.asList(f.listFiles());
        } else {
            return new ArrayList<>();
        }
    }

}
