package main.java.com.travelagency.core;

public class Acitivity {
    private String name;
    private String description;
    private double cost;
    private int capacity;

    public Acitivity(String name, String description, double cost, int capacity) {
        this.name = name;
        this.description = description;
        this.cost = cost;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getCost() {
        return cost;
    }

    public int getCapacity() {
        return capacity;
    }
}
