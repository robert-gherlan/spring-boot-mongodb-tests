package com.example.springbootmongodbtests;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "products")
public class Product {

    @Id
    @Field(name = "_id")
    private String _id;

    @Field(name = "primary_key")
    private String primaryKey;

    @Field(name = "search_term")
    private String searchTerm;

    @Field(name = "normalized_term")
    private String normalizedTerm;

    @Field(name = "v1_score")
    private double v1Score;

    @Field(name = "updated_date")
    private String updatedDate;

    @Field(name = "search_score")
    private String searchScore;
}
