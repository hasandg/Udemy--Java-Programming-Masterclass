package com.hasandag.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;

public class Main3FunctionalInterfaceConsumerPredicate {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>(List.of("alpha", "bravo", "charlie", "delta"));

        var coords = Arrays.asList(
                new double[]{32.123, 39.123},
                new double[]{35.123, 41.123},
                new double[]{36.754, 42.973}
        );

        //Consumer Examples
        coords.forEach(coord -> System.out.println("Latitude: " + coord[0] + " Longitude: " + coord[1]));

        System.out.println("====================================");

        coords.forEach(s -> System.out.println(Arrays.toString(s)));

        System.out.println("====================================");

        BiConsumer<Double, Double> printPoint = (lat, lon) -> System.out.printf("[Lat:%.3f Lon:%.3f]%n", lat, lon);
        //this prints nothing here

        var firstPoint = coords.getFirst();

        processPoint(firstPoint[0], firstPoint[1], printPoint);

        System.out.println("====================================");

        coords.forEach(coord -> processPoint(coord[0], coord[1], printPoint));

        System.out.println("====================================");

        coords.forEach(coord -> processPoint(coord[0], coord[1],
                (lat, lon) -> System.out.printf("[Lat:%.3f Lon:%.3f]%n", lat, lon)));

        //Predicate Examples
        list.removeIf(s -> s.equalsIgnoreCase("bravo"));
        list.forEach(s -> System.out.println(s));

        System.out.println("====================================");

        list.addAll(List.of("echo", "easy", "earnest"));
        list.forEach(s -> System.out.println(s));

        System.out.println("====================================");

        list.removeIf(s -> s.startsWith("ea"));
        list.forEach(s -> System.out.println(s));



    }


    public static <T> T calculate(BinaryOperator<T> function, T value1, T value2) {
        T result = function.apply(value1, value2);
        System.out.println("Result of operation: " + result);
        return result;
    }

    public static <T> void processPoint(T t1, T t2, BiConsumer<T, T> consumer) {
        consumer.accept(t1, t2);
    }

}
