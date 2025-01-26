package com.hasandag.java.streams;

import com.hasandag.java.streams.model.SeatWithReservation;

import java.util.Arrays;
import java.util.stream.IntStream;

public class AAE_TerminalOperationsForStatisticalInformationAndMatching {
    public static void main(String[] args) {

        var result = IntStream
                .iterate(0, i -> i<= 1000,i -> i + 1)
                .summaryStatistics();

        System.out.println("result = " + result);

        var leapYearData = IntStream
                .iterate(2000, i -> i <= 2025, i -> i + 1)
                .filter(i -> i % 4 == 0)
                .peek(i -> System.out.println("Leap year: " + i))
                .summaryStatistics();

        System.out.println("leapYearData = " + leapYearData);


        var leapYearDataTheOriginal = IntStream
                .iterate(2000, i -> i <= 2025, i -> i + 1)
                .filter(i -> i % 4 == 0)
                .filter(i -> i % 100 != 0)
                .peek(i -> System.out.println("i = " + i))
                .filter(i -> i % 400 == 0)
                .peek(i -> System.out.println("Leap year: " + i))
                .summaryStatistics();

        // If the set is empty, be careful with minimum and maximum !!!
        System.out.println("leapYearDataTheOriginal = " + leapYearDataTheOriginal);

        SeatWithReservation[] seatWithReservations = new SeatWithReservation[100];
        Arrays.setAll(seatWithReservations, i -> new SeatWithReservation((char) ('A' + i / 10), i%10 + 1));
        //Arrays.asList(seats).forEach(System.out::println);

        long reservationCount = Arrays
                .stream(seatWithReservations)
                .filter(SeatWithReservation::isReserved)
                .count();

        System.out.println("reservationCount = " + reservationCount);


        boolean hasBooking = Arrays
                .stream(seatWithReservations)
                .anyMatch(SeatWithReservation::isReserved);
        System.out.println("hasBooking = " + hasBooking);

        boolean fullyBooked = Arrays
                .stream(seatWithReservations)
                .allMatch(SeatWithReservation::isReserved);
        System.out.println("fullyBooked = " + fullyBooked);

        boolean eventWashedOut = Arrays
                .stream(seatWithReservations)
                .noneMatch(SeatWithReservation::isReserved);
        System.out.println("eventWashedOut = " + eventWashedOut);

    }
}
