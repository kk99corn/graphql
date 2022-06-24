package com.kk99corn.graphql.data;

import com.github.javafaker.Faker;
import com.kk99corn.graphql.model.Address;
import com.kk99corn.graphql.model.Person;
import com.kk99corn.graphql.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.IntStream;

@Component
public class SampleDataLoader implements CommandLineRunner {
    private final PersonRepository personRepository;
    private final Faker faker = new Faker();

    public SampleDataLoader(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void run(String... args) throws Exception {
//        List<Person> people = IntStream.rangeClosed(1, 100)
//                .mapToObj(i -> new Person(
//                        faker.name().firstName(),
//                        faker.name().lastName(),
//                        faker.phoneNumber().cellPhone(),
//                        faker.internet().emailAddress(),
//                        new Address(
//                                faker.address().streetAddress(),
//                                faker.address().city(),
//                                faker.address().state(),
//                                faker.address().zipCode()
//                        )
//                )).toList();
//
//        personRepository.saveAll(people);
    }
}
