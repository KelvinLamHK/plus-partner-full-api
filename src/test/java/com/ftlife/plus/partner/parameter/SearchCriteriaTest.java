package com.ftlife.plus.partner.parameter;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SearchCriteriaTest {
    @Test
    void pojoTest(){

        SearchCriteria searchCriteria = new SearchCriteria("a","a", SearchOperation.GREATER_THAN);
        searchCriteria.setKey("a");
        searchCriteria.setOperation(SearchOperation.GREATER_THAN);
        searchCriteria.setValue("a");
        assertEquals("a", searchCriteria.getValue());
        assertEquals("a", searchCriteria.getKey());
        assertEquals(SearchOperation.GREATER_THAN, searchCriteria.getOperation());

    }
}
