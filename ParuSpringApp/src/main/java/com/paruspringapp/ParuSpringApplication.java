package com.paruspringapp;

import java.util.logging.Logger;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.paruspringapp.jpa.models.Person;
import com.paruspringapp.jpa.repositories.PersonRepository;

@SpringBootApplication(scanBasePackages = { "com.paruspringapp" })
public class ParuSpringApplication {

	private static final Logger LOGGER = Logger.getLogger(ParuSpringApplication.class.getName());

	public static void main(String[] args) throws Exception {
		SpringApplication.run(ParuSpringApplication.class, args);
	}

	@Bean
	public CommandLineRunner setup(PersonRepository personRepository) {
		return (args) -> {
			personRepository.save(new Person("Túrin", "Turambar"));
			personRepository.save(new Person("Frodo", "Baggins"));
			personRepository.save(new Person("Melkor", "Morgoth"));
			LOGGER.info("The sample data has been generated");
		};
	}

}
