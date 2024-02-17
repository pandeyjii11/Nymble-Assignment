package test.java.com.travelagency.tests;

import main.java.com.travelagency.core.Acitivity;
import main.java.com.travelagency.core.Destination;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DestinationTest {
    @Test
    public void testDestinationCreation() {
        Destination destination = new Destination("Paris");
        assertEquals("Paris", destination.getName());
    }

    @Test
    public void testAddActivity() {
        Destination destination = new Destination("Paris");
        Acitivity activity = new Acitivity("Eiffel Tower Tour", "Guided Tour of Eiffel Tower", 50.0, 10);
        destination.addActivity(activity);
        List<Acitivity> activities = destination.getActivities();
        assertEquals(1, activities.size());
        assertTrue(activities.contains(activity));
    }
}




