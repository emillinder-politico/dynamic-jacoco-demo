package com.example.demo;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    Faker faker = new Faker();

    public String gotName() {
        return faker.gameOfThrones().character();
    }

    public String companyName() {
        return faker.company().name();
    }

}
