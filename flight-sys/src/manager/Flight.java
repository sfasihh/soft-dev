package manager;

/**
 * @author Samiya Fasihuddin
 */
public class Flight {

    private int flightNumber;
    private String origin;
    private String destination;
    private String departureTime;
    private int capacity;
    private int numberOfSeatsLeft;
    private double originalPrice;
/**
 * 
 */
    
    public Flight(int flightNumber, String origin, String destination, int capacity, double originalPrice, String departureTime) {
        this.flightNumber = flightNumber;

        if (origin.equalsIgnoreCase(destination)) {
            throw new IllegalArgumentException("Origin is same as Destination");
        }

        this.origin = origin;
        this.destination = destination;
        this.capacity = capacity;
        this.numberOfSeatsLeft = capacity;
        this.originalPrice = originalPrice;
        this.departureTime = departureTime;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public String getOrigin() {
        return origin;
    }

    public String getDestination() {
        return destination;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    /**
     * bookASeat() checks if there are seats available for passengers, if true: decrements by 1.
     * @return 
     */
    public boolean bookASeat() {

        if (this.numberOfSeatsLeft > 0) {
            this.numberOfSeatsLeft = this.numberOfSeatsLeft - 1;
            return true;
        }

        return false;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public int getNumberOfSeatsLeft() {
        return numberOfSeatsLeft;
    }

    public void setNumberOfSeatsLeft(int numberOfSeatsLeft) {
        this.numberOfSeatsLeft = numberOfSeatsLeft;
    }

    /**
     * @param args the command line arguments
     */
    @Override

    public String toString() {
        return "Flight " + this.getFlightNumber() + ", " + this.getOrigin() + " to "
                + this.getDestination() + ", " + this.getDepartureTime() + ", original price: "
                + this.getOriginalPrice();
    }

    /**
     * @return the departureTime
     */
    public String getDepartureTime() {
        return departureTime;
    }

    /**
     * @param departureTime the departureTime to set
     */
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

}
