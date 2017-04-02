package es.uniovi.asw.dto;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import es.uniovi.asw.domain.Proposal;
import es.uniovi.asw.domain.User;
import es.uniovi.asw.logicInfo.VotesInfoGenero;
import es.uniovi.asw.logicInfo.VotesInfoRangoEdad;
import es.uniovi.asw.logicInfo.VotesInformation;
import es.uniovi.asw.util.DateConversor;

public class ProposalDtoTest {
	
	@Test
	public void test() {
		
		User user = new User("pablo", "asdf", "Pablo", "García", "Adosinda", "Spanish", "71374828",
				DateConversor.createSqlDate("14-01-1995"), "male");
		Proposal proposal = new Proposal(user, "Peace", "Peace in the world");
		
		ProposalDto proposalDto = new ProposalDto(proposal);
		VotesInfoGenero vIG = new VotesInfoGenero(proposal.getVotes());
		proposalDto.setVotesInfoGenero(vIG);
		VotesInfoRangoEdad vRG = new VotesInfoRangoEdad(proposal.getVotes());
		proposalDto.setVotesInfoRangoEdad(vRG);
		VotesInformation vI = new VotesInformation(proposal.getVotes());
		proposalDto.setVotesInformation(vI);
		
		assertTrue(proposalDto.getVotesInfoGenero().equals(vIG));
		assertTrue(proposalDto.getVotesInfoRangoEdad().equals(vRG));
		assertTrue(proposalDto.getVotesInformation().equals(vI));
	}

}
