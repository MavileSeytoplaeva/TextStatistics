package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TemplateMakerTest {

    @Test
    public void reverseMethodTest() {
        Map<String, Integer> templateMap = new HashMap<>();
        templateMap.put("(?i)(?=.*т)(?=.*о)", 1);
        templateMap.put("[Йй][оо]", 1);
        templateMap.put("[1]", 1);

        Map<String, Integer> resultMap = new HashMap<>();
        resultMap.put("т1о1", 1);
        resultMap.put("\"йо\"", 1);
        resultMap.put("11", 1);
        for (Map.Entry<String, Integer> temp : templateMap.entrySet()) {
            TemplateMaker.reverseMethod(temp, temp.getValue());
        }
        assertEquals(resultMap, TemplateMaker.getStatisticMap());
    }
}
