package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class MyFileWriter {
    /**
     *
     * @param outputName имя файла куда записывать данные
     * Из мапы вытаскивает значения и ключи и создаёт строку. Далее записывает её в файл
     * @param statisticMap мапа с готовой статистикой
     * @throws IOException
     */
    public static void writeResultToFile(String outputName, Map<String, Integer> statisticMap) throws IOException {
        String outputFile = PathAppender.appendPath(outputName);
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : statisticMap.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            sb.append(key).append("\t").append(value).append("\n");
        }
        String result = sb.toString();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write(result);
        }
    }


}
