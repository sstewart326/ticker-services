package com.ticker.services.extrading.response;

import lombok.Data;

@Data
public class DailyData {

    private String date;
    private double open;
    private double close;
    private double high;
    private double low;
    private long volume;
    private long unadjustedVolume;
    private double change;
    private double changePercent;
    private double vwap;
    private String label;
    private double changeOverTime;

}
