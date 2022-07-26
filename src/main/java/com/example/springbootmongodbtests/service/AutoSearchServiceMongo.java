package com.example.springbootmongodbtests.service;

import com.example.springbootmongodbtests.model.AutoSearch;
import com.example.springbootmongodbtests.model.Format;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.TextCriteria;
import org.springframework.data.mongodb.core.query.TextQuery;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AutoSearchServiceMongo {
    private final MongoTemplate mongoTemplate;

    public Format search(String searchQuery) {
        Sort.TypedSort<AutoSearch> autoSearchTypedSort = Sort.sort(AutoSearch.class);
        Sort sort = autoSearchTypedSort.by(AutoSearch::getV1Score).ascending();
        TextCriteria criteria = TextCriteria.forDefaultLanguage().matching(searchQuery);
        Query query = TextQuery.queryText(criteria).with(sort).with(PageRequest.ofSize(10));
        List<AutoSearch> result = mongoTemplate.find(query, AutoSearch.class);
        List<String> suggestions = result.stream().map(AutoSearch::getSearchTerm).toList();

        return new Format(searchQuery, suggestions);
    }
}
