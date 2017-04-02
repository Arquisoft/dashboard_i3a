package es.uniovi.asw.domain;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import es.uniovi.asw.util.DateConversor;

public class VoteCommentTest {
	
	@Test
	public void voteCommentTest() {
		User user = new User("pablo", "asdf", "Pablo", "García", "Adosinda", "Spanish", "71374828",
				DateConversor.createSqlDate("14-01-1995"), "male");
		Proposal proposal = new Proposal(user, "Peace", "Peace in the world");
		Comment comment = new Comment(proposal, "Test", "Test");
		VoteComment voteComment = new VoteComment(comment, user, true);

		assertTrue(voteComment.getUser().equals(user));
		assertTrue(voteComment.getComment().equals(comment));
		assertTrue(voteComment.isValue() == true);
		
		voteComment = new VoteComment();
		voteComment.setId(1L);
		voteComment.setUser(user);
		voteComment.setValue(true);
		voteComment.setComment(comment);
		
		assertTrue(voteComment.getUser().equals(user));
		assertTrue(voteComment.getComment().equals(comment));
		assertTrue(voteComment.isValue());
	}

}
