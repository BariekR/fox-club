package com.greenfox.foxclub.models;

public enum Drink {
    BEER("Beer"),
    MILK("Milk"),
    COKE("Coke");

    private final String name;

    Drink(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }
}
