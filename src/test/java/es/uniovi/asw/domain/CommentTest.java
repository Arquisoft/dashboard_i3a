package es.uniovi.asw.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import es.uniovi.asw.util.DateConversor;

public class CommentTest {

	@Test
	public void test() {
		User user = new User("pablo", "asdf", "Pablo", "García", "Adosinda", "Spanish", "71374828",
				DateConversor.createSqlDate("14-01-1995"), "male");
		Proposal proposal = new Proposal(user, "Peace", "Peace in the world");
		Comment comment = new Comment(proposal, "Test", "Test");
		
		assertTrue(comment.getProposal().equals(proposal));
		assertTrue(comment.getTitle().equals("Test"));
		assertTrue(comment.getTitle().equals("Test"));
	}

}
