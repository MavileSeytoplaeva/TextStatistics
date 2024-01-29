package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.stubbing.OngoingStubbing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StatisticCollectorTest {

    @Test
    public void testCollectRegexesToMap() {

        // Given
        String word = "отец";
        Map.Entry<String, Integer> regex = Map.entry("(?i)(?=.*т)(?=.*о)", 1);

        // When
        StatisticCollector.collectRegexesToMap(regex);

        // Then
        Map<String, Integer> expectedResultMap = new HashMap<>();
        expectedResultMap.put("(?i)(?=.*т)(?=.*о)", 1);
        assertEquals(expectedResultMap, StatisticCollector.getResultMap());
    }

    @Test
    public void testCollectRegexesToMap_multipleWords() {

        // Given
        List<String> words = List.of("отец", "молодости");
        Map<String, Integer> regexes = Map.of("(?i)(?=.*т)(?=.*о)", 1, "[Оо]", 2);

        // When
        StatisticCollector.collectWordsAndRegexes(regexes, words);

        // Then
        Map<String, Integer> expectedResultMap = new HashMap<>();
        expectedResultMap.put("(?i)(?=.*т)(?=.*о)", 3);
        expectedResultMap.put("[Оо]", 1);
        assertEquals(expectedResultMap, StatisticCollector.getResultMap());
    }

    @Test
    public void testCollectRegexesToMap_multipleRegexes() {

        // Given
        String word = "молодость";
        Map<String, Integer> regexes = Map.of("(?i)(?=.*т)(?=.*о)", 1, "[Оо]", 2);

        // When
        for (Map.Entry<String, Integer> regex : regexes.entrySet()) {
            StatisticCollector.collectRegexesToMap(regex);
        }

        // Then
        Map<String, Integer> expectedResultMap = new HashMap<>();
        expectedResultMap.put("(?i)(?=.*т)(?=.*о)", 4);
        expectedResultMap.put("[Оо]", 2);
        assertEquals(expectedResultMap, StatisticCollector.getResultMap());
    }
}