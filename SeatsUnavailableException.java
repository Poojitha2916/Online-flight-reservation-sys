package flight_reservation.exceptions;

public class SeatsUnavailableException extends Exception {
    public SeatsUnavailableException(String message) {
        super(message);
    }
}
