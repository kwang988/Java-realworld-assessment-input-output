package com.kenzie.app;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"genus", "name", "id", "family", "order", "nutritions"})
public class FruitDTO {
    @JsonProperty("genus")
    private String genus;
    @JsonProperty("nutritions")
    private Nutritions nutritions;
    @JsonProperty("order")
    private String order;
    @JsonProperty("family")
    private String family;
    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;

    public String getGenus() {
        return genus;
    }

    public void setGenus(String genus) {
        this.genus = genus;
    }

    public Nutritions getNutritions() {
        return nutritions;
    }

    public void setNutritions(Nutritions nutritions) {
        this.nutritions = nutritions;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "FruitDTO{" +
                "genus='" + genus + '\'' +
                ", nutritions=" + nutritions.toString() +
                ", order='" + order + '\'' +
                ", family='" + family + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @JsonPropertyOrder({"carbohydrates", "protein", "fat", "calories", "sugar"})
    static class Nutritions {
        //declare properties
        private double carbohydrates;
        private double protein;
        private double fat;
        private double calories;
        private double sugar;

        //declare methods--getter and setter
        public double getCarbohydrates() {
            return carbohydrates;
        }

        public void setCarbohydrates(double carbohydrates) {
            this.carbohydrates = carbohydrates;
        }

        public double getProtein() {
            return protein;
        }

        public void setProtein(double protein) {
            this.protein = protein;
        }

        public double getFat() {
            return fat;
        }

        public void setFat(double fat) {
            this.fat = fat;
        }

        public double getCalories() {
            return calories;
        }

        public void setCalories(double calories) {
            this.calories = calories;
        }

        public double getSugar() {
            return sugar;
        }

        public void setSugar(double sugar) {
            this.sugar = sugar;
        }

        @Override
        public String toString() {
            return "Nutritions{" +
                    "carbohydrates=" + carbohydrates +
                    ", protein=" + protein +
                    ", fat=" + fat +
                    ", calories=" + calories +
                    ", sugar=" + sugar +
                    '}';
        }
    }
}
