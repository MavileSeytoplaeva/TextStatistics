package org.example;

public class TemplateWithNumbers {

    /**
     * Проверяет если первый символ слова - цифра
     */
    public static boolean charIsNumber(String word) {
        if (Character.isDigit(word.charAt(0))) {
            return true;
        }
        return false;
    }
}
