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
        double totalFare = invoiceService.calculateFare(2.0, 5);
        Assert.assertEquals(25, totalFare, 0.0);
    }

    @Test
    public void givenLessDistanceAndTimeTest2_whenCalculateFare_shouldReturnTotalFare() {
        double distance = 0.1;
        int time = 1;
        double totalFare = invoiceService.calculateFare(1.0, 5);
        Assert.assertEquals(15, totalFare, 0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnInvoiceSummary() {
        Ride[] rides = {
                new Ride(2.0, 5, "Normal"),
                new Ride(0.1, 5, "Normal"),
        };
        InvoiceSummary summary = invoiceService.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 31.0);
        Assert.assertEquals(expectedInvoiceSummary, summary);
    }
    @Test
    public void givenUserID_whenCalculateFare_shouldReturnAggregateSummery() {
        InvoiceService invoiceService=new InvoiceService();
        String userName="Madhu";
        List<Ride> rideList=new ArrayList<>();

        rideList.add(new Ride(2.0,5, "Normal"));
        rideList.add(new Ride(1.0,5, "Premium"));
        new UserAccount(userName,rideList);
        InvoiceSummary expectedSummary= new InvoiceSummary(2,50.0);
        InvoiceSummary actualSummary= invoiceService.GetInvoiceSummary(userName);
        //  InvoiceSummery actualSummery=invoiceService.calculateFare(rides);
        Assert.assertEquals(expectedSummary,actualSummary);
    }
    @Test
    public void givenUserIDPremiumRides_whenCalculateFare_shouldReturnAggregateSummery() {
        InvoiceService invoiceService=new InvoiceService();

        String userName="Madhu";
        List<Ride> rideList=new ArrayList<>();

        rideList.add(new Ride(2.0,5, "Normal"));
        rideList.add(new Ride(1.0,5, "Premium"));
        rideList.add(new Ride(0.1,1,"Premium"));

        new UserAccount(userName,rideList);

        InvoiceSummary actualSummary= invoiceService.GetInvoiceSummary(userName);
        InvoiceSummary expectedSummary= new InvoiceSummary(3,70.0);

        Assert.assertEquals(expectedSummary,actualSummary);
    }
}




