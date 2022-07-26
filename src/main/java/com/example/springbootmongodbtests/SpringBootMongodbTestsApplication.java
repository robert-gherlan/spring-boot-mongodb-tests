package com.example.springbootmongodbtests;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class SpringBootMongodbTestsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMongodbTestsApplication.class, args);
    }
}
