package com.ticker.services.exception;

public class TickerServiceException extends Exception {


    public TickerServiceException(String errorMessage) {
        super(errorMessage);
    }

    public TickerServiceException(String errorMessage, Throwable error) {
        super(errorMessage, error);
    }

}
