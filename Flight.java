package flight_reservation.models;

public class Flight {
    private String flightId;
    private String origin;
    private String destination;
    private int availableSeats;
    private double fare;

    public Flight(String flightId, String origin, String destination, int availableSeats, double fare) {
        this.flightId = flightId;
        this.origin = origin;
        this.destination = destination;
        this.availableSeats = availableSeats;
        this.fare = fare;
    }

    public String getFlightId() {
        return flightId;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public double getFare() {
        return fare;
    }

    public void bookSeat() {
        availableSeats--;
    }
}
