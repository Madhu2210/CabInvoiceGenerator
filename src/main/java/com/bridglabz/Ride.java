package com.bridglabz;

public class Ride {
    private int time;
    private double distance;
    private String rideType;

    public String getRideType() {
        return rideType;
    }

    public void setRideType(String rideType) {
        this.rideType = rideType;
    }

    public Ride(double distance, int time, String rideType) {
        this.distance = distance;
        this.time = time;
        this.rideType = rideType;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {

        this.time = time;
    }

    public double getDistance() {

        return distance;
    }

    public void setDistance(double distance) {

        this.distance = distance;
    }
}
