package com.example.random.data.service;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class RandomDataService {
    private final Faker faker = new Faker();

    public Map<String, String> generateUser() {
        Map<String, String> user = new HashMap<>();
        user.put("firstName", faker.name().firstName());
        user.put("lastName", faker.name().lastName());
        user.put("email", faker.internet().emailAddress());
        user.put("address", faker.address().fullAddress());
        user.put("phone", faker.phoneNumber().cellPhone());
        return user;
    }
}