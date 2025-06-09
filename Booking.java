package flight_reservation.models;

public class Booking {
    private String bookingId;
    private Flight flight;
    private Passenger passenger;
    private int seatNumber;

    public Booking(String bookingId, Flight flight, Passenger passenger, int seatNumber) {
        this.bookingId = bookingId;
        this.flight = flight;
        this.passenger = passenger;
        this.seatNumber = seatNumber;
    }

    public String toString() {
        return "Booking ID: " + bookingId + ", Passenger: " + passenger.getName() +
               ", Flight: " + flight.getFlightId() + ", Seat: " + seatNumber;
    }
}
