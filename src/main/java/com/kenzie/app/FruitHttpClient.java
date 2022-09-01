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
import java.util.ArrayList;
import java.util.List;

public class FruitHttpClient {
    public static String getDesiredURL(FruitCriteria fc){
        switch(fc){
            case ALL:
                // look through the documentation to determine the correct URL
                return "";
            case LOW_CARB:
                // look through the documentation to determine the correct URL
                return "";
            case HIGH_CALORIE:
                // look through the documentation to determine the correct URL
                return "";
            default:
                return "";
        }
    }

    public String getFruits(String url) {
        // TODO: create a URL object from the desired URL
        // TODO: make the GET request and return the list of FruitDTOs
        return "";
    }

    public static List<FruitDTO> getFruitsList(String httpResponseBody) throws JsonProcessingException {
        return new ArrayList<FruitDTO>();
    }
    
        public static FruitDTO createFruitDTO(){
        // TODO: create a sample FruitDTO object based on what you want to send in your PUT request
        // instantiate a new FruitDTO object and a new Nutritions DTO object
        // then fill in the properties for each item with the setter methods
        return new FruitDTO();
    }

    public static String fruitToJSON(FruitDTO fruit) throws JsonProcessingException {
        // TODO: convert FruitDTO to JSON using the Jackson library
        return "";
    }

    public String putFruit(String fruitStr, String url) {
        // TODO: make a PUT request with the data, and return the response
        return "";
    }
}
