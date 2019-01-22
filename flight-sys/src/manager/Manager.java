/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Samiya Fasihuddin
 */
public class Manager {
    
    private static List<Flight> flights;
    private static List<Ticket> tickets;
    
    /**
     * populates flight and ticket arrays
     */
    public static void createFlights() {
        flights = new ArrayList<Flight>();
        tickets = new ArrayList<Ticket>();
    }
    
    /**
     * displays all available flights
     * @param origin
     * @param destination 
     */
    public static void displayAvailableFlights(String origin, String destination) {
        for (Flight flight : flights) {
            if (flight.getOrigin().equals(origin) && flight.getDestination().equals(destination) && flight.getNumberOfSeatsLeft() > 0) {
                System.out.println(flight.toString());
            }
        }
    }
    
    /**
     * Get flight based on flight number from flights array
     * @param flightNumber
     * @return 
     */
    public static Flight getFlight(int flightNumber) {
        for (Flight flight : flights) {
            if (flight.getFlightNumber() == flightNumber) {
                return flight;
            }
        }      
        return null;
    }
    
    /**
     * 
     * @param flightNumber
     * @param p 
     */
    public static void bookSeat(int flightNumber, Passenger p) {
        Flight flight = getFlight(flightNumber);
        
        if (flight != null) {
            flight.bookASeat();
            double price = p.applyDiscount(flight.getOriginalPrice());
            Ticket ticket = new Ticket(p, flight, price);
            tickets.add(ticket);
        }
    }
    
    public static void main(String[] args) {
        createFlights();        
        
        Flight flight = new Flight(1234, "Toronto", "Kolkata", 10, 1000, "5pm");
        Flight flight1 = new Flight(5678, "Kolkata", "Toronto", 10, 1000, "5pm");
        flight1.setNumberOfSeatsLeft(0);
   
        
        flights.add(flight);
        flights.add(flight1);
        
        displayAvailableFlights("Toronto", "Kolkata");
        displayAvailableFlights("Kolkata", "Toronto");
        
        Flight flight2 = getFlight(5678);
        System.out.println("Printing Flight: " + flight2.toString());
        
        Member member = new Member("John", 50, 5);
        bookSeat(1234, member);
        
        displayAvailableFlights("Toronto", "Kolkata");
    }
}
