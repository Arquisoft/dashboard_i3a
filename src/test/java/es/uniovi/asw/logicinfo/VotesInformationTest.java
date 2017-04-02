package es.uniovi.asw.logicinfo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import es.uniovi.asw.domain.VoteProposal;
import es.uniovi.asw.logicInfo.VotesInformation;

public class VotesInformationTest {

	@Test
	public void test() {
		List<VoteProposal> votes = new ArrayList<VoteProposal>();
		for (int i = 0; i < 50; i++){
			if (i % 2 == 0) {
				VoteProposal v = new VoteProposal();
				v.setValue(true);
				votes.add(v);
			} else {
				VoteProposal v = new VoteProposal();
				v.setValue(false);
				votes.add(v);
			}
		}
		VotesInformation vi = new VotesInformation(votes);
		vi.getInfo();
		assertTrue(vi.getPerNo()==50);
		assertTrue(vi.getPerYes()==50);
		assertTrue(vi.getTotal()==50);
		assertTrue(vi.getTotalYes()==25);
		assertTrue(vi.getTotalNo()==25);
		
			
	}
}
