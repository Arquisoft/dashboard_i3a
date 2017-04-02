package es.uniovi.asw.producers;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.uniovi.asw.domain.Proposal;
import es.uniovi.asw.repository.ProposalRepository;

@Component
public class MockProposalGenerator {
	
	@Autowired
	private ProposalRepository proposalRepository;
	
	public Proposal generate(){
		int pos = ThreadLocalRandom.current().nextInt(proposalRepository.findAll().size());
    	
    	return proposalRepository.findAll().get(pos);
	}

}
