package main.java.com.travelagency.core;

import java.util.ArrayList;
import java.util.List;

public class Passenger {
    private String name;
    private int passengerNumber;
    private PassengerType passengerType;
    private double balance;
    private List<Acitivity> activities;

    public Passenger(String name, int passengerNumber, PassengerType passengerType) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.passengerType = passengerType;
        this.activities = new ArrayList<>();
    }

    public void addAcivity(Acitivity activity) {
        activities.add(activity);
    }

    public String getName() {
        return name;
    }

    public int getPassengerNumber() {
        return passengerNumber;
    }

    public PassengerType getPassengerType() {
        return passengerType;
    }

    public void setBalance(double deduction) {
        this.balance -= deduction;
    }

    public double getBalance() {
        return balance;
    }

    public List<Acitivity> getActivities() {
        return activities;
    }
}
