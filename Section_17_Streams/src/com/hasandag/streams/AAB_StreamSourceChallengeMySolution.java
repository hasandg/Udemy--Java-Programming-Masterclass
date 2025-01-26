package com.hasandag.streams;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AAB_StreamSourceChallengeMySolution {
    public static void main(String[] args) {


        //1-15
        //Stream.iterate and Stream.generate are infinite streams
        //if you don't limit them, they will run forever
        Stream<String> streamB = Stream.iterate(1, n -> n + 1)
                .limit(15)
                .map(i -> "B" + i);

        //16-30
        Stream<String> streamI = IntStream.rangeClosed(16, 30)
                .mapToObj(i -> "I" + i);

        //31-45
        Stream<String> streamN = Stream.iterate(31, n -> n + 1)
                .limit(15)
                .map(i -> "N" + i);

        //46-60
        Stream<String> streamG = Stream.iterate(46, n -> n <= 60, n -> n + 1)
                .limit(15)
                .map(i -> "G" + i);

        //61-75
        Stream<String> streamO = Stream.of(61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75)
                .map(i -> "O" + i);

        //concat streams
        Stream<String> finalStream = Stream.concat(
                Stream.concat(
                        Stream.concat(
                                Stream.concat(
                                        streamB,
                                        streamI
                                ),
                                streamN
                        ),
                        streamG
                ),
                streamO
        );

        finalStream
                .limit(75)
                .forEach(System.out::println);

    }
}
