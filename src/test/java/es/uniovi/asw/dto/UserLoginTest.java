package es.uniovi.asw.dto;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class UserLoginTest {
	
	@Test
	public void test() {
		UserLogin userLogin = new UserLogin();
		userLogin.setLogin("username");
		userLogin.setPassword("password");
		
		assertTrue(userLogin.getLogin().equals("username"));
		assertTrue(userLogin.getPassword().equals("password"));
	}

}
