package org.example;

import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class PatterMakerTest {
    @Test
    public void testTemplatesToPatterns() {
        List<String> templates = List.of(
                "т1о1", "о2", "\"йо\"", "11", "\"ми\""
        );
        PatternMaker.templatesToPatterns(templates);

        Map<String, Integer> expectedMap = new HashMap<>();
        expectedMap.put("(?i)(?=.*т)(?=.*о)", 1);
        expectedMap.put("[Оо]", 2);
        expectedMap.put("[Йй][оо]", 1);
        expectedMap.put("[Мм][ии]", 1);
        expectedMap.put("[1]", 1);

        assertEquals(expectedMap, PatternMaker.getTemplatesMap());
    }
}
