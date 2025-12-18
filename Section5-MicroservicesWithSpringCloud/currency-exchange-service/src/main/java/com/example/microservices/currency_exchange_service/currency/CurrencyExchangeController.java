package com.example.microservices.currency_exchange_service.currency;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {
    @Autowired
    private Environment env;

    @Autowired
    private CurrencyExchangeRepo currencyExchangeRepo;
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange from(@PathVariable String from, @PathVariable String to) {
//        CurrencyExchange currenyExchange = new CurrencyExchange(1000L, from, to, BigDecimal.valueOf(50));
        CurrencyExchange currencyExchange = currencyExchangeRepo.findByFromAndTo(from, to);
        if (currencyExchange == null) {
            throw new RuntimeException("Unable to Find data for "+ from + " to " + to);
        }

        String port = env.getProperty("local.server.port");
        currencyExchange.setEnvironment(port);

        currencyExchangeRepo.findAll();
        return currencyExchange;
    }
}
