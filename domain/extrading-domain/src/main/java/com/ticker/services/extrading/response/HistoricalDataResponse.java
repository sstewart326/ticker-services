package com.ticker.services.extrading.response;

import lombok.Data;
import lombok.Singular;

import java.util.Set;

@Data
public class HistoricalDataResponse {

    private DailyData[] dailyData;

}
