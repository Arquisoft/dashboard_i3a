package es.uniovi.asw.dto;

import static org.junit.Assert.*;

import org.junit.Test;

public class UserDtoTest {
	
	@Test
	public void test() {
		UserDto userDto = new UserDto("username", "lastname", 24, 1L, "mock@mail.com");
		assertTrue(userDto.getId().equals(1L));
		assertTrue(userDto.getAge().equals(24));
		assertTrue(userDto.getFirstname().equals("username"));
		assertTrue(userDto.getLastname().equals("lastname"));

	}

}
