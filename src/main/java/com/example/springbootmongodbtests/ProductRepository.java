package com.example.springbootmongodbtests;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {

    @Aggregation(pipeline = {
            "{ '$search':{ 'text':{ 'path':'search_term', 'query':?0, 'fuzzy':{}}}}",
            "{ '$limit':'10'}",
            "{ '$project':{ '_id':'0', 'title':'1', 'score':{'$meta':'searchScore'}}}"
    })
    List<Product> findProducts(String name);

    List<Product> findBySearchTermStartingWith(String searchTerm);
}
