package com.bridglabz;

import java.util.Objects;

public class InvoiceSummary {
    private final int numOfRides;
    private final double totalFare;
    private final Object averageFare;

    public InvoiceSummary(int numOfRides, double totalFare) {
        this.numOfRides = numOfRides;
        this.totalFare= totalFare;
        this.averageFare= this.totalFare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummary that = (InvoiceSummary) o;
        return numOfRides == that.numOfRides &&
                Double.compare(that.totalFare, totalFare) == 0 &&
                Objects.equals(averageFare, that.averageFare);
    }

}
