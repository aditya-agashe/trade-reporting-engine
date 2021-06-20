package au.com.vanguard.tradereportingengine.controller;

import au.com.vanguard.tradereportingengine.model.Event;
import au.com.vanguard.tradereportingengine.model.EventLocation;
import au.com.vanguard.tradereportingengine.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EventController {

    @Autowired
    private EventService eventService;

    @PostMapping("/events")
    public List<Event> createEvents(@RequestBody EventLocation eventLocation) {
        // Better practice is to use a transfer object for response rather than exposing the entity directly, here Event
        return eventService.processXMLFiles(eventLocation.getDirPath());
    }


}
