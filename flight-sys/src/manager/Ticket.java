/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

/**
 *
 * @author Samiya Fasihuddin
 */
public class Ticket {

    private Passenger passenger;
    private Flight flight;
    private double price;
    private static int number;

    public Ticket(Passenger passenger, Flight flight, double price) {
        this.passenger = passenger;
        this.flight = flight;
        this.price = price;
    }

    /**
     * @return the passenger
     */
    public Passenger getPassenger() {
        return passenger;
    }

    /**
     * @param passenger the passenger to set
     */
    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    /**
     * @return the flight
     */
    public Flight getFlight() {
        return flight;
    }

    /**
     * @param flight the flight to set
     */
    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the number
     */
    public static int getNumber() {
        return number;
    }

    /**
     * @param aNumber the number to set
     */
    public static void setNumber(int aNumber) {
        number = aNumber;
    }

    @Override
    public String toString() {

        return getPassenger().getName() + ", Flight " + flight + ", "
                + flight.getOrigin() + " to " + flight.getDestination()
                + ", " + flight.getDepartureTime() + ", original price: "
                + flight.getOriginalPrice() + ", ticket price: " + price;

    }

}
