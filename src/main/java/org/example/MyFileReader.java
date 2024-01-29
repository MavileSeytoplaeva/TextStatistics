package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.example.PathAppender.appendPath;

public class MyFileReader {
    /**
     *
     * @param fileName имя файла с шаблонами
     * @return возвращает шаблоны с файла
     * @throws IOException
     */
    public static String readTemplatesFromFile(String fileName) throws IOException {
        String templateFile = appendPath(fileName);
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(templateFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
            }
        }
        return sb.toString();
    }

    /**
     *
     * @param fileName имя файла с текстом
     * @return возвращает текст
     * @throws IOException
     */
    public static String readTextFromFile(String fileName) throws IOException {
            String inputFile = appendPath(fileName);
            StringBuilder sb = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                    sb.append(System.lineSeparator());
                }
            }
            return sb.toString();

    }

    /**
     *
     * @param infoFromFile строку шаблонов из файла
     *
     * @return возвращает список шаблонов в списке из строк
     */

    public static List<String> listOfTemplatesFromFile(String infoFromFile) {
        String[] templates = infoFromFile.split("\r\n");
        List<String> listOfTemplates = new ArrayList<>(List.of(templates));
        return listOfTemplates;
    }

    /**
     *
     * @param infoFromFile получается строку текста
     * @return возвращает список полученных слов, при этом делая все слова с маленькой буквы
     */

    public static List<String> listOfWordsFromFile(String infoFromFile) {
        String[] words = infoFromFile.split(" ");
        return Stream.of(words)
                .map(word -> word.toLowerCase())
                .toList();
    }
}
