package org.example;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyMatcher {
    /**
     *
     * @param word слово, которое проверяется
     * @param regexAndNumOfReps мапа из которой будет браться регулярное выражение
     * @return возвращает количество повторений в слове
     */
    public static int matcherCounter(String word, Map.Entry<String, Integer> regexAndNumOfReps) {
        String key = regexAndNumOfReps.getKey();
        int numberOfReps = 0;

        Pattern pattern = Pattern.compile(key);
        Matcher matcher = pattern.matcher(word);
        numberOfReps = regexAndNumOfReps.getValue();
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }

    /**
     *
     * @param word проверяемое слово
     * @param regexAndNumOfReps мапа из которой будет браться регулярное выражение
     * @return возвращает true если регулярное выражение по типу (т1о1, й1о1) повторилось нужное количество раз
     */
    public static boolean containsLetters(String word, Map.Entry<String, Integer> regexAndNumOfReps) {
        int numberOfReps = regexAndNumOfReps.getValue();
        int count = matcherCounter(word, regexAndNumOfReps);

        if (count >= numberOfReps) {
            return true;
        }
        return false;
    }

    /**
     *
     * @param word проверяемое слово
     * @param regexAndNumOfReps мапа из которой будет браться регулярное выражение
     * @return возвращает true если регулярное выражение по типу ("ми", "йо") повторилось нужное количество раз
     */
    public static boolean containsLettersAfterEachOther(String word, Map.Entry<String, Integer> regexAndNumOfReps) {
        int numberOfReps = regexAndNumOfReps.getValue();
        int count = matcherCounter(word, regexAndNumOfReps);

        if (count >= numberOfReps) {
            return true;
        } else
            return false;
    }
    /**
     *
     * @param word проверяемое слово
     * @param regexAndNumOfReps мапа из которой будет браться регулярное выражение
     * @return возвращает true если регулярное выражение по типу (о2, е2) повторилось нужное количество раз
     */
    public static boolean containsSameLettersNTimes(String word, Map.Entry<String, Integer> regexAndNumOfReps) {
        int numberOfReps = regexAndNumOfReps.getValue();
        int count = matcherCounter(word, regexAndNumOfReps);

        if (count > numberOfReps) {
            return true;
        }

        return false;
    }
    /**
     * @param word проверяемое слово
     * @param regexAndNumOfReps мапа из которой будет браться регулярное выражение
     * @return возвращает true если регулярное выражение по типу (11) повторилось нужное количество раз
     */
    public static boolean containsNumbers(String word, Map.Entry<String, Integer> regexAndNumOfReps) {
        int numberOfReps = regexAndNumOfReps.getValue();
        int count = matcherCounter(word, regexAndNumOfReps);

        if (count == numberOfReps) {
            return true;
        }
        return false;
    }
}
