package au.com.vanguard.tradereportingengine.service;

import au.com.vanguard.tradereportingengine.filter.criteria.FilterCriteriaFactory;
import au.com.vanguard.tradereportingengine.model.Event;
import au.com.vanguard.tradereportingengine.parser.ParserFactory;
import au.com.vanguard.tradereportingengine.repository.EventRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith({MockitoExtension.class})
class EventServiceTest {

    private EventService eventService;

    @Mock
    private EventRepository eventRepository;

    @BeforeEach
    void setUp() {
        eventService = new EventService(eventRepository, new ParserFactory(), new FilterCriteriaFactory());
    }

    @Test
    void shouldReturnCorrectCountOfFiles() {
        Assertions.assertEquals(3, eventService.getFilesInDir("src/test/resources/eventXML/").size());
    }

    @Test
    void shouldReturnCountOfFilesAsZero() {
        Assertions.assertEquals(0, eventService.getFilesInDir("src/test/resources/eventXML/FolderDoesNotExist").size());
    }

    @Test
    void shouldProcessXMLFiles() {
        Mockito.when(eventRepository.save(Mockito.any())).thenReturn(new Event());
        Mockito.when(eventRepository.findAll()).thenReturn(new ArrayList<>());
        List<Event> filteredEvents = eventService.processXMLFiles("src/test/resources/eventXML/");
        Assertions.assertEquals(0, filteredEvents.size());
    }
}