package com.example.random.data;

import com.example.random.data.service.RandomDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import com.example.random.data.service.QuoteService;
import com.example.random.data.service.WeatherService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class RandomDataController {

    @Autowired
    private RandomDataService randomDataService;

    @Autowired
    private QuoteService quoteService;

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/user")
    public Map<String, String> getUser() {
        return randomDataService.generateUser();
    }

    @GetMapping("/quote")
    public Map<String, String> getQuote() {
        return Map.of("quote", quoteService.getRandomQuote());
    }

    @GetMapping("/weather")
    public Map<String, String> getWeather(@RequestParam String city) {
        return Map.of("weather", weatherService.getWeather(city));
    }
}