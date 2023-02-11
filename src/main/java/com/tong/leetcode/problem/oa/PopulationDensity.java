package com.tong.leetcode.problem.oa;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;

public class PopulationDensity {
    public static int getPopulationDensity(String name) {
        final String queryUrl = "https://jsonmock.hackerrank.com/api/countries?name=" + name;
        HttpClient client = HttpClient.newHttpClient();
        int area = 0, population = 0;

        try {
            var objectMapper = new ObjectMapper()
                    .disable(FAIL_ON_UNKNOWN_PROPERTIES);

            var request = HttpRequest
                    .newBuilder()
                    .uri(URI.create(queryUrl))
                    .header("accept", "application/json")
                    .GET()
                    .build();

            var response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String jsonString = response.body();
            Country data = objectMapper.readValue(jsonString, Country.class);
            area = data.getData().get(0).getArea();
            population = data.getData().get(0).getPopulation();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return population/area;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    static class Country{
        ArrayList<DataModel> data;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    static class DataModel{
        String name;
        Integer population;
        Integer area;
    }

    @Test
    void test(){
        System.out.println(PopulationDensity.getPopulationDensity("china"));
        Assertions.assertEquals(PopulationDensity.getPopulationDensity("china"), 142);
    }
}
