package com.bridglabz;

import org.junit.Assert;
import org.junit.Test;

public class InvoiceServiceTest {
    InvoiceService invoiceService = new InvoiceService();

    @Test
    public void givenDistanceAndTime_whenCalculateFare_shouldReturnTotalFare() {
        double distance = 2.0;
        int time = 5;
        double totalFare = invoiceService.calculateFare(distance, time);
        Assert.assertEquals(25, totalFare, 0.0);
    }

    @Test
    public void givenLessDistanceAndTimeTest2_whenCalculateFare_shouldReturnTotalFare() {
        double distance = 0.1;
        int time = 1;
        double totalFare = invoiceService.calculateFare(distance, time);
        Assert.assertEquals(5, totalFare, 0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnTotalFare() {
        Ride[] rides = {
                new Ride(2.0, 5),
                new Ride(0.1, 1),
        };
        double totalFare = invoiceService.calculateFare(rides);
        Assert.assertEquals(30, totalFare, 0.0);
    }

}

