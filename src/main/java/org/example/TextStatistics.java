package org.example;


import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import static org.example.MyFileReader.*;


public class TextStatistics {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя файла с текстом для анализа ");
        String inputTextFile = scanner.nextLine();
        System.out.println("Введите имя файла с шаблонами для проверки ");
        String inputTemplateFile = scanner.nextLine();
        System.out.println("Введите имя файла куда записать статистику ");
        String outputWriterFile = scanner.nextLine();
        Statistic.statistic(inputTextFile, inputTemplateFile, outputWriterFile);
        scanner.close();
    }


}

