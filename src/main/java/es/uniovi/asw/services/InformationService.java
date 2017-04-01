package es.uniovi.asw.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uniovi.asw.domain.Proposal;
import es.uniovi.asw.logicInfo.VotesInfoGenero;
import es.uniovi.asw.logicInfo.VotesInfoRangoEdad;
import es.uniovi.asw.logicInfo.VotesInformation;
import es.uniovi.asw.repository.ProposalRepository;

@Service
public class InformationService {
	
	@Autowired
	ProposalRepository proposalRepository;
	
	private List<VotesInformation> votesInformation = new ArrayList<VotesInformation>();
	private List<VotesInfoGenero> votesInfoGenero = new ArrayList<VotesInfoGenero>();
	private List<VotesInfoRangoEdad> votesInfoRangoEdad = new ArrayList<VotesInfoRangoEdad>();
	
	public List<VotesInformation> getVotesInformation(){
		for (Proposal proposal : proposalRepository.findAll()){
			votesInformation.add(new VotesInformation());
		}
		return votesInformation;
	}
	
	public List<VotesInfoGenero> getVotesInfoGenero(){
		for (Proposal proposal : proposalRepository.findAll()){
			votesInfoGenero.add(new VotesInfoGenero());
		}
		return votesInfoGenero;
	}
	
	public List<VotesInfoRangoEdad> getVotesInfoRangoEdad(){
		for (Proposal proposal : proposalRepository.findAll()){
			votesInfoRangoEdad.add(new VotesInfoRangoEdad());
		}
		return votesInfoRangoEdad;
	}

}
