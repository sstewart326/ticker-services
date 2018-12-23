package com.ticker.services.controller;

import com.ticker.services.TickerDetailService;
import com.ticker.services.exception.TickerServiceException;
import com.ticker.services.extrading.response.HistoricalDataResponse;
import com.ticker.services.request.HistoricalDataRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/rest/1.0")
public class TickerDetailsController {

    @Autowired
    private TickerDetailService detailService;

    @GetMapping("/health-check")
    @ResponseBody
    public String healthCheck() {
        return "\"status\":\"success\"";
    }

    @PostMapping("/get-historical-data")
    @ResponseBody
    public HistoricalDataResponse getHistoricalData(@RequestBody HistoricalDataRequest request) throws TickerServiceException {
        if (!assertNotNull(request.getIntervalType(), request.getRange(), request.getTicker())) {
            throw new TickerServiceException("Invalid Request! Essential field was null");
        }

        return detailService.getHistoricalData(request.getIntervalType(), request.getRange(), request.getTicker());
    }

    private boolean assertNotNull(Object... objects) {
        for (int i = 0 ; i<objects.length; i++) {
            if (objects[i] == null) {
                return false;
            }
        }
        return true;
    }
}

