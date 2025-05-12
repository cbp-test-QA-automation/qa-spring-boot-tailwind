package com.example.random.data.service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;

@Service
public class QuoteService {
    List<String> quotes = List.of(
            "The best way to get started is to quit talking and begin doing.",
            "Don't let yesterday take up too much of today.",
            "Success is not in what you have, but who you are.",
            "If you are working on something exciting, it will keep you motivated.",
            "It's not whether you get knocked down, it's whether you get up."
    );

    public String getRandomQuote() {
        return quotes.get(new Random().nextInt(quotes.size()));
    }
}