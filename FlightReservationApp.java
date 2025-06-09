package flight_reservation.main;

import java.util.*;

import flight_reservation.exceptions.*;
import flight_reservation.models.*;
import flight_reservation.services.*;

public class FlightReservationApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FlightService flightService = new FlightService();
        BookingService bookingService = new BookingService();

        // Sample Flights
        flightService.addFlight(new Flight("F101", "Delhi", "Mumbai", 20, 4500));
        flightService.addFlight(new Flight("F102", "Delhi", "Bangalore", 15, 5000));
        flightService.addFlight(new Flight("F103", "Mumbai", "Chennai", 10, 6000));

        while (true) {
            System.out.println("\n--- Flight Reservation System ---");
            System.out.println("1. Search Flights");
            System.out.println("2. Book Flight");
            System.out.println("3. View Bookings");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter Origin: ");
                        String origin = sc.next();
                        System.out.print("Enter Destination: ");
                        String dest = sc.next();
                        List<Flight> flights = flightService.searchFlights(origin, dest);
                        if (flights.isEmpty()) {
                            System.out.println("No flights found.");
                        } else {
                            System.out.println("Flights Found:");
                            for (Flight f : flights) {
                                System.out.println("- Flight ID: " + f.getFlightId() + 
                                    ", Fare: ₹" + f.getFare() + 
                                    ", Seats: " + f.getAvailableSeats());
                            }
                        }
                        break;

                    case 2:
                        System.out.print("Enter Flight ID: ");
                        String flightId = sc.next();
                        Flight flight = flightService.getFlight(flightId);

                        System.out.print("Enter Passenger Name: ");
                        String name = sc.next();
                        System.out.print("Enter Age: ");
                        int age = sc.nextInt();
                        System.out.print("Enter Passport Number: ");
                        String passport = sc.next();

                        Passenger p = new Passenger(name, age, passport);
                        Booking booking = bookingService.bookFlight(flight, p);
                        System.out.println("Booking Confirmed: " + booking);
                        break;

                    case 3:
                        System.out.println("All Bookings:");
                        for (Booking b : bookingService.getAllBookings()) {
                            System.out.println(b);
                        }
                        break;

                    case 4:
                        System.out.println("Exiting... Thank you!");
                        sc.close();
                        System.exit(0);
                        break;

                    default:
                        System.out.println("Invalid option.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
