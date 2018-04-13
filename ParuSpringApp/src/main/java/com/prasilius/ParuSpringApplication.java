package com.prasilius;

import java.util.logging.Logger;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.prasilius.jpa.models.Person;
import com.prasilius.jpa.repositories.PersonRepository;

@SpringBootApplication(scanBasePackages = { "com.prasilius" })
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
