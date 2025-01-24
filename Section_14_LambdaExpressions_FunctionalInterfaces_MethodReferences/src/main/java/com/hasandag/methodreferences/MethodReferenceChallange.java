package com.hasandag.methodreferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.UnaryOperator;


public class MethodReferenceChallange {

    private static Random random = new Random();

    private record Person(String first) {

        public String last(String s) {
            return first + " " + s.substring(0, s.indexOf(" "));
        }
    }

    public static void main(String[] args) {

        String[] namesArray = {"Hasan", "Bob", "Alice", "John", "Mary"};

        Person hasan = new Person("Sally");

//        Function[] functions = new Function[]{
//                (s1, s2) -> s1 + s2,
//                String::concat,
//                MethodReferenceChallange::concatStrings
//        };

        List<UnaryOperator<String>> functions =  new ArrayList<>(List.of(
                String::toUpperCase,
                s -> s += " " + getRandomChar('A', 'D') + ".",
                s -> s += reverse(s, 0, s.indexOf(" ")),
                s -> reverse(s, 0, s.indexOf(" ")),
                MethodReferenceChallange::reverse,
                String::new,
                s -> new String(s),
                String::valueOf,
                s -> s + " " + "MyStr",
                hasan::last,
                (new Person("MARY"))::last



        ));

        applyChanges(namesArray, functions);
    }

    private static void applyChanges(String[] namesArray, List<UnaryOperator<String>> functions) {
        List<String> backedByArray = Arrays.asList(namesArray);

        System.out.println("Applying functions to array elements");
        for (UnaryOperator<String> function : functions) {
            backedByArray.replaceAll(s -> s.transform(function));
            //System.out.println(Arrays.toString(backedByArray.toArray()));
            System.out.println(backedByArray);
        }

//        for (UnaryOperator<String> function : functions) {
//            for (int i = 0; i < namesArray.length; i++) {
//                namesArray[i] = function.apply(namesArray[i]);
//            }
//        }
    }

    private static char getRandomChar(char startChar, char endChar) {
        //return (char) random.nextInt(endChar - startChar + 1);
        return (char) random.nextInt((int) startChar, (int) endChar + 1);
    }

    private static String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
    private static String reverse(String s,int start, int end) {
        return new StringBuilder(s.substring(start,end)).reverse().toString();
    }


}
