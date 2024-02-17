package main.java.com.travelagency;

import main.java.com.travelagency.core.*;

public class main {

    //Method to print Itenary Details of the Travel Package
    public static void printItenary(TravelPackage travelPackage) {
        System.out.println("Travel Package: " + travelPackage.getName());
        for(Destination destination: travelPackage.getDestinations()) {
            System.out.println("Destination: " + destination.getName());
            for(Acitivity activity: destination.getActivities()) {
                System.out.println("Activity: " + activity.getName() + ", Cost: Rs " + activity.getCost() + ", Capacity: " + activity.getCapacity() +" Person(s)");
            }
        }
    }

    //Method to print Passenger List of the Travel Package
    public static void printPassengerList(TravelPackage travelPackage) {
        System.out.println("Travel Package: " + travelPackage.getName());
        System.out.println("Passenger Capacity: " + travelPackage.getPassengerCapacity());
        System.out.println("Number of Passengers Enrolled: " + travelPackage.getPassengers().size());
        for(Passenger passenger: travelPackage.getPassengers()) {
            System.out.println("Passenger: " + passenger.getName() + ", Number: " + passenger.getPassengerNumber());
        }
    }

    //Metod to print the details of Individual Passenger
    public static void printPassengerDetails(Passenger passenger, TravelPackage travelPackage) {
        System.out.println("Name: " + passenger.getName());
        System.out.println("Passenger Number: " + passenger.getPassengerNumber());
        if(passenger.getPassengerType() == PassengerType.STANDARD || passenger.getPassengerType() == PassengerType.GOLD) {
            System.out.println("Balance: Rs " + passenger.getBalance());
        }
        System.out.println("Activities: ");
        for(Acitivity activity: passenger.getActivities()) {
            System.out.println("- " + activity.getName() + " (Destination: " + getActivityDestination(activity, travelPackage) + ", Cost: Rs " + activity.getCost() + " )");
        }
    }

    //Method to get Destination of an particular Activity
    public static String getActivityDestination(Acitivity activity, TravelPackage travelPackage) {
        for(Destination destination: travelPackage.getDestinations()) {
            if(destination.getActivities().contains(activity)) {
                return destination.getName();
            }
        }
        return "Unknown";
    }

    //Method to print details of the activities with available spaces
    public static void printAvilableActivities(TravelPackage travelPackage) {
        for(Destination destination: travelPackage.getDestinations()) {
            for(Acitivity activity: destination.getActivities()) {
                int remainingCapacity = activity.getCapacity() - countActivityParticipants(travelPackage, activity);
                if(remainingCapacity > 0) {
                    System.out.println("Activity: " + activity.getName() + ", Destinaation: " + destination.getName() + ", Avail Spaces: " + remainingCapacity);
                }
            }
        }
    }

    //Method to Count Psrticipants of an Activity
    public static int countActivityParticipants(TravelPackage travelPackage, Acitivity activity) {
        int count=0;
        for(Passenger passenger: travelPackage.getPassengers()) {
            if(passenger.getActivities().contains(activity)) {
                count++;
            }
        }
        return count;
    }

    public static void addActivityToPassengerActivityList(Passenger passenger, Acitivity activity, TravelPackage travelPackage) {
        int remaningCapacity = activity.getCapacity() - countActivityParticipants(travelPackage, activity);
        if(remaningCapacity <= 0) {
            System.out.println("No more Enrollments, Capacity Full");
        }
        else if(passenger.getPassengerType() == PassengerType.PREMIUM) {
            passenger.addAcivity(activity);
            System.out.println("Activity Added Successfully");
        }
        else if(passenger.getPassengerType() == PassengerType.GOLD) {
            double actualCost = activity.getCost() - (0.10*activity.getCost());
            if(passenger.getBalance() < actualCost) {
                System.out.println("Insufficient Balance");
            }
            else
            {
                passenger.addAcivity(activity);
                passenger.setBalance(actualCost);
                System.out.println("Activity Added Successfully");
            }
        }
        else
        {
            if(passenger.getBalance() < activity.getCost())
            {
                System.out.println("Insufficient Balance");
            }
            else
            {
                passenger.addAcivity(activity);
                passenger.setBalance(activity.getCost());
                System.out.println("Activity Added Successfully");
            }
        }
    }

    //Main Method
    public static void main(String[] args) {
        TravelPackage travelPackage = new TravelPackage("Europe Tour", 20);

        //Create Destination
        Destination paris = new Destination("Paris");
        Destination rome = new Destination("Rome");

        //Create Activities
        Acitivity eiffelTowerTour = new Acitivity("Eiffel Tower Tour", "Giuded tour of Eiffel Tower", 50.00, 10);
        Acitivity louvreMuseumVisit = new Acitivity("Louvre Museum Visit", "Giuded tour of Louvre Museum", 40.00, 15);
        Acitivity colosseumTour = new Acitivity("Colosseum Tour", "Giuded tour of Colosseumm", 60.00, 12);
        Acitivity vaticanMuseumVisit = new Acitivity("Vatican Museum Visit", "Giuded tour of Vatican Museum", 55.00, 18);

        //Add Acitivites to Destinations
        paris.addActivity(eiffelTowerTour);
        paris.addActivity(louvreMuseumVisit);
        rome.addActivity(colosseumTour);
        rome.addActivity(vaticanMuseumVisit);

        //Add Destinations to Travel Package
        travelPackage.addDestination(paris);
        travelPackage.addDestination(rome);

        //Cretae Passengers
        Passenger passenger1 = new Passenger("Nitish", 1, PassengerType.STANDARD);
        Passenger passenger2 = new Passenger("Sahil", 2, PassengerType.GOLD);
        Passenger passenger3 = new Passenger("Keshav", 3, PassengerType.PREMIUM);

        //Add Passengers to the Travel Package
        travelPackage.addPassenger(passenger1);
        travelPackage.addPassenger(passenger2);
        travelPackage.addPassenger(passenger3);

        //Print Itinerary
        System.out.println("Travel Package Itinerary");
        printItenary(travelPackage);

        //Print Passenger List
        System.out.println("Passenger List");
        printPassengerList(travelPackage);

        //print details of an Individual Passenger
        System.out.println("Details of Passenger");
        printPassengerDetails(passenger1, travelPackage);

        //Print Details of activities with available spaces
        System.out.println("Activities with available spaces");
        printAvilableActivities(travelPackage);
    }
}
