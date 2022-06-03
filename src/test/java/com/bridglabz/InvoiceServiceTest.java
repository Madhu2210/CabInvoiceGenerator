package com.bridglabz;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        Ride[] rides = {
                new Ride(2.0, 5),
                new Ride(0.1, 1),
        };
        InvoiceSummary summary = invoiceService.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }
    @Test
    public void givenUserID_whenCalculateFare_shouldReturnAggregareSummery() {
        InvoiceService invoiceService=new InvoiceService();

        String userName="Madhu";
        List<Ride> rideList=new ArrayList<>();

        rideList.add(new Ride(2.0,5));
        rideList.add(new Ride(1.0,5));
        new UserAccount(userName,rideList);
        InvoiceSummary actualSummery= invoiceService.GetInvoiceSummary(userName);
        InvoiceSummary expectedSummery= new InvoiceSummary(2,40.0);
        //  InvoiceSummery actualSummery=invoiceService.calculateFare(rides);
        Assert.assertEquals(expectedSummery,actualSummery);
    }
}




