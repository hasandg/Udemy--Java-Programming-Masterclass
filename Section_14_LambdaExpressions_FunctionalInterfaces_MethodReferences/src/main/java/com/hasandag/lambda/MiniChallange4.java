package com.hasandag.lambda;

import java.util.function.IntPredicate;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;

public class MiniChallange4 {
    public static void main(String[] args) {

        UnaryOperator<String> everySecondCharlambda = source -> {

            StringBuilder returnVal = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if (i % 2 == 1) {
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };

        System.out.println(everySecondCharlambda.apply("1234567890"));

        System.out.println("everySecondCharacterFunction ====================================");
        String result = everySecondCharacter(everySecondCharlambda, "1234567890");
        System.out.println(result);



        @FunctionalInterface
        interface EverySecondCharOperator extends UnaryOperator<String> {
            @Override
            String apply(String source);
        }

        // Shorter version using streams and IntStream
        EverySecondCharOperator everySecondChar = source ->
                IntStream.range(0, source.length())
                        .filter(i -> i % 2 == 1)
                        .mapToObj(source::charAt)
                        .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                        .toString();

        System.out.println("everySecondChar ====================================");
        System.out.println(everySecondChar.apply("1234567890"));


    }

    public static String everySecondCharacter(UnaryOperator<String> unaryOperator, String source) {
        return unaryOperator.apply(source);
    }
}
