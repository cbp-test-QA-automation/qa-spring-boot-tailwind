package com.example.random.data.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;

    public String getWeather(String city) {
        RestTemplate restTemplate = new RestTemplate();
        String url = String.format(
                "https://api.openweathermap.org/data/2.5/weather?q=%s&appid=%s&units=metric",
                city, apiKey
        );

        Map<String, Object> response = restTemplate.getForObject(url, Map.class);
        Map<String, Object> main = (Map<String, Object>) response.get("main");
        Map<String, Object> weather = ((java.util.List<Map<String, Object>>) response.get("weather")).get(0);

        return weather.get("description") + ", " + main.get("temp") + "°C";
    }
}