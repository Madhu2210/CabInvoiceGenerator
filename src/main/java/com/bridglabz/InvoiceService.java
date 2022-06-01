package com.bridglabz;

public class InvoiceService {
    private static final double COST_PER_KM = 10;
    private static final int COST_PER_MINUTE = 1;
    private final double MINIMUM_FARE = 5;

    public static void main(String[] args) {
        System.out.println("Welcome in Cab Invoice calculator");
    }

    public double calculateFare(double distance, int time) {
        double totalFare = distance * COST_PER_KM + time * COST_PER_MINUTE;
        if (totalFare < MINIMUM_FARE)
            return MINIMUM_FARE;
        return totalFare;
    }

    public double calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += calculateFare(ride.getDistance(), ride.getTime());
        }
        return totalFare;
    }
}
