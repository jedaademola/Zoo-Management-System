package edu.mum.mpp.service;

import edu.mum.mpp.dao.AbstractDao;
import edu.mum.mpp.model.Food;
import edu.mum.mpp.util.FoodDataUtil;
import edu.mum.mpp.util.LoggerUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService extends AbstractService<Food> {

    private final static Logger logger = LoggerFactory.getLogger(FoodService.class);


    @Autowired
    public FoodService(@Qualifier("foodDao") AbstractDao<Food> dao) {
        super(dao);
    }

    public Food create(Food block) {

        FoodDataUtil.addFood(block);
        return block;
    }

    public boolean checkFood(String foodName) {

        String foodNameTemp = foodName;
        try {

            foodNameTemp = FoodDataUtil.displayFoods().stream()
                    .filter(
                            food -> food.getName().equals(foodName)
                    )
                    .map(Food::getName)
                    .findAny()
                    .orElse("");

        } catch (Exception ex) {
            logger.error(" [checkFood()]: " + ex.getMessage());
            LoggerUtil.logError(logger, ex);
        }

        return foodNameTemp.equals(foodName);

    }


    public List<Food> getFoods() {
        return FoodDataUtil.displayFoods();
    }

    public Food getSingleFood(long id) {
        Food singleFood = null;
        try {

            singleFood = FoodDataUtil.displayFoods().stream()
                    .filter(food -> food.getId() == id)
                    .findAny().get();

        } catch (Exception ex) {
            logger.error(" [getSingleFood()]: " + ex.getMessage());
            LoggerUtil.logError(logger, ex);
        }

        return singleFood;
    }


    public Food editFood(Food food) {
        FoodDataUtil.editFood(food);
        return food;

    }
}

