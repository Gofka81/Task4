package com.epam.rd.java.basic.practice4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

    public static void main(String[] args) {
        System.out.println(getInput("file1.txt"));
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
    public static String getInput(String path) {
        final String ENCODING = "Cp1251";
        String res = null;
        try {
            byte[] bytes = Files.readAllBytes(Paths.get(path));
               res = new String(bytes, ENCODING);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return dellTwoChars(res);
    }
    }