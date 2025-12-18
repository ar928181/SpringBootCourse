package com.example.microservices.currency_exchange_service.currency;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepo extends JpaRepository<CurrencyExchange, Long> {

    CurrencyExchange findByFromAndTo(String from, String to);
}
