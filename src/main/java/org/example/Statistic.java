package org.example;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.example.MyFileReader.*;
import static org.example.MyFileReader.listOfTemplatesFromFile;

public class Statistic {
    /**
     *
     * @param inputTextFile файл с текстом
     * @param inputTemplateFile файл с шаблонами
     * @param outputWriterFile файл куда запишется статистика
     */
    public static void statistic(String inputTextFile, String inputTemplateFile, String outputWriterFile) {
        try {
            String infoFromFile = readTextFromFile(inputTextFile);
            List<String> listOfWords = listOfWordsFromFile(infoFromFile);
            String infoFromFile2 = readTemplatesFromFile(inputTemplateFile);
            List<String> templates = listOfTemplatesFromFile(infoFromFile2);
            PatternMaker.templatesToPatterns(templates);
            Map<String, Integer> templatesToPatterns = PatternMaker.getTemplatesMap();
            StatisticCollector.collectWordsAndRegexes(templatesToPatterns, listOfWords);
            TemplateMaker.templateFromPattern(PatternMaker.getTemplatesMap(), StatisticCollector.getResultMap());
            TemplateMaker.addTemplatesWithNoMatches(templates);

            MyFileWriter.writeResultToFile(outputWriterFile, TemplateMaker.getStatisticMap());
            System.out.println("Статистика успешно собрана");
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
