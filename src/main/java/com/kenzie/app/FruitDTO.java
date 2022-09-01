package com.kenzie.app;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"genus", "name", "id", "family", "order", "nutritions"})
public class FruitDTO {
    // TODO: use DTO Generator to fill in getters and setters for FruitDTO and Nutritions
    // make sure to remove "abstract" from the FruitDTO class definition

    @JsonPropertyOrder({"carbohydrates", "protein", "fat", "calories", "sugar"})
    static class Nutritions {

    }
}
