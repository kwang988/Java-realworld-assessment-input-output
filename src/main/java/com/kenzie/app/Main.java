package com.kenzie.app;

import java.io.IOException;
import java.util.List;

// import necessary libraries

enum FruitCriteria {
    ALL,
    LOW_CARB,
    HIGH_CALORIE
}

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        // do not change code in main()
        String allFruitsDesiredUrl = FruitHttpClient.getDesiredURL(FruitCriteria.ALL);
        String lowCarbFruitsDesiredUrl = FruitHttpClient.getDesiredURL(FruitCriteria.LOW_CARB);
        String highCalorieFruitsDesiredUrl = FruitHttpClient.getDesiredURL(FruitCriteria.HIGH_CALORIE);
        FruitHttpClient fruitHttpClient = new FruitHttpClient();

        // get all fruits and print them
        String allFruitsResponseBody = fruitHttpClient.getFruits(allFruitsDesiredUrl);
        List<FruitDTO> allFruits = fruitHttpClient.getFruitsList(allFruitsResponseBody);
        System.out.println("Here is a list of all fruits: ");
        for(FruitDTO fruit : allFruits){
            System.out.println(fruit.toString());
        }
        System.out.println("");

        // get low carb fruits and print them
        String lowCarbFruitsResponseBody = fruitHttpClient.getFruits(lowCarbFruitsDesiredUrl);
        List<FruitDTO> lowCarbFruits = fruitHttpClient.getFruitsList(lowCarbFruitsResponseBody);
        System.out.println("Here is a list of low-carb fruits: ");
        for(FruitDTO fruit : lowCarbFruits){
            System.out.println(fruit.toString());
        }
        System.out.println("");

        // get high calorie fruits and print them
        String highCalorieFruitsResponseBody = fruitHttpClient.getFruits(highCalorieFruitsDesiredUrl);
        List<FruitDTO> highCalorieFruits = fruitHttpClient.getFruitsList(highCalorieFruitsResponseBody);
        System.out.println("Here is a list of high-calorie fruits: ");
        for(FruitDTO fruit : highCalorieFruits){
            System.out.println(fruit.toString());
        }
        System.out.println("");
    }
}
