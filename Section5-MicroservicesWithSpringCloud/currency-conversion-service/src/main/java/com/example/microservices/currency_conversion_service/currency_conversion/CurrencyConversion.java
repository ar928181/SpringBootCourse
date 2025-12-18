package com.example.microservices.currency_conversion_service.currency_conversion;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class CurrencyConversion {
    private long id;
    private String from;
    private String to;
    private BigDecimal quantity;
    private BigDecimal conversionMultiple;
    private BigDecimal totalCalculatedAmount;
    private String environment;

    public CurrencyConversion(long id, String from, String to,BigDecimal quantity, BigDecimal conversionMultiple,BigDecimal totalCalculatedAmount,  String env) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversionMultiple = conversionMultiple;
        this.quantity = quantity;
        this.environment = env;
        this.totalCalculatedAmount = totalCalculatedAmount;
    }
}
