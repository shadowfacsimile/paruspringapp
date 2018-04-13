package com.paruspringapp.util;

import com.paruspringapp.jpa.models.Person;

public class PayloadValidator {
	
	public static boolean validatePayload(final Person person) {
		return person.getId() == 0;
	}

}
