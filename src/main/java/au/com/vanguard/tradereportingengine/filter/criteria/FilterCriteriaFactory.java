package au.com.vanguard.tradereportingengine.filter.criteria;

import org.springframework.stereotype.Component;

@Component
public class FilterCriteriaFactory {
    public FilterCriteria getFilterCriteria(){
        return new SimpleFilterCriteria();
    }
}
