package com.epam.rd.java.basic.practice4;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Part4 {

    public static void main(String[] args) {
        SentenceSeparator sentenceSeparator = new SentenceSeparator(getInput());

        for (String s : sentenceSeparator) {
            System.out.print(s);
        }
    }

    public static String getInput() {
        Logger logger4 = Logger.getAnonymousLogger();
        StringBuilder sb = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new File("part4.txt"), "Cp1251");
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append(System.lineSeparator());
            }
            scanner.close();
            return sb.toString().trim();
        } catch (IOException ex) {
            logger4.log(Level.SEVERE, "IOException");
        }
        return sb.toString();
    }
}

class SentenceSeparator implements Iterable<String>{

    private String[]  args;

    public SentenceSeparator(String args){
        this.args = args.split("(?m)(?<=\\.)[\\r\\n]+(?=[A-Z])");
        addSeparator();
    }

    private void addSeparator(){
        for(int i =0; i< args.length; i++) {
            args[i] = args[i].replaceAll(System.lineSeparator()," ").trim() + "\n";
        }
    }


    public Iterator<String> iterator() {
        return new IteratorSentence();
    }

    public class IteratorSentence implements Iterator<String> {

        private int indexNext;
        private int lastIndex = -1;  //NOSONAR

        @Override
        public boolean hasNext() {
            return indexNext != args.length;
        }

        @Override
        public String next() {

            if(indexNext>= args.length){
                throw new NoSuchElementException();
            }
            lastIndex = indexNext;
            indexNext++;
            return args[lastIndex];
        }

        @Override
        public void remove() {
            throw  new UnsupportedOperationException();
        }
    }

}
