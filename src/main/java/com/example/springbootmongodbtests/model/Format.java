package com.example.springbootmongodbtests.model;


import java.util.List;

public record Format(String query, List<String> suggestions) {
}
