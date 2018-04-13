package com.prasilius.jpa.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
public class Person {

	@Id
	@GeneratedValue
	private long id;

	private String firstname;

	private String lastname;

	public Person() {

	}

	public Person(final String firstname, final String lastname) {
		setFirstname(firstname);
		setLastname(lastname);
	}

	public long getId() {
		return id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(final String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(final String lastname) {
		this.lastname = lastname;
	}

}
