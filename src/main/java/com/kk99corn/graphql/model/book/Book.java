package com.kk99corn.graphql.model.book;

public record Book(Integer id, String title, Integer pages, Rating rating, Author author) {
}
