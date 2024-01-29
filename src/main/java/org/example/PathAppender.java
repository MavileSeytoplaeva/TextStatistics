package org.example;

public class PathAppender {
    /**
     *
     * @param fileName имя файла, которое соединяется с заданным путем
     * @return возвращает путь
     */
    public static String appendPath(String fileName) {
        String path = "C:\\Users\\Мавиле\\Documents\\";
        StringBuilder sb = new StringBuilder();
        sb.append(path).append(fileName).append(".txt");
        return sb.toString();
    }
}
