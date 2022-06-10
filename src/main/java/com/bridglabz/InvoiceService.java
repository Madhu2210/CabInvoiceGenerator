package com.bridglabz;

import java.util.List;

public class InvoiceService {
    private static final double COST_PER_KM = 10;
    private static final int COST_PER_MINUTE = 1;
    private static final double MINIMUM_FARE = 5;
    private static final double PREMIUM_COST_PER_KM = 15.0;
    private static final int PREMIUM_COST_PER_MINUTES = 2;
    private static final double PREMIUM_MIN_FARE = 20;

    public static void main(String[] args) {

        System.out.println("Welcome in Cab Invoice calculator");
    }

    public double calculateFare(double distance, int time, String rideType) {
        if(rideType.equals("Normal")) {
            return calculateFare(distance, time);
        }
        else {
            double fare = distance * PREMIUM_COST_PER_KM + time * PREMIUM_COST_PER_MINUTES;
            return Math.max(fare, PREMIUM_MIN_FARE);
        }
    }

    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += this.calculateFare(ride.getDistance(), ride.getTime(), ride.getRideType());
        }
        System.out.println("Number of rides: "+rides.length+" Fare: "+totalFare);
        return new InvoiceSummary(rides.length, totalFare);
    }

    public double calculateFares(Ride[] rides) {
        double totalFare = 0.0;
        for (Ride ride : rides) {
            totalFare += calculateFare(ride.getDistance(), ride.getTime(), ride.getRideType());
        }
        return totalFare;
    }

    public InvoiceSummary GetInvoiceSummary(String userName) {

        List<Ride> list = UserAccount.userMap.get(userName);
        double totalFare = 0.0;
        int rideCount = 0;
        for (Ride ride : list)
        {
            totalFare += calculateFare(ride.getDistance(), ride.getTime(), ride.getRideType());
            rideCount++;
        }

        return new InvoiceSummary(rideCount, totalFare);
    }

    public double calculateFare(double distance, int time) {

        double fare = distance * COST_PER_KM + time * COST_PER_MINUTE;
        return Math.max(fare, MINIMUM_FARE);
    }
}
