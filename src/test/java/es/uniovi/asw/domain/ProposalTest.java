package es.uniovi.asw.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import es.uniovi.asw.util.DateConversor;

public class ProposalTest {

	@Test
	public void test() {
		User user = new User("pablo", "asdf", "Pablo", "García", "Adosinda", "Spanish", "71374828",
				DateConversor.createSqlDate("14-01-1995"), "male");
		Proposal proposal = new Proposal(user, "Peace", "Peace in the world");
		
		assertTrue(proposal.getOwner().equals(user));
		assertTrue(proposal.getTitle().equals("Peace"));
		assertTrue(proposal.getDescription().equals("Peace in the world"));
		
		proposal.setId(1L);
		proposal.setTitle("Peace");
		proposal.setDescription("Peace in the world");
		proposal.setOwner(user);
		proposal.setVotes(null);
		
		assertTrue(proposal.getOwner().equals(user));
		assertTrue(proposal.getTitle().equals("Peace"));
		assertTrue(proposal.getDescription().equals("Peace in the world"));
	}

}
