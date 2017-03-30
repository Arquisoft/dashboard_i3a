package es.uniovi.asw.listeners;

import javax.annotation.ManagedBean;

import org.apache.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;

import es.uniovi.asw.domain.Proposal;

@ManagedBean
public class ProposalListener {

	private static final Logger logger = Logger.getLogger(ProposalListener.class);
	

    @KafkaListener(topics = "exampleTopic")
    public void listen(Proposal proposal) {
        logger.info("New proposal received: \"" + proposal + "\"");
        ProposalManager.add(proposal);
    }
    

}
