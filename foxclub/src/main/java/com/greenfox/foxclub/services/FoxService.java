package com.greenfox.foxclub.services;

import com.greenfox.foxclub.models.Drink;
import com.greenfox.foxclub.models.Food;
import com.greenfox.foxclub.models.Fox;
import com.greenfox.foxclub.repositories.FoxVillage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoxService {
    private FoxVillage foxVillage;

    @Autowired
    public FoxService(FoxVillage foxVillage) {
        this.foxVillage = foxVillage;
    }

    public boolean tryToAccommodateNewFox(String name) {
        return foxVillage.accommodateNewFox(name);
    }

    public Fox getFox(String name) {
        return foxVillage.getFox(name);
    }

    public void setFood(Fox fox, Food food) {
        foxVillage.setFood(fox, food);
    }

    public void setDrink(Fox fox, Drink drink) {
        foxVillage.setDrink(fox, drink);
    }

    public List<String> getLearnableTricks(String name) {
        return foxVillage.getLearnableTricks(name);
    }

    public void setLearnableTrick(String name, String trick) {
        foxVillage.setTrick(name, trick);
    }
}
