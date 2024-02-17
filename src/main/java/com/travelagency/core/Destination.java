package main.java.com.travelagency.core;

import java.util.ArrayList;
import java.util.List;

public class Destination {
    private String name;
    private List<Acitivity> activites;

    public Destination(String name) {
        this.name = name;
        this.activites = new ArrayList<>();
    }

    public void addActivity(Acitivity activity) {
        activites.add(activity);
    }

    public String getName() {
        return name;
    }

    public List<Acitivity> getActivities() {
        return activites;
    }
}
