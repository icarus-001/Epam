package com.epam.collections.queue;

import java.util.ArrayList;
import java.util.List;

public class DishOrderDeterminer {
    public List<Integer> determineDishOrder(int numberOfDishes, int everyDishNumberToEat) {

        List<Integer> result = new ArrayList<>();
        if (numberOfDishes == 0) {
            return result;
        }

        int currentDish = 1;

        while (result.size() < numberOfDishes) {
            result.add(currentDish);
            currentDish = (currentDish + everyDishNumberToEat - 1) % numberOfDishes + 1;
        }

        return result;
    }
}