package com.ticker.services.impl;

import com.ticker.services.TickerDetailService;
import com.ticker.services.exception.TickerServiceException;
import com.ticker.services.extrading.response.HistoricalDataResponse;
import com.ticker.services.request.HistoricalDataRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TickerDetailServiceImpl implements TickerDetailService {

    private static final String YEAR = "y";
    private static final String MONTH = "m";
    private static final String DAY = "d";
    private static final String TICKER_REPLACEMENT_TOKEN = "$ticker";

    @Value("${iextrading.historical.data.url.prefix}")
    private String urlPrefix;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public HistoricalDataResponse getHistoricalData(HistoricalDataRequest.IntervalType intervalType, int range, String ticker) throws TickerServiceException {
        String url;
        urlPrefix = urlPrefix.replace(TICKER_REPLACEMENT_TOKEN, ticker);
        if (HistoricalDataRequest.IntervalType.YEARS == intervalType) {
            url = urlPrefix.concat(String.valueOf(range)).concat(YEAR);
        } else if (HistoricalDataRequest.IntervalType.MONTHS == intervalType) {
            url = urlPrefix.concat(String.valueOf(range)).concat(MONTH);
        } else if (HistoricalDataRequest.IntervalType.DAYS == intervalType) {
            url = urlPrefix.concat(String.valueOf(range)).concat(DAY);
        } else {
            throw new TickerServiceException("Could not resolve interval type: " + String.valueOf(intervalType));
        }
        return restTemplate.getForEntity(url, HistoricalDataResponse.class).getBody();
    }
}
