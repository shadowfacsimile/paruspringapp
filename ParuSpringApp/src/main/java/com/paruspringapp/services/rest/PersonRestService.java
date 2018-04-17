package com.paruspringapp.services.rest;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paruspringapp.exceptions.PersonException;
import com.paruspringapp.jpa.models.Person;
import com.paruspringapp.services.business.PersonService;
import com.paruspringapp.services.models.Response;
import com.paruspringapp.util.PayloadValidator;

@RestController
@RequestMapping("/persons")
public class PersonRestService {

	private static Logger LOGGER = Logger.getLogger(PersonRestService.class.getName());

	@Autowired
	private PersonService personServiceImpl;

	@GetMapping
	public ResponseEntity<List<Person>> getPersons() throws PersonException {
		List<Person> persons = personServiceImpl.getPersons();

		if (persons.isEmpty())
			throw new PersonException("No records found.");

		return new ResponseEntity<>(persons, HttpStatus.OK);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping(path = "/{id}")
	public ResponseEntity<Person> getPersonById(@PathVariable("id") final long id) throws PersonException {

		LOGGER.info("getPersonById id -> " + id);

		Person person = personServiceImpl.getPersonById(id);

		if (person == null || person.getId() <= 0)
			throw new PersonException("Record does not exist.");

		return new ResponseEntity<>(person, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Person> savePerson(@RequestBody final Person person) throws PersonException {

		LOGGER.info("savePerson person -> " + person);

		if (!PayloadValidator.validatePayload(person))
			throw new PersonException("Payload malformed, id must not be defined");

		return new ResponseEntity<>(personServiceImpl.savePerson(person), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Person> updatePerson(@RequestBody final Person person) throws PersonException {

		LOGGER.info("updatePerson person -> " + person);

		Person checkperson = personServiceImpl.getPersonById(person.getId());

		if (checkperson == null || checkperson.getId() <= 0)
			throw new PersonException("Record does not exist.");

		return new ResponseEntity<>(personServiceImpl.updatePerson(person), HttpStatus.OK);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Response> deletePerson(@PathVariable("id") final long id) throws PersonException {

		LOGGER.info("deletePerson id -> " + id);

		Person checkperson = personServiceImpl.getPersonById(id);

		LOGGER.info("deletePerson id -> " + checkperson);

		if (checkperson == null || checkperson.getId() <= 0)
			throw new PersonException("Record does not exist.");

		personServiceImpl.deletePerson(Long.valueOf(id));

		return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(), "Person has been deleted"),
				HttpStatus.OK);
	}

}
