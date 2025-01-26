package com.hasandag.streams;

import com.hasandag.streams.model.SeatWithPrice;

import java.util.Comparator;
import java.util.stream.Stream;

public class AAD_StreamsIntermediateOperationsMapPeekSorted {
    public static void main(String[] args) {

        int maxSeats = 100;
        int seatsInRow = 10;
        var stream =
                Stream.iterate(0, i -> i < maxSeats, i -> i + 1)
                        .map(i -> new SeatWithPrice((char) ('A' + i / seatsInRow), i % seatsInRow + 1))
                        .skip(5)
                        .limit(10)
                        .peek(s -> System.out.println("--> " + s))
                        .sorted(Comparator.comparing(SeatWithPrice::price)
                                .thenComparing(SeatWithPrice::toString));

//                        .mapToDouble(Seat::price)
//                        .boxed()
//                        .map("%.2f"::formatted);
//                        .peek(System.out::println)
//                        .sorted((s1, s2) -> s1.price() - s2.price())
//                        .limit(10);

        stream.forEach(System.out::println);


    }
}
