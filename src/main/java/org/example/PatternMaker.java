package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class PatternMaker {
    public static Map<String, Integer> templateMap = new HashMap<>();

    public static Map<String, Integer> getTemplatesMap() {
        return templateMap;
    }

    /**
     *
     * @param templates список шаблонов, которые будут переделаны в регулярные выражения
     */
    public static void templatesToPatterns(List<String> templates) {
        templates.parallelStream()
                .forEach(template -> {
                    if (TemplateWithLetters.charIsLetter(template)) {
                        if (template.length() <= 2) {
                            patternOfSameLetters(template);
                        } else {
                            patternOfLetters(template);
                        }
                    } else if (TemplateWithNumbers.charIsNumber(template)) {
                         patternOfNumbers(template);
                    } else if (TemplateWithLetters.charIsBrackets(template)){
                         patternOfBrackets(template);
                    }
                });
    }

    /**
     *
     * @param template шаблон, который имеет конструкцию "йо", "ми"
     * Значения и количество повторений записываются в мапу
     */
    public static void patternOfBrackets(String template) {
        Pattern pattern = Pattern.compile("[Йй][оo]");
        char[] charArray = template.toCharArray();
        String letter1 = "" + charArray[1];
        String letter2 = "" + charArray[2];
        int numberOfReps = 1;
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(letter1.toUpperCase())
                .append(letter1.toLowerCase())
                .append("][")
                .append(letter2.toLowerCase())
                .append(letter2.toLowerCase())
                .append("]");
        String regex = sb.toString();
        templateMap.put(regex, numberOfReps);
    }
    /**
     *
     * @param template шаблон, который имеет конструкцию т1о1, й1о1
     * Значения и количество повторений записываются в мапу
     */
    public static void patternOfLetters(String template) {
        char[] charArray = template.toCharArray();
        String letter1 = "" + charArray[0];
        String letter2 = "" + charArray[2];
        int numberOfRepsOfLetter1 = Character.getNumericValue(charArray[1]);
        int numberOfRepsOfLetter2 = Character.getNumericValue(charArray[3]);
        StringBuilder sb = new StringBuilder();
        sb.append("(?i)(?=.*").append(letter1.toLowerCase())
                .append(")(?=.*")
                .append(letter2.toLowerCase())
                .append(")");
        String regex = sb.toString();
        if (numberOfRepsOfLetter1 == numberOfRepsOfLetter2) {
            templateMap.put(regex, numberOfRepsOfLetter1);
        }
    }
    /**
     *
     * @param template шаблон, который имеет конструкцию о2, е2
     * Значения и количество повторений записываются в мапу
     */
    public static void patternOfSameLetters(String template) {
        char[] charArray = template.toCharArray();
        String letter = "" + charArray[0];
        int numberOfReps = Character.getNumericValue(charArray[1]);
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(letter.toUpperCase()).append(letter.toLowerCase()).append("]");
        String regex = sb.toString();
        templateMap.put(regex, numberOfReps);
    }
    /**
     *
     * @param template шаблон, который имеет конструкцию 11
     * Значения и количество повторений записываются в мапу
     */
    public static void patternOfNumbers(String template) {
        char[] charArray = template.toCharArray();
        int number = Character.getNumericValue(charArray[0]);
        int numberOfReps = Character.getNumericValue(charArray[1]);
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(number)
                .append("]");
        String regex = sb.toString();
        templateMap.put(regex, numberOfReps);
    }
}
