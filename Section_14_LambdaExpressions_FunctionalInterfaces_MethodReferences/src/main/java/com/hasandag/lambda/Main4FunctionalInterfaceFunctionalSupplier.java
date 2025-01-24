package com.hasandag.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Main4FunctionalInterfaceFunctionalSupplier {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>(List.of("alpha", "bravo", "charlie", "delta"));

        var coords = Arrays.asList(
                new double[]{32.123, 39.123},
                new double[]{35.123, 41.123},
                new double[]{36.754, 42.973}
        );

        //Functional Interface Examples
        list.replaceAll(s -> s.charAt(0) + " - " + s.toUpperCase());
        System.out.println("====================================");
        list.forEach(s -> System.out.println(s));

        String[] emptyStrings = new String[10];
        System.out.println(Arrays.toString(emptyStrings));
        Arrays.fill(emptyStrings, "");
        System.out.println(Arrays.toString(emptyStrings));

        Arrays.setAll(emptyStrings, i -> "" + (i + 1) + ". ");
        System.out.println(Arrays.toString(emptyStrings));

        Arrays.setAll(emptyStrings, i -> "" + (i + 1) + ". "
                + switch (i) {
            case 0 -> "first";
            case 1 -> "second";
            case 2 -> "third";
            default -> "";
        });
        System.out.println(Arrays.toString(emptyStrings));

        //Supplier Examples
        String[] names = {"Ann", "Bob", "Carol", "David", "Ed", "Fred"};

        String[] randomNames = randomlySelectedValues(15, names,
                () -> new Random().nextInt(1,names.length));

        System.out.println(Arrays.toString(randomNames));

        System.out.println("randomlySelectedValues2 calling");
        String[] randomNames2 = randomlySelectedValues2(20, names,
                () -> (int) (Math.random() * names.length));
        System.out.println(Arrays.toString(randomNames2));





    }

    public static String[] randomlySelectedValues( int count, String[] values, Supplier<Integer> s){
        String[] selectedValues = new String[count];
        for (int i = 0; i < count; i++) {
            selectedValues[i] = values[s.get()];
        }
        return selectedValues;
    }

    public static String[] randomlySelectedValues2(int count, String[] values, Supplier<Integer> s) {
        String[] selectedValues = new String[count];
        for (int i = 0; i < count; i++) {
            int index = s.get() % values.length;
            selectedValues[i] = values[index];
        }
        return selectedValues;
    }


}
