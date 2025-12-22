package com.example.microservices.currency_exchange_service.currency;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);
    @Autowired
    private CurrencyExchangeRepo currencyExchangeRepo;
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange from(@PathVariable String from, @PathVariable String to) {
//        CurrencyExchange currenyExchange = new CurrencyExchange(1000L, from, to, BigDecimal.valueOf(50));
//        currency-exchange-service,6949224d1ad7a759e60ee30b916ad7d6,e60ee30b916ad7d6
        logger.info("Current Currency Exchange from {}, to {}", from, to);

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
