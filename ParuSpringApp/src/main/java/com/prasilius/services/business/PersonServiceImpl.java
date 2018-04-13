package com.prasilius.services.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prasilius.jpa.models.Person;
import com.prasilius.jpa.repositories.PersonRepository;

@Component
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Override
	public List<Person> getPersons() {
		return personRepository.findAll();
	}

	@Override
	public Person getPersonById(final long id) {
		return personRepository.getOne(id);
	}

	@Override
	public Person savePerson(final Person person) {
		return personRepository.save(person);
	}

	@Override
	public Person updatePerson(final Person person) {
		return personRepository.save(person);
	}

	@Override
	public void deletePerson(final long id) {
		personRepository.deleteById(id);
	}
}
