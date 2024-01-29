package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.example.MyMatcher.*;


public class StatisticCollector {

    private static Map<String, Integer> resultMap = new HashMap<>();

    /**
     *
     * @param regex мапа регулярных выражений, которая переписывается в новую мапу с подсчётом повторений
     *
     */
    public static void collectRegexesToMap( Map.Entry<String, Integer> regex) {
        String key = regex.getKey();
        Integer firstValue = 1;

        if (resultMap.containsKey(key)) {
            int number = resultMap.get(key);
            number++;
            resultMap.put(key, number);
        } else {
            resultMap.put(key, firstValue);
        }
    }

    /**
     *
     * @param regexes мапа регулярных выражений
     * @param words список слов
     */
    public static void collectWordsAndRegexes(Map<String, Integer> regexes, List<String> words) {
        for (Map.Entry<String, Integer> entry : regexes.entrySet()) {
            words.parallelStream().filter(word -> containsLettersAfterEachOther(word, entry) || containsLetters(word, entry)
                    || containsNumbers(word, entry) || containsSameLettersNTimes(word, entry)).forEach(word -> collectRegexesToMap(entry));
            }
        }


    public static Map<String, Integer> getResultMap() {
        return resultMap;
    }

}
