package es.uniovi.asw.logicinfo;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import es.uniovi.asw.domain.User;
import es.uniovi.asw.domain.VoteProposal;
import es.uniovi.asw.logicInfo.VotesInfoRangoEdad;
import es.uniovi.asw.util.DateConversor;

public class VotesInfoRangoEdadTest {

	
	@Test
	public void test() {
		List<VoteProposal> votes = new ArrayList<VoteProposal>();
		User userJoven = new User();
		userJoven.setBirthday(DateConversor.createSqlDate("11-10-1996"));
		User userViejo = new User();
		userViejo.setBirthday(DateConversor.createSqlDate("11-10-1926"));
		for (int i = 0; i < 50; i++){
			if (i % 2 == 0) {
				VoteProposal v = new VoteProposal();
				v.setValue(true);
				v.setUser(userJoven);
				userJoven.getVoteProposal().add(v);
				votes.add(v);
			} else {
				VoteProposal v = new VoteProposal();
				v.setValue(false);
				v.setUser(userViejo);
				userViejo.getVoteProposal().add(v);
				votes.add(v);
			}
		}
		VotesInfoRangoEdad vi = new VotesInfoRangoEdad(votes);
		vi.getInfo();
		assertTrue(vi.getPerNo()==50);
		assertTrue(vi.getPerYes()==50);
		assertTrue(vi.getTotal()==50);
		assertTrue(vi.getTotalYes()==25);
		assertTrue(vi.getTotalNo()==25);
		
		assertTrue(vi.getYoungNumberYes()==25);
		assertTrue(vi.getYoungNumberNo()==0);
		assertTrue(vi.getYoungPerYes()==50);
		assertTrue(vi.getYoungPerNo()==0);
		
		assertTrue(vi.getOldNumberYes()==0);
		assertTrue(vi.getOldNumberNo()==25);
		assertTrue(vi.getOldPerYes()==0);
		assertTrue(vi.getOldPerNo()==50);
		
		assertTrue(vi.getAdultNumberYes()==0);
		assertTrue(vi.getAdultNumberNo()==0);
		assertTrue(vi.getAdultgPerYes()==0);
		assertTrue(vi.getAdultgPerNo()==0);
		
			
	}
}
