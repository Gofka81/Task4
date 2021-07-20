package com.epam.rd.java.basic.practice4;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part6 {

    public static void main(String[] args) {
        Progam6.startProgram();
    }

}

class Progam6{
    private static  String input;

    public static String getInput(String fileName) {
        Logger logger6 = Logger.getAnonymousLogger();
        StringBuilder sb = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new File(fileName), "Cp1251");
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append(System.lineSeparator());
            }
            scanner.close();
            return sb.toString().trim();
        } catch (IOException ex) {
            logger6.log(Level.SEVERE, "IOException");
        }
        return sb.toString();
    }

    public static void startProgram(){
        input = getInput("part6.txt");
        Scanner scanner = new Scanner(System.in);
        while (true){
            String val = scanner.nextLine();
            if(val.equals("cyrl")){
                System.out.println(getThisLanguage("[\\p{IsCyrillic}]+"));
            }else if(val.equals("latn")){
                System.out.println(getThisLanguage("[A-z]+"));
            }else if(val.equals("stop")){
                return;
            }
            else{
                System.out.println("Incorrect input");
            }
        }
    }

    public static String getThisLanguage(String regex){
        StringBuilder sb = new StringBuilder();
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(input);
        while (m.find()){
            sb.append(m.group())
                .append(" ");
        }
        return  sb.toString();
    }
}
