package com.ticker.services.extrading.response;

import org.junit.Ignore;
import org.junit.Test;

public class HistoricalDataResponseTest {

    @Test
    @Ignore
    public void printResponse() {
        HistoricalDataResponse response = new HistoricalDataResponse();
        DailyData[] dataarray = new DailyData[2];
        DailyData data = new DailyData();
        data.setOpen(11);
        data.setClose(12);
        dataarray[0] = data;
        data.setOpen(14);
        data.setClose(18);
        dataarray[1] = data;
        response.setDailyData(dataarray);
        System.out.println(response);
    }
}
