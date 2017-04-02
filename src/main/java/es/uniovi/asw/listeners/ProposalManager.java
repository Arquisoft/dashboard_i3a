package es.uniovi.asw.listeners;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import es.uniovi.asw.dto.ProposalDto;

public class ProposalManager {

	private static final Map<Long,ProposalDto> proposals = new LinkedHashMap<>();
	
	
	public static boolean isEmpty(){
		return proposals.isEmpty();
	}
	public static void add (ProposalDto proposalDto){
		if (proposals.containsKey(proposalDto.getProposal().getId()))
			proposals.remove(proposalDto.getProposal().getId());
		
		proposals.put(proposalDto.getProposal().getId(), proposalDto);
	}
	
    public static List<ProposalDto> getProposals(){
    	List<ProposalDto> list = proposals.entrySet().stream().map(e->e.getValue()).collect(Collectors.toList());
    	Collections.reverse(list);
    	return list;
    	
    }
}
