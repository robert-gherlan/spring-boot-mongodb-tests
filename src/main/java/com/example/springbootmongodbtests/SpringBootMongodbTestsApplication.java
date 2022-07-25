package com.example.springbootmongodbtests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class SpringBootMongodbTestsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMongodbTestsApplication.class, args);
    }

    @Autowired
    ProductRepository productRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(productRepository.findProducts("ar").size());
        System.out.println(productRepository.findBySearchTermStartingWith("ar").size());
    }
}
