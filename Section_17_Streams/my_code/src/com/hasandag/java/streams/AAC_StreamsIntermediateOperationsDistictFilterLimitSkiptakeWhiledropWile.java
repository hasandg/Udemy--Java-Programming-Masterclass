package com.hasandag.java.streams;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AAC_StreamsIntermediateOperationsDistictFilterLimitSkiptakeWhiledropWile {
    public static void main(String[] args) {


        IntStream.iterate('A', i -> i <=(int)'z', i -> i + 1)
                .filter(Character::isAlphabetic)
                .dropWhile(i -> Character.toUpperCase( i) <= 'E') //evaluates the condition and drops the elements until the condition is false
                                                                      // so accept lower case 'a' to 'e' because not checking the case
                .takeWhile(i -> i < 'a')//evaluates the condition and takes the elements until the condition is false
                //.skip(5)
                //.filter(i -> Character.toUpperCase(i)>'E')
                .forEach(d -> System.out.printf("%c ", d));

        System.out.println("\n----------------------------------------------");

        printAlphabetCapitalOrLowerCase();

        System.out.println("\n----------------------------------------------");

        printAlphabetCapitalLetters();

        System.out.println("\n----------------------------------------------");

        printRandomChars();

    }



    private static void printAlphabetCapitalOrLowerCase() {
        IntStream.iterate('A', i -> i <=(int)'z', i -> i + 1)
                .filter(Character::isAlphabetic)
                .forEach(d -> System.out.printf("%c ", d));
    }

    private static void printAlphabetCapitalLetters() {
        IntStream.iterate('A', i -> i <=(int)'z', i -> i + 1)
                .filter(Character::isAlphabetic)
                .map(Character::toUpperCase)
                .distinct()
                .forEach(d -> System.out.printf("%c ", d));
    }

    private static void printRandomChars() {
        Random random = new Random();

        Stream.generate(() -> random.nextInt('A', (int) 'Z' + 1))
                .limit(50)
                .distinct()
                .sorted()
                .forEach(d -> System.out.printf("%c ", d));
    }
}
