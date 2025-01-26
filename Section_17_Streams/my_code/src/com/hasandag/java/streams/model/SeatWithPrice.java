package com.hasandag.java.streams.model;

public record SeatWithPrice(char rowMaker, int seatNumber, double price) {
    public SeatWithPrice(char rowMaker, int seatNumber) {
       this(rowMaker, seatNumber,
               rowMaker> 'C' && (seatNumber<= 2 || seatNumber>= 9)?50:75);
    }

//    @Override
//    public String toString() {
//        return "%c%03d %.0f".formatted(rowMaker, seatNumber, price);
//    }
}
