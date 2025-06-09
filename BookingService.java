package flight_reservation.services;

import java.util.*;

import flight_reservation.models.*;
import flight_reservation.exceptions.*;

public class BookingService {
    private List<Booking> bookings = new ArrayList<>();
    private int bookingCounter = 1;

    public Booking bookFlight(Flight flight, Passenger passenger) throws SeatsUnavailableException {
        if (flight.getAvailableSeats() <= 0) {
            throw new SeatsUnavailableException("No seats available on flight " + flight.getFlightId());
        }
        int seatNumber = flight.getAvailableSeats();
        flight.bookSeat();
        Booking booking = new Booking("B" + bookingCounter++, flight, passenger, seatNumber);
        bookings.add(booking);
        return booking;
    }

    public List<Booking> getAllBookings() {
        return bookings;
    }
}
