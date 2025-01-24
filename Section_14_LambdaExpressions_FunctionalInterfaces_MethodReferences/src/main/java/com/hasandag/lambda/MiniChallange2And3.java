package com.hasandag.lambda;

import java.util.function.IntPredicate;
import java.util.function.UnaryOperator;

public class MiniChallange2And3 {
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

    }
}
