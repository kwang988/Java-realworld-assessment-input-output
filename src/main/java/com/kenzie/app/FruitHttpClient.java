package com.kenzie.app;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;

public class FruitHttpClient {
    public static String getDesiredURL(FruitCriteria fc){
        switch(fc){
            case ALL:
                // look through the documentation to determine the correct URL
                return "https://www.fruityvice.com/api/fruit/all";
            case LOW_CARB:
                // look through the documentation to determine the correct URL
                return "https://www.fruityvice.com/api/fruit/carbohydrates?min=0&max=5";
            case HIGH_CALORIE:
                // look through the documentation to determine the correct URL
                return "https://www.fruityvice.com/api/fruit/calories?min=100&max=1000";
            default:
                return "";
        }
    }

    public String getFruits(String url) {

        HttpClient client = HttpClient.newHttpClient();
        URI uri = URI.create(url);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Accept", "application/json")
                .GET()
                .build();
        try {
            HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
            int statusCode = httpResponse.statusCode();
            if (statusCode == 200) {
                return httpResponse.body();
            } else {
                return String.format("GET request failed: %d status code received", statusCode);
            }
        } catch (IOException | InterruptedException e) {
            return e.getMessage();
        }
    }

    public static List<FruitDTO> getFruitsList(String httpResponseBody) throws JsonProcessingException {
        List<FruitDTO> fruitListObj;
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<FruitDTO>> typeRefList = new TypeReference<>(){};
        //use ObjectMapper and readValue
        fruitListObj = objectMapper.readValue(httpResponseBody,typeRefList);
        return fruitListObj;
    }
    
        public static FruitDTO createFruitDTO(){
        // instantiate a new FruitDTO object and a new Nutritions DTO object
        // then fill in the properties for each item with the setter methods
            FruitDTO fruitDTOObj = new FruitDTO();
            fruitDTOObj.setGenus("Fragaria");
            fruitDTOObj.setName("Blackberry");
            fruitDTOObj.setFamily("Rosaceae");
            fruitDTOObj.setOrder("Rosales");
            FruitDTO.Nutritions nutritions = new FruitDTO.Nutritions();
            nutritions.setCarbohydrates(5.5);
            nutritions.setProtein(0);
            nutritions.setFat(0.4);
            nutritions.setCalories(29);
            nutritions.setSugar(5.4);
        return fruitDTOObj;
    }

    public static String fruitToJSON(FruitDTO fruit) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
     // configure Object mapper for pretty print
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        String fruitStr = objectMapper.writeValueAsString(fruit);
        return fruitStr;
    }

    public String putFruit(String fruitStr, String url) {
        HttpClient client = HttpClient.newHttpClient();
        URI uri = URI.create(url);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(uri)
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(fruitStr))
                .build();
        try {
            HttpResponse<String> httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
            int statusCode = httpResponse.statusCode();
            if (statusCode == 201 || statusCode == 202) {
                return httpResponse.body();
            } else {
                return String.format("PUT request failed: %d status code received", statusCode);
            }
        } catch (IOException | InterruptedException e) {
            return e.getMessage();
        }
    }
}
