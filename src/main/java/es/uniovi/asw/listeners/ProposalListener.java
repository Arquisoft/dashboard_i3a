package es.uniovi.asw.listeners;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;

import org.apache.log4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;

import es.uniovi.asw.domain.Proposal;

@ManagedBean
public class ProposalListener {

	private static final Logger logger = Logger.getLogger(ProposalListener.class);
	private static final List<Proposal> proposals = new ArrayList<>();

    @KafkaListener(topics = "exampleTopic")
    public void listen(Proposal proposal) {
        logger.info("New proposal received: \"" + proposal + "\"");
        proposals.add(proposal);
    }
    
    public static List<Proposal> getProposals(){
    	return proposals;
    }
}
