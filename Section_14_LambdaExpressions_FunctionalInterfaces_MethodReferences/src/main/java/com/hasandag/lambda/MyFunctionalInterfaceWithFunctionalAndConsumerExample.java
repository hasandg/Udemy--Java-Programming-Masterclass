package com.hasandag.lambda;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class MyFunctionalInterfaceWithFunctionalAndConsumerExample {
    public static void main(String[] args) {
        // Define an Consumer that takes the current count and prints it
        Consumer<Integer> printCount = count ->
                System.out.println("This is execution number with Consumer: " + (count + 1));


        // Define an IntConsumer that takes the current count and prints it
        IntConsumer printCount2 = count ->
                System.out.println("This is execution number: " + (count + 1));
        // Method to run a Consumer 10 times
        runNTimes(10, printCount);

        // Method to run an IntConsumer 20 times
        runNTimes(20, printCount2);

        Consumer myConsumer = (s) -> System.out.println("My random number is: " + new Random().nextInt(1, 3));
        runNTimesWithSimpleConsumer(5, myConsumer);

        System.out.println("====================================");
        // Method to run a Consumer 12 times
        IntStream.range(0, 12).forEach((s) -> System.out.println("Random number is: " + new Random().nextInt(1, 3)));

    }

    // Method that takes a number of times to run and a Consumer
    public static void runNTimes(int n, Consumer<Integer> action) {
        IntStream.range(0, n).forEach(count -> action.accept(count));
    }

    // Method that takes a number of times to run and an IntConsumer
    public static void runNTimes(int n, IntConsumer action) {
        IntStream.range(0, n).forEach(action);
    }

    // Method that takes a number of times to run and a Consumer
    public static void runNTimesWithSimpleConsumer(int n, Consumer action) {
        IntStream.range(0, n).forEach(count -> action.accept(count));
    }


}