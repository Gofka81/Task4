package com.epam.rd.java.basic.practice4;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.*;

public class Util {
    public static String getInput(String fileName) {
        Logger logger = Logger.getAnonymousLogger();
        StringBuilder sb = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new File(fileName), "Cp1251");
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append(System.lineSeparator());
            }
            scanner.close();
            return sb.toString().trim();
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "IOException");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String input = Util.getInput("part1.txt");
        System.out.println(input);
    }
}
