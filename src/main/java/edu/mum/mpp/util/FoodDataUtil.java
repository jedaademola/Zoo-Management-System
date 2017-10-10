package edu.mum.mpp.util;

import edu.mum.mpp.model.Food;
import edu.mum.mpp.model.LabelValue;

import java.util.ArrayList;
import java.util.List;

public class FoodDataUtil {

    public static List<Food> foodList = new ArrayList<>();
    private static long lastId;


    public static List<LabelValue> getFoodListForDropDown() {

        List<LabelValue> selectItems = new ArrayList<>();

        for (Food b : displayFoods()) {

            LabelValue l = new LabelValue();
            l.setLabel(b.getName());
            l.setValue(b.getId());
            selectItems.add(l);


        }

        return selectItems;
    }

    public static List<Food> displayFoods() {

        if (foodList.size() < 1) {

            for (int k = 1; k <= 5; ++k) {
                Food newFood = new Food();
                newFood.setId(k);
                newFood.setName("Food" + k);

                lastId = k;

                foodList.add(newFood);
            }
        }

        return foodList;
    }

    public static void addFood(Food newBlock) {
        lastId = lastId + 1;

        newBlock.setId(lastId);
        foodList.add(newBlock);
    }

    public static void editFood(Food newFood) {
        int idTemp = (int) newFood.getId();
        foodList.set(idTemp - 1, newFood);
    }
}
