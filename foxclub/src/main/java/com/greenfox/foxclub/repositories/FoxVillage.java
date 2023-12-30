package com.greenfox.foxclub.repositories;

import com.greenfox.foxclub.models.Drink;
import com.greenfox.foxclub.models.Food;
import com.greenfox.foxclub.models.Fox;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class FoxVillage {
    private Map<String, Fox> foxes;
    private static List<String> tricks;

    public FoxVillage() {
        this.foxes = new HashMap<>();
        fillAvailableTricks();
    }

    public boolean accommodateNewFox(String name) {
        if(foxes.containsKey(name)) {
            return false;
        }
        foxes.put(name, new Fox(name));
        return true;
    }

    public Fox getFox(String name) {
        return foxes.get(name);
    }

    public void setFood(Fox fox, Food food) {
        if (fox == null) {
            return;
        }
        fox.setFood(food);
    }

    public void setDrink(Fox fox, Drink drink) {
        if (fox == null) {
            return;
        }
        fox.setDrink(drink);
    }

    public List<String> getLearnableTricks(String name) {
        if (foxes.get(name) == null) {
            return new ArrayList<>();
        }
        List<String> availableTricks = new ArrayList<>(tricks);
        availableTricks.removeAll(foxes.get(name).getTricks());

        return availableTricks;
    }

    public void setTrick(String name, String trick) {
        if (foxes.get(name) != null) {
            foxes.get(name).addTrick(trick);
        }
    }

    private void fillAvailableTricks() {
        tricks = new ArrayList<>();
        tricks.add("Code in HTML");
        tricks.add("Code in CSS");
        tricks.add("Code in JavaScript");
        tricks.add("Code in Java");
        tricks.add("Code in Python");
    }
}
