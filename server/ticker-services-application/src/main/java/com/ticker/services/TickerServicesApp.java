package com.ticker.services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan("com.ticker.services")
public class TickerServicesApp {

    public static void main(String[] args) {
        SpringApplication.run(TickerServicesApp.class, args);
    }

}
