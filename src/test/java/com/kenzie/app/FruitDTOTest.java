package com.kenzie.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.lang.reflect.*;

public class FruitDTOTest {
    private static final String TEST_GENUS = "Fragaria";
    private static final String TEST_NAME = "Strawberry";
    private static final int TEST_ID = 1;
    private static final String TEST_FAMILY = "Rosaceae";
    private static final String TEST_ORDER = "Rosales";

    private static final double TEST_CARBOHYDRATES = 15.3;
    private static final double TEST_PROTEIN = 3.2;
    private static final double TEST_FAT = 3.1;
    private static final double TEST_CALORIES = 100.7;
    private static final double TEST_SUGAR = 12.9;

    @Test
    public void gettersAndSettersTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        FruitDTO fruitInstance = new FruitDTO();
        FruitDTO.Nutritions nutritionsInstance = new FruitDTO.Nutritions();

        // Nutritions setters
        Method setCarbohydratesMethod = FruitDTO.Nutritions.class.getMethod("setCarbohydrates", double.class);
        setCarbohydratesMethod.invoke(nutritionsInstance, TEST_CARBOHYDRATES);

        Method setProteinMethod = FruitDTO.Nutritions.class.getMethod("setProtein", double.class);
        setProteinMethod.invoke(nutritionsInstance, TEST_PROTEIN);

        Method setFatMethod = FruitDTO.Nutritions.class.getMethod("setFat", double.class);
        setFatMethod.invoke(nutritionsInstance, TEST_FAT);

        Method setCaloriesMethod = FruitDTO.Nutritions.class.getMethod("setCalories", double.class);
        setCaloriesMethod.invoke(nutritionsInstance, TEST_CALORIES);

        Method setSugarMethod = FruitDTO.Nutritions.class.getMethod("setSugar", double.class);
        setSugarMethod.invoke(nutritionsInstance, TEST_SUGAR);

        // FruitDTO setters
        Method setGenusMethod = FruitDTO.class.getMethod("setGenus", String.class);
        setGenusMethod.invoke(fruitInstance, TEST_GENUS);

        Method setNameMethod = FruitDTO.class.getMethod("setName", String.class);
        setNameMethod.invoke(fruitInstance, TEST_NAME);

        Method setIdMethod = FruitDTO.class.getMethod("setId", int.class);
        setIdMethod.invoke(fruitInstance, TEST_ID);

        Method setFamilyMethod = FruitDTO.class.getMethod("setFamily", String.class);
        setFamilyMethod.invoke(fruitInstance, TEST_FAMILY);

        Method setOrderMethod = FruitDTO.class.getMethod("setOrder", String.class);
        setOrderMethod.invoke(fruitInstance, TEST_ORDER);

        Method setNutritionsMethod = FruitDTO.class.getMethod("setNutritions", FruitDTO.Nutritions.class);
        setNutritionsMethod.invoke(fruitInstance, nutritionsInstance);

        // testing getters
        Method getGenusMethod = FruitDTO.class.getMethod("getGenus");
        String genusValue = (String) getGenusMethod.invoke(fruitInstance);
        assertEquals(TEST_GENUS, genusValue, "Can set/get genus");

        Method getNameMethod = FruitDTO.class.getMethod("getName");
        String nameValue = (String) getNameMethod.invoke(fruitInstance);
        assertEquals(TEST_NAME, nameValue, "Can set/get name");

        Method getIdMethod = FruitDTO.class.getMethod("getId");
        int idValue = (Integer) getIdMethod.invoke(fruitInstance);
        assertEquals(TEST_ID, idValue, "Can set/get id");

        Method getFamilyMethod = FruitDTO.class.getMethod("getFamily");
        String familyValue = (String) getFamilyMethod.invoke(fruitInstance);
        assertEquals(TEST_FAMILY, familyValue, "Can set/get family");

        Method getOrderMethod = FruitDTO.class.getMethod("getOrder");
        String orderValue = (String) getOrderMethod.invoke(fruitInstance);
        assertEquals(TEST_ORDER, orderValue, "Can set/get order");

        Method getNutritionsMethod = FruitDTO.class.getMethod("getNutritions");
        FruitDTO.Nutritions nutritionsValue = (FruitDTO.Nutritions) getNutritionsMethod.invoke(fruitInstance);

        Method getCarbohydratesMethod = FruitDTO.Nutritions.class.getMethod("getCarbohydrates");
        Double carbohydratesValue = (Double) getCarbohydratesMethod.invoke(nutritionsValue);
        assertEquals(TEST_CARBOHYDRATES, carbohydratesValue, "Can set/get carbohydrates");

        Method getProteinMethod = FruitDTO.Nutritions.class.getMethod("getProtein");
        Double proteinValue = (Double) getProteinMethod.invoke(nutritionsValue);
        assertEquals(TEST_PROTEIN, proteinValue, "Can set/get protein");

        Method getFatMethod = FruitDTO.Nutritions.class.getMethod("getFat");
        Double fatValue = (Double) getFatMethod.invoke(nutritionsValue);
        assertEquals(TEST_FAT, fatValue, "Can set/get fat");

        Method getCaloriesMethod = FruitDTO.Nutritions.class.getMethod("getCalories");
        Double caloriesValue = (Double) getCaloriesMethod.invoke(nutritionsValue);
        assertEquals(TEST_CALORIES, caloriesValue, "Can set/get calories");

        Method getSugarMethod = FruitDTO.Nutritions.class.getMethod("getSugar");
        Double sugarValue = (Double) getSugarMethod.invoke(nutritionsValue);
        assertEquals(TEST_SUGAR, sugarValue, "Can set/get sugar");

        // testing toString()
        Method toStringMethod = FruitDTO.class.getMethod("toString");
        String stringValue = (String) toStringMethod.invoke(fruitInstance);
        assertTrue(stringValue.contains(TEST_GENUS));
        assertTrue(stringValue.contains(TEST_NAME));
        assertTrue(stringValue.contains(String.valueOf(TEST_ID)));
        assertTrue(stringValue.contains(TEST_FAMILY));
        assertTrue(stringValue.contains(TEST_ORDER));

        assertTrue(stringValue.contains(String.valueOf(TEST_CARBOHYDRATES)));
        assertTrue(stringValue.contains(String.valueOf(TEST_PROTEIN)));
        assertTrue(stringValue.contains(String.valueOf(TEST_FAT)));
        assertTrue(stringValue.contains(String.valueOf(TEST_CALORIES)));
        assertTrue(stringValue.contains(String.valueOf(TEST_SUGAR)));

        assertTrue(stringValue.contains("FruitDTO{"));
        assertTrue(stringValue.contains("Nutritions{"));
    }
}

