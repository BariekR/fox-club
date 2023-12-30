package com.greenfox.foxclub.models;

public enum Food {
    SALMON("Salmon"),
    VEGGIES("Veggies"),
    MCDONALD("McDonald");

    private final String name;

    Food(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }
}
