package org.example;

public class TemplateWithLetters {
    /**
     * Проверяет если первый символ слова - буква
     */
    public static boolean charIsLetter(String word) {
        if (Character.isLetter(word.charAt(0))) {
            return true;
        }
        return false;
    }
    /**
     * Проверяет если первый символ слова - символ "
     */
    public static boolean charIsBrackets(String word) {
        if (word.charAt(0) == '"') {
            return true;
        }
        return false;
    }
}
