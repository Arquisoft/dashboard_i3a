package es.uniovi.asw.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import es.uniovi.asw.util.DateConversor;

public class UserTest {

	@Test
	public void test() {
		User user = new User("pablo", "asdf", "Pablo", "García", "Adosinda", "Spanish", "71374828",
				DateConversor.createSqlDate("14-01-1995"), "male");
		
		assertTrue(user.getLogin().equals("pablo"));
		assertTrue(user.getPassword().equals("asdf"));
		assertTrue(user.getFirstName().equals("Pablo"));
		assertTrue(user.getLastName().equals("García"));
		assertTrue(user.getNationality().equals("Spanish"));
		assertTrue(user.getDNI().equals("71374828"));
		assertTrue(user.getNationality().equals("Spanish"));
		assertTrue(user.getGender().equals("male"));
	}
}
