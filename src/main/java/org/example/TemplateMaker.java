package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TemplateMaker {

    public static Map<String, Integer> statisticMap = new HashMap<>();

    public static Map<String, Integer> getStatisticMap() {
        return statisticMap;
    }

    /**
     *
     * @param templateMap мапа из шаблонов
     * @param resultMap мапа из результатов статистики
     * В методе проверяется на наличие резулярного выражения в мапа из результатов статистики
     */
    public static void templateFromPattern(Map<String, Integer> templateMap, Map<String, Integer> resultMap) {
        for (Map.Entry<String, Integer> entryTemplateMap : templateMap.entrySet()) {
            for (Map.Entry<String, Integer> entryResultMap:resultMap.entrySet()) {
                if (entryTemplateMap.getKey().equals(entryResultMap.getKey())) {
                    reverseMethod(entryTemplateMap, entryResultMap.getValue());
                }
            }
        }
    }

    /**
     *
     * @param templates список шаблонов
     * В методе проверяется на наличие резулярного выражения в мапа из результатов статистики и если нет,
     *                  то записывается ключ на найденного регулярного выражения и 0 значение)
     *
     */
    public static void addTemplatesWithNoMatches(List<String> templates) {
        templates.parallelStream()
                .forEach(template -> {
                    if (!statisticMap.containsKey(template)){
                        statisticMap.put(template, 0);
                }
        });
    }

    /**
     *
     * @param templateMap мапа шаблонов
     * @param resultRepetitions количество повторений
     * Метод переделывает регулярное выражение обратно в шаблон проверки и записывает конечное количество повторений
     */

    public static void reverseMethod(Map.Entry<String, Integer> templateMap, int resultRepetitions) {

        String key = templateMap.getKey();
        int numberOfReps = templateMap.getValue();
        String letter1 = "";
        String letter2 = "";
        StringBuilder sb = new StringBuilder();
        if (key.length() >= 8) {
            if (key.length() == 8) {
                letter1 = "" + key.charAt(2);
                letter2 = "" + key.charAt(5);
                sb.append("\"").append(letter1).append(letter2).append("\"");
                statisticMap.put(sb.toString(), resultRepetitions);
            }
            if (key.length() == 18) {
                letter1 = "" + key.charAt(9);
                letter2 = "" + key.charAt(16);
                sb.append(letter1).append(numberOfReps).append(letter2).append(numberOfReps);
                statisticMap.put(sb.toString(), resultRepetitions);

            }
        } else {
            if (key.length() == 3) {
                letter1 = "" + key.charAt(1);
            }
            if (key.length() == 4) {
                letter1 = "" + key.charAt(2);
            }
            sb.append(letter1).append(numberOfReps);
            statisticMap.put(sb.toString(), resultRepetitions);
        }
    }
}
