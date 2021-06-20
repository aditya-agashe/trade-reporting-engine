package au.com.vanguard.tradereportingengine.filter.criteria;

import au.com.vanguard.tradereportingengine.model.Event;

import java.util.List;

public interface FilterCriteria {
    List<Event> filterEvents(List<Event> eventsList);
}
