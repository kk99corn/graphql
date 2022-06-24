package com.kk99corn.graphql.repository;

import com.kk99corn.graphql.model.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PersonRepository extends PagingAndSortingRepository<Person, Integer> {
}
