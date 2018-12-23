package com.ticker.services;

import com.ticker.services.exception.TickerServiceException;
import com.ticker.services.extrading.response.HistoricalDataResponse;
import com.ticker.services.request.HistoricalDataRequest;

public interface TickerDetailService {

    HistoricalDataResponse getHistoricalData(HistoricalDataRequest.IntervalType intervalType, int range, String ticker) throws TickerServiceException;

}
