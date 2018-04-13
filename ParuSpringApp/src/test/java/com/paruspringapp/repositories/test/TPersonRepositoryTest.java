package com.paruspringapp.repositories.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.paruspringapp.ParuSpringApplication;
import com.paruspringapp.jpa.repositories.PersonRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ParuSpringApplication.class })
@DataJpaTest
public class TPersonRepositoryTest {

	@Autowired
	private PersonRepository personRepository;

	@Test
	@Transactional
	public void test_get_person_by_id() {
		assertEquals(personRepository.getOne(3l).getFirstname(), "Melkor");
	}
	
	@Test
	@Transactional
	public void test_get_persons() {
		assertEquals(personRepository.findAll().size(), 3);
	}

}
