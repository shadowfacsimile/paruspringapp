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
			personRepository.save(new Person("Prasil", "Prakash"));
			personRepository.save(new Person("Nileena", "GP"));
			personRepository.save(new Person("Lakshya", "Prasil"));
			LOGGER.info("The sample data has been generated");
		};
	}

}
