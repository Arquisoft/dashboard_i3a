package es.uniovi.asw.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uniovi.asw.domain.Proposal;
import es.uniovi.asw.logicInfo.IntermedioProposal;
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
	private IntermedioProposal intermedioProposal;

	public List<VotesInformation> findAllVotesInformation() {
		for (Proposal proposal : proposalRepository.findAll()) {
			intermedioProposal = new IntermedioProposal(proposal.getVotes());
			votesInformation.add(intermedioProposal.getVotesInformation());
		}
		return votesInformation;
	}

	public List<VotesInfoGenero> findAllVotesInfoGenero() {
		for (Proposal proposal : proposalRepository.findAll()) {
			intermedioProposal = new IntermedioProposal(proposal.getVotes());
			votesInformation.add(intermedioProposal.getVotesInfoGenero());
		}
		return votesInfoGenero;
	}

	public List<VotesInfoRangoEdad> findAllVotesInfoRangoEdad() {
		for (Proposal proposal : proposalRepository.findAll()) {
			intermedioProposal = new IntermedioProposal(proposal.getVotes());
			votesInformation.add(intermedioProposal.getVotesInfoRangoEdad());
		}
		return votesInfoRangoEdad;
	}

}
