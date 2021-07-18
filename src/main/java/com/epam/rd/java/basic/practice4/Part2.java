package com.epam.rd.java.basic.practice4;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.logging.*;

public class Part2 {

    public static void main(String[] args) {
       createFile("part2.txt",generateNumbersString(),"input ==> ");
       createFile("part2_sorted.txt",sortArray(getInput("part2.txt")),"output ==> ");
    }

    public static void createFile(String pathFile,String val,String input){
        Path path = Paths.get(pathFile);
        try {
            byte[] bs = val.getBytes();
            Path writtenFilePath = Files.write(path, bs);
            System.out.println(input + new String(Files.readAllBytes(writtenFilePath)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  static String generateNumbersString(){
        Random myRandom = new Random(); //NOSONAR
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 10; i++){
            sb.append(myRandom.nextInt(51))
            .append(" ");
        }
        return sb.toString();
    }

    public static String sortArray(String arr){
        String[] arrS = arr.split(" ");
        int[] arrI = new int[arrS.length];
        for(int i=0; i< arrS.length; i++){
            arrI[i] =Integer.parseInt(arrS[i]);
        }
        Arrays.sort(arrI);
        StringBuilder sb = new StringBuilder();
        String space = "";
        for(int s: arrI){
            sb.append(space);
            space = " ";
            sb.append(s);
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
