package com.paruspringapp.services.business;

import java.util.List;

import org.springframework.stereotype.Service;

import com.paruspringapp.jpa.models.Person;

@Service
public interface PersonService {

	public List<Person> getPersons();

	public Person getPersonById(final long id);

	public Person savePerson(final Person person);

	public Person updatePerson(final Person person);

	public void deletePerson(final long id);

}