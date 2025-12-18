package com.example.microservices.limits_service.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@ConfigurationProperties("limits-service")
@Component
public class Configuration {
    private int minimum;
    private int maximum;
    public Configuration(int minimum, int maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public Configuration() {
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "minimum=" + minimum +
                ", maximum=" + maximum +
                '}';
    }

    public int getMinimum() {
        return minimum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }

    public int getMaximum() {
        return maximum;
    }

    public void setMaximum(int maximum) {
        this.maximum = maximum;
    }


}
