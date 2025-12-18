package com.example.microservices.currency_conversion_service.currency_conversion;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;

//@FeignClient(name = "currency-exchange",url="localhost:8000")
@FeignClient(name = "currency-exchange-service")
public interface CurrecnyExchangeProxy {
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion retriveExchangeValue(
            @PathVariable String from,
            @PathVariable String to
    );
}
