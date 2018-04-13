package com.paruspringapp.services.rest.test;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.paruspringapp.ParuSpringApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = ParuSpringApplication.class)
@AutoConfigureMockMvc
@ContextConfiguration(classes = ParuSpringApplication.class)
public class PersonRestServiceTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setup() {
		this.mvc = MockMvcBuilders.webAppContextSetup(wac).build();

	}

	@Test
	public void testGetPersonById() throws Exception {
		mvc.perform(get("/persons/1").accept(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.firstname", is("Túrin"))).andDo(print());
	}

	@Test
	public void testGetPersons() throws Exception {
		mvc.perform(get("/persons").accept(MediaType.APPLICATION_JSON)).andExpect(jsonPath("$", hasSize(3)))
				.andDo(print());
	}

	@Test
	public void testSavePerson() throws Exception {

		mvc.perform(post("/persons/").contentType(MediaType.APPLICATION_JSON)
				.content("{\"id\" : \"4\", \"firstname\" : \"Titticus\", \"lastname\" : \"Nutsackius\" }")
				.accept(MediaType.APPLICATION_JSON)).andDo(print());
	}

}
