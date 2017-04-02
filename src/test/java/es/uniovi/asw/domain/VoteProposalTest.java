package es.uniovi.asw.domain;

import org.junit.Test;

import es.uniovi.asw.util.DateConversor;
import static org.junit.Assert.*;

public class VoteProposalTest {

	@Test
	public void voteProposalTest() {
		User user = new User("pablo", "asdf", "Pablo", "García", "Adosinda", "Spanish", "71374828",
				DateConversor.createSqlDate("14-01-1995"), "male");
		Proposal proposal = new Proposal(user, "Peace", "Peace in the world");
		VoteProposal voteProposal = new VoteProposal(proposal, user, true);

		assertTrue(voteProposal.getUser().equals(user));
		assertTrue(voteProposal.getProposal().equals(proposal));
		assertTrue(voteProposal.isValue() == true);
		
		voteProposal.setProposal(proposal);
		voteProposal.setUser(user);
		voteProposal.setValue(true);
		
		assertTrue(voteProposal.getUser().equals(user));
		assertTrue(voteProposal.getProposal().equals(proposal));
		assertTrue(voteProposal.isValue());
	}

}
