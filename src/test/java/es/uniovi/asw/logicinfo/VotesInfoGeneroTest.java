package es.uniovi.asw.logicinfo;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import es.uniovi.asw.domain.User;
import es.uniovi.asw.domain.VoteProposal;
import es.uniovi.asw.logicInfo.VotesInfoGenero;

public class VotesInfoGeneroTest {

	@Test
	public void test() {
		List<VoteProposal> votes = new ArrayList<VoteProposal>();
		User userChico = new User();
		userChico.setGender("male");
		User userChica = new User();
		userChica.setGender("female");
		for (int i = 0; i < 50; i++){
			if (i % 2 == 0) {
				VoteProposal v = new VoteProposal();
				v.setValue(true);
				v.setUser(userChico);
				userChico.getVoteProposal().add(v);
				votes.add(v);
			} else {
				VoteProposal v = new VoteProposal();
				v.setValue(false);
				v.setUser(userChica);
				userChica.getVoteProposal().add(v);
				votes.add(v);
			}
		}
		VotesInfoGenero vi = new VotesInfoGenero(votes);
		vi.getInfo();
		assertTrue(vi.getPerNo()==50);
		assertTrue(vi.getPerYes()==50);
		assertTrue(vi.getTotal()==50);
		assertTrue(vi.getTotalYes()==25);
		assertTrue(vi.getTotalNo()==25);
		
		assertTrue(vi.getMaleNumberYes()==25);
		assertTrue(vi.getMaleNumberNo()==0);
		assertTrue(vi.getMalePerYes()==50);
		assertTrue(vi.getMalePerNo()==0);
		
		assertTrue(vi.getFemaleNumberYes()==0);
		assertTrue(vi.getFemaleNumberNo()==25);
		assertTrue(vi.getFemalePerYes()==0);
		assertTrue(vi.getFemalePerNo()==50);
		
		
		
		
			
	}

}
