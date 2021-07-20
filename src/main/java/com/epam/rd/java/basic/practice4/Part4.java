package com.epam.rd.java.basic.practice4;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    private List<String> args;

    public SentenceSeparator(String args){
        this.args = separator(args);
    }

    private List<String> separator(String args){
        Pattern p = Pattern.compile("(?m)[A-Z].*[0-9\\r\\n ].*[\\.\\n\\r]{1,3}");
        Matcher m = p.matcher(args);
        List<String> arr = new ArrayList<>();
        while (m.find()){
            arr.add(m.group());
        }
        return  arr;
    }


    public Iterator<String> iterator() {
        return new IteratorSentence();
    }

    public class IteratorSentence implements Iterator<String> {

        private int indexNext;

        @Override
        public boolean hasNext() {
            return indexNext != args.size();
        }

        @Override
        public String next() {

            if(indexNext>= args.size()){
                throw new NoSuchElementException();
            }
            int lastIndex = indexNext;
            indexNext++;
            return args.get(lastIndex);
        }

        @Override
        public void remove() {
            throw  new UnsupportedOperationException();
        }
    }

}
