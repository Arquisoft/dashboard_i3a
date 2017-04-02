package es.uniovi.asw.listeners;

import javax.annotation.ManagedBean;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import es.uniovi.asw.domain.Proposal;
import es.uniovi.asw.dto.ProposalDto;
import es.uniovi.asw.repository.ProposalRepository;

@ManagedBean
public class ProposalListener {

	private static final Logger logger = Logger.getLogger(ProposalListener.class);
	
	@Autowired
	private ProposalRepository pr;

    @KafkaListener(topics = "exampleTopic")
    public void listen(Proposal proposal) {
        logger.info("New proposal received: \"" + proposal + "\"");
        
        if (ProposalManager.isEmpty())
        	for (Proposal p:pr.findAll())
        		ProposalManager.add(new ProposalDto(p));
        ProposalManager.add(new ProposalDto(proposal));
    }
}
