package com.epam.rd.java.basic.practice4;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part3 {

    private static String content;

    public static void main(String[] args) {
        startProgram();
    }

    public static void startProgram(){
        content = getInput("part3.txt");
        Scanner scanner = new Scanner(System.in);
        while (true){
            String choose = scanner.nextLine();
            switch (choose){
                case ("int"):
                    findInString("(?<!\\.)\\b[0-9]+\\b(?!\\.)");
                    break;
                case ("double"):
                    findInString("[\\d]*\\.[\\d]+");
                    break;
                case ("char"):
                    findInString("\\b[A-zА-я]{1}\\b");
                    break;
                case ("String"):
                    findInString("[A-zА-я]{2,}");
                    break;
                case ("stop"):
                    return;
                default:
                    System.out.print("Incorrect input");
            }
        }
    }

    public static String getInput(String fileName) {
        Logger logger3 = Logger.getAnonymousLogger();
        StringBuilder sb = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new File(fileName), "Cp1251");
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append(System.lineSeparator());
            }
            scanner.close();
            return sb.toString().trim();
        } catch (IOException ex) {
            logger3.log(Level.SEVERE, "IOException");
        }
        return sb.toString();
    }

    public static void findInString(String regex){
        StringBuilder sb = new StringBuilder();
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(content);
        while(m.find()){
            sb.append(m.group())
                    .append(" ");
        }
        System.out.println(sb.toString());
    }
}
