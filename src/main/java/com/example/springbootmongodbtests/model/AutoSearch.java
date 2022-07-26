package com.example.springbootmongodbtests.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Data
@Document(collection = "autosearch")
public class AutoSearch {

    @Id
    @Field(name = "_id")
    private String _id;

    @Field(name = "pk")
    private String pk;

    @Field(name = "search_term")
    private String searchTerm;

    @Field(name = "normalized_term")
    @TextIndexed(weight = 2.0f)
    private String normalizedTerm;

    @Field(name = "v1_score")
    private double v1Score;

    @Field(name = "updated_date")
    private LocalDate updatedDate;
}
