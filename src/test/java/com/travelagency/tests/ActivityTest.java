package test.java.com.travelagency.tests;

import main.java.com.travelagency.core.Acitivity;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ActivityTest {
    @Test
    public void testActivityCreation() {
        Acitivity activity = new Acitivity("Eiffel Tower", "Guided Tour of Eiffel Tower", 50.0, 10);
        assertEquals("Eiffel Tower Tour", activity.getName());
        assertEquals("Guided Tour of Eiffel Tower", activity.getDescription());
        assertEquals(50.0, activity.getCost());
        assertEquals(10, activity.getCapacity());
    }
}


