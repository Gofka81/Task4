package com.epam.rd.java.basic.practice4;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Part5 {

    public static void main(String[] args) {
        startProgram();
    }

    public static void startProgram(){
        Scanner scanner = new Scanner(System.in);
        ResourceBundle rbRU = ResourceBundle.getBundle("resources", new Locale("ru"));
        ResourceBundle rbEN = ResourceBundle.getBundle("resources", new Locale("en"));
        ResourceBundle rb;
        while (true){
            System.out.println("[ENTER]");
            String choose = scanner.nextLine();
            String[] args = choose.split(" ");
            if(args[0].equals("stop")){
                return;
            }
            if(args[1].equals("ru")){
                rb = rbRU;
            }
            else {
                rb = rbEN;
            }
            if(rb.containsKey(args[0])){
                System.out.println(rb.getObject(args[0]));
            }else
            {
                System.out.println("Error!");
            }
        }
    }
}
