package com.hasandag.lambda;

import java.util.ArrayList;
import java.util.List;

public class Main2SyntaxAdditionalExamples {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("alpha", "bravo", "charlie", "delta", "echo", "foxtrot"));

        list.forEach((String s) -> System.out.println(s));
        list.forEach((var s) -> System.out.println(s));
        list.forEach((s) -> System.out.println(s));
        list.forEach(s -> System.out.println(s));

        System.out.println("====================================");
        // final var prefix = "nato";
        var prefix = "nato";
        // var myString = "my local variable"; //it gives "Variable 'myString' is already defined in the scope" error
        list.forEach(myString -> {
            char firstChar = myString.charAt(0);
            System.out.println(prefix+ " " +myString + " means " + firstChar);
        });
        // prefix = "NATO"; // it gives error "Variable used in lambda expression should be final or effectively final"
        System.out.println("====================================");

        int result = calculate((a, b) -> a + b, 3, 2);
        // int result = calculate((Integer a,var b) -> a + b, 3, 2); // Cannot mix 'var' and explicitly typed parameters in lambda expression
        var result2 = calculate((a, b) -> a + b, 3, 2);
        var result3 = calculate((a, b) -> a / b, 10.0, 2.5);
        var result4 = calculate((a, b) -> a.toUpperCase() + " "+ b.toUpperCase(), "hello", "world");

    }


    public static <T> T calculate(Operation<T> function, T value1, T value2) {
        T result = function.operate(value1, value2);
        System.out.println("Result of operation: " + result);
        return result;
    }
}
