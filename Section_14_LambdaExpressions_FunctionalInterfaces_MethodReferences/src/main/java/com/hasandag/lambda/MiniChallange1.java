package com.hasandag.lambda;

import java.util.Arrays;
import java.util.function.Consumer;

public class MiniChallange1 {
    public static void main(String[] args) {

        String mySentence = "The quick brown fox jumps over the lazy dog";

        Consumer<String> printWords = new Consumer<String>() {

            @Override
            public void accept(String sentence) {
                String[] parts = sentence.split(" ");
                for (String part : parts) {
                    System.out.println(part);
                }
            }
        };

        Consumer<String> printWordsWithlambda = sentence -> {
            String[] parts = sentence.split(" ");
            for (String part : parts) {
                System.out.println(part);
            }
        };
        printWords.accept(mySentence);
        System.out.println("====================================");
        printWordsWithlambda.accept(mySentence);

//        printWordsStaticMethod(printWords, mySentence);
//        System.out.println("====================================");
//        printWordsStaticMethod(printWordsWithlambda, mySentence);

        Consumer<String> printWordsForEach = sentence -> {
            String[] parts = sentence.split(" ");
            Arrays.asList(parts).forEach(s -> System.out.println(s));
        };

        System.out.println("printWordsForEach ====================================");
        printWordsForEach.accept(mySentence);

        Consumer<String> printWordsConcise = sentence -> {
            Arrays.asList(sentence.split(" ")).forEach(s -> System.out.println(s));
        };

        System.out.println("printWordsConcise ====================================");
        printWordsConcise.accept(mySentence);

        Consumer<String> printWordsStream = sentence -> Arrays.stream(sentence.split(" "))
                .forEach(System.out::println);
        System.out.println("printWordsStream ====================================");
        printWordsStream.accept(mySentence);

    }

    public static void printWordsStaticMethod(Consumer<String> consumer, String sentence) {
        consumer.accept(sentence);
    }
}
