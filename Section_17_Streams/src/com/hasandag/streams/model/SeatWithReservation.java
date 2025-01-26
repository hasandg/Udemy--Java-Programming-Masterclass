package com.hasandag.streams.model;

public record SeatWithReservation(char rowMarker, int seatNumber, boolean isReserved) {

    public SeatWithReservation(char rowMarker, int seatNumber) {
        //        this(rowMarker, seatNumber, new Random().nextBoolean());
        //        this(rowMarker, seatNumber, true);
                this(rowMarker, seatNumber, false);
    }
}
