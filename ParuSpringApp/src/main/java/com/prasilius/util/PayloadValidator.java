package com.prasilius.util;

import com.prasilius.jpa.models.Person;

public class PayloadValidator {
	
	public static boolean validatePayload(final Person person) {
		return person.getId() == 0;
	}

}
