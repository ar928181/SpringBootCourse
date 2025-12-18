package com.example.microservices.limits_service.bean;

public class Limits {
    private int minimum;

    public Limits(int minimum, int maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

    public Limits() {
    }

    @Override
    public String toString() {
        return "Limits{" +
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

    private int maximum;
}
