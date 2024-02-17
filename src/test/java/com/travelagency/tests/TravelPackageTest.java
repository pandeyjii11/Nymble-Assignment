package test.java.com.travelagency.tests;

import main.java.com.travelagency.core.Destination;
import main.java.com.travelagency.core.Passenger;
import main.java.com.travelagency.core.PassengerType;
import main.java.com.travelagency.core.TravelPackage;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TravelPackageTest {
    @Test
    public void testTravelPackageCreation() {
        TravelPackage travelPackage = new TravelPackage("Europe Tour", 20);
        assertEquals("Europe Tour", travelPackage.getName());
        assertEquals(20, travelPackage.getPassengerCapacity());
    }

    @Test
    public void testAddDestination() {
        TravelPackage travelPackage = new TravelPackage("Europe Tour", 20);
        Destination destination = new Destination("Paris");
        travelPackage.addDestination(destination);
        List<Destination> destinations = travelPackage.getDestinations();
        assertEquals(1, destinations.size());
        assertTrue(destinations.contains(destination));
    }

    @Test
    public void testAddPassenger() {
        TravelPackage travelPackage = new TravelPackage("Europe Tour", 20);
        Passenger passenger = new Passenger("Nitish", 1, PassengerType.STANDARD);
        travelPackage.addPassenger(passenger);
        List<Passenger> passengers = travelPackage.getPassengers();
        assertEquals(1, passengers.size());
        assertTrue(passengers.contains(passenger));
    }
}
