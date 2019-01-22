/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manager;

import manager.Flight;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Samiya Fasihuddin
 */
public class FlightTest {
    
    @Test
    public void testConstructor() {
        Flight flight = new Flight(1234, "Toronto", "Kolkata", 10, 1000, "5pm");
                
        Assert.assertEquals(1234, flight.getFlightNumber());
        Assert.assertEquals("Toronto", flight.getOrigin());
        Assert.assertEquals("Kolkata", flight.getDestination());
        Assert.assertEquals(10, flight.getCapacity());
        Assert.assertEquals(10, flight.getNumberOfSeatsLeft());
        Assert.assertEquals(1000, flight.getOriginalPrice(), 0);
        Assert.assertEquals("5pm", flight.getDepartureTime());    
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidConstructor() {
        Flight flight = new Flight(1234, "Toronto", "Toronto", 10, 1000, "5pm");   
    }
    
    @Test
    public void publicMethodTest() {
        Flight flight = new Flight(1234, "Toronto", "Kolkata", 10, 1000, "5pm");
        
        flight.setFlightNumber(12345);
        flight.setOrigin("Kolkata");
        flight.setDestination("Toronto");
        flight.setCapacity(100);
        flight.setNumberOfSeatsLeft(100);
        flight.setOriginalPrice(500);
        flight.setDepartureTime("6pm");
       
        flight.bookASeat();
        
        Assert.assertEquals(12345, flight.getFlightNumber());
        Assert.assertEquals("Kolkata", flight.getOrigin());
        Assert.assertEquals("Toronto", flight.getDestination());
        Assert.assertEquals(100, flight.getCapacity());
        Assert.assertEquals(99, flight.getNumberOfSeatsLeft());
        Assert.assertEquals(500, flight.getOriginalPrice(), 0);
        Assert.assertEquals("6pm", flight.getDepartureTime());    
        
        Assert.assertEquals("Flight 12345, Kolkata to Toronto, 6pm, original price: 500.0", flight.toString());
                
    }
}
