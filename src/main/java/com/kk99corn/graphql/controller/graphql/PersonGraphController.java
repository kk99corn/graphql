package com.kk99corn.graphql.controller.graphql;

import com.kk99corn.graphql.model.Address;
import com.kk99corn.graphql.model.Person;
import com.kk99corn.graphql.repository.PersonRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class PersonGraphController {

	private final PersonRepository personRepository;

	public PersonGraphController(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@SchemaMapping(typeName = "Query", value = "findAll")
	public List<Person> findAll() {
		return (List<Person>) personRepository.findAll();
	}

	@SchemaMapping(typeName = "Query", value = "findById")
	public Optional<Person> findById(@Argument Integer id) {
		return personRepository.findById(id);
	}

	@SchemaMapping(typeName = "Mutation", value = "addPerson")
	public Person addPerson(@Argument String firstName,
							@Argument String lastName,
							@Argument String phoneNumber,
							@Argument String email
	) {
		return personRepository.save(new Person(
				firstName,
				lastName,
				phoneNumber,
				email,
				new Address(
						"test",
						"aaaa",
						"test",
						"9999"
				)
		));
	}


//	@QueryMapping
//	public Book findOne(@Argument Integer id) {
//		return bookRepository.findOne(id);
//	}
}
