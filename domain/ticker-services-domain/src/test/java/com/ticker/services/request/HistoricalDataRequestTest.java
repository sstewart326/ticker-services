package com.ticker.services.request;

import org.junit.Ignore;
import org.junit.Test;

public class HistoricalDataRequestTest {

    @Test
    @Ignore
    public void printRequest() {
        HistoricalDataRequest request = new HistoricalDataRequest();
        request.setIntervalType(HistoricalDataRequest.IntervalType.MONTHS);
        request.setRange(3);
        request.setTicker("EFX");
        System.out.println(request.toString());
    }
}
