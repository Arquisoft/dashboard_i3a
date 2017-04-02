package es.uniovi.asw.repository;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import es.uniovi.asw.Application;
import es.uniovi.asw.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({ "server.port=0" })
public class UserRepositoryTest {

	@Autowired
	UserRepository uR;

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void testFindByLogin() {
		User aux1;
		User aux2;

		aux1 = uR.findByLogin("Laura@example.com");
		aux2 = uR.findByLogin("Luis@example.com");

		assertTrue(aux1.getId() == 8);
		assertTrue(aux2.getId() == 5);

		assertTrue(aux1.getDNI().equals("19987962F"));
		assertTrue(aux2.getDNI().equals("19160962F"));

		assertTrue(aux1.getFirstName().equals("Laura"));
		assertTrue(aux2.getFirstName().equals("Luis"));

	}

	@Test
	public void testFindByLoginAndPassword() {
		User aux1;
		User aux2;

		aux1 = uR.findByLoginAndPassword("Laura@example.com", "asdf");
		aux2 = uR.findByLoginAndPassword("Luis@example.com", "asdf");

		assertTrue(aux1.getId() == 8);
		assertTrue(aux2.getId() == 5);

		assertTrue(aux1.getDNI().equals("19987962F"));
		assertTrue(aux2.getDNI().equals("19160962F"));

		assertTrue(aux1.getFirstName().equals("Laura"));
		assertTrue(aux2.getFirstName().equals("Luis"));

	}

	@Test
	public void testFindById() {
		User aux1;
		User aux2;

		aux1 = uR.findById(8L);
		aux2 = uR.findById(5L);

		assertTrue(aux1.getId() == 8);
		assertTrue(aux2.getId() == 5);

		assertTrue(aux1.getDNI().equals("19987962F"));
		assertTrue(aux2.getDNI().equals("19160962F"));

		assertTrue(aux1.getFirstName().equals("Laura"));
		assertTrue(aux2.getFirstName().equals("Luis"));

	}

}
