package com.ticker.services.request;

import lombok.Data;

@Data
public class HistoricalDataRequest {

    public enum IntervalType {
        DAYS, MONTHS, YEARS
    }

    private int range;
    private IntervalType intervalType;
    private String ticker;

}
