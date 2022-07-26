package com.example.springbootmongodbtests.controller;

import com.example.springbootmongodbtests.service.AutoSearchServiceMongo;
import com.example.springbootmongodbtests.model.Format;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AutoSearchController {

    private final AutoSearchServiceMongo autoSearchServiceMongo;

    @GetMapping
    public ResponseEntity<Format> get(@RequestParam String query) {
        final var result = autoSearchServiceMongo.search(query);

        return ResponseEntity.ok(result);
    }
}
