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
import es.uniovi.asw.domain.Comment;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest({ "server.port=0" })
public class CommentRepositoryTest {

	@Autowired
	CommentRepository cR;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		Comment c;

		c = cR.findById(1L);

		assertTrue(c.getTitle().equals("Comment 1"));

	}

}
