package es.uniovi.asw.listeners;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import es.uniovi.asw.domain.Proposal;

public class ProposalManager {

	private static final Map<Long,Proposal> proposals = new LinkedHashMap<>();
	
	
	public static void add (Proposal proposal){
		if (proposals.containsKey(proposal.getId()))
			proposals.remove(proposal.getId());		
		proposals.put(proposal.getId(), proposal);
	}
	
    public static List<Proposal> getProposals(){
    	List<Proposal> list = proposals.entrySet().stream().map(e->e.getValue()).collect(Collectors.toList());
    	Collections.reverse(list);
    	return list;
    	
    }
}
