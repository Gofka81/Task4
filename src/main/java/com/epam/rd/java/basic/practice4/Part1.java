package com.epam.rd.java.basic.practice4;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

    public static void main(String[] args) {
        System.out.println(dellTwoChars(getInput("part1.txt")));
    }

    public  static String dellTwoChars(String input){
        StringBuilder sb = new StringBuilder();
        Pattern p = Pattern.compile("(?m)[A-zА-я]{2}([A-zА-я]{2,})|[A-zА-я]{1,3}|[ '?.,]+");
        Matcher m = p.matcher(input);
        while(m.find()){
            if(m.group(1).equals(""))
                sb.append(m.group());
            else{
                sb.append(m.group(1));
            }
        }
        return sb.toString();
    }
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
}