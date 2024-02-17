package test.java.com.travelagency.tests;

import main.java.com.travelagency.core.Acitivity;
import main.java.com.travelagency.core.Passenger;
import main.java.com.travelagency.core.PassengerType;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PassengerTest {
    @Test
    public void testPassengerCreation() {
        Passenger passenger = new Passenger("Nitish", 1, PassengerType.STANDARD);
        assertEquals("Nitish", passenger.getName());
        assertEquals(1, passenger.getPassengerNumber());
        assertEquals(PassengerType.STANDARD, passenger.getPassengerType());
        assertEquals(0.0, passenger.getBalance(), 0.001);
    }

    @Test
    public void testActivity() {
        Passenger passenger = new Passenger("Nitish", 1, PassengerType.STANDARD);
        Acitivity activity = new Acitivity("Eiffel Tower", "Guided Tour of the Eiffel Tower", 50.0, 10);
        passenger.addAcivity(activity);
        List<Acitivity> activities = passenger.getActivities();
        assertEquals(1, activities.size());
        assertTrue(activities.contains(activity));
    }
}
