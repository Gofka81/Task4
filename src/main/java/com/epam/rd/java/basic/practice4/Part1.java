package com.epam.rd.java.basic.practice4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

    public static void main(String[] args) {
        System.out.println(Util.getInput("file1.txt"));
    }

    public  static String dellTwoChars(String input){
        StringBuilder sb = new StringBuilder();
        Pattern p = Pattern.compile("(?m)\\b[A-zА-я]{2}([A-zА-я]{2,})|[A-zА-я]{1,3}|[ '?.,]+");
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
}
