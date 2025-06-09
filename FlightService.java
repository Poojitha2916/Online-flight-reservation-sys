package flight_reservation.services;

import java.util.*;

import flight_reservation.exceptions.FlightNotFoundException;
import flight_reservation.models.Flight;

public class FlightService {
    private Map<String, Flight> flights = new HashMap<>();

    public void addFlight(Flight flight) {
        flights.put(flight.getFlightId(), flight);
    }

    public List<Flight> searchFlights(String origin, String destination) {
        List<Flight> results = new ArrayList<>();
        for (Flight flight : flights.values()) {
            if (flight.getOrigin().equalsIgnoreCase(origin) && 
                flight.getDestination().equalsIgnoreCase(destination)) {
                results.add(flight);
            }
        }
        return results;
    }

    public Flight getFlight(String id) throws FlightNotFoundException {
        Flight flight = flights.get(id);
        if (flight == null) throw new FlightNotFoundException("Flight not found: " + id);
        return flight;
    }
}

