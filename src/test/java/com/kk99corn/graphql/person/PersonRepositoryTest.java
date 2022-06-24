package com.kk99corn.graphql.person;

import com.kk99corn.graphql.model.Person;
import com.kk99corn.graphql.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class PersonRepositoryTest {

	@Autowired
	PersonRepository personRepository;

	@Test
	void findAll() {
		List<Person> list = (List<Person>) personRepository.findAll();
		for (int i = 0; i < 3; i++) {
			System.out.println(list.get(i));
		}
	}

	@Test
	void findById() {
		Integer id = 1;
		Optional<Person> person = personRepository.findById(1);

		System.out.println("person = " + person);
	}
}
