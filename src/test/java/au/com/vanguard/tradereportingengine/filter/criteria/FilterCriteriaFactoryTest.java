package au.com.vanguard.tradereportingengine.filter.criteria;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilterCriteriaFactoryTest {

    private FilterCriteriaFactory filterCriteriaFactory;

    @BeforeEach
    void setUp() {
        filterCriteriaFactory = new FilterCriteriaFactory();
    }

    @Test
    void getFilterCriteria() {
        Assertions.assertTrue((filterCriteriaFactory.getFilterCriteria()) instanceof SimpleFilterCriteria);
    }
}