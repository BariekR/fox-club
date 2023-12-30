package com.greenfox.foxclub.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Fox {
    private String name;
    private Food food;
    private Drink drink;
    private List<String> tricks;

    public Fox(String name) {
        this.name = name;
        this.food = Food.MCDONALD;
        this.drink = Drink.COKE;
        this.tricks = new ArrayList<>();
    }

    public void addTrick(String trick) {
        tricks.add(trick);
    }
}
