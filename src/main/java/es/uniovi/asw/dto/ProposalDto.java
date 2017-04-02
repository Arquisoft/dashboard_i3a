package es.uniovi.asw.dto;

import es.uniovi.asw.domain.Proposal;
import es.uniovi.asw.logicInfo.IntermedioProposal;
import es.uniovi.asw.logicInfo.VotesInfoGenero;
import es.uniovi.asw.logicInfo.VotesInfoRangoEdad;
import es.uniovi.asw.logicInfo.VotesInformation;

public class ProposalDto {

	private Proposal proposal;
	private VotesInfoGenero votesInfoGenero;
	private VotesInfoRangoEdad votesInfoRangoEdad;
	private VotesInformation votesInformation;

	public ProposalDto(Proposal proposal) {
		setProposal(proposal);
		IntermedioProposal aux = new IntermedioProposal(proposal.getVotes());
		setVotesInformation(aux.getVotesInformation());
		setVotesInfoRangoEdad(aux.getVotesInfoRangoEdad());
		setVotesInfoGenero(aux.getVotesInfoGenero());
	}

	public Proposal getProposal() {
		return proposal;
	}

	public void setProposal(Proposal proposal) {
		this.proposal = proposal;
	}

	public VotesInfoGenero getVotesInfoGenero() {
		return votesInfoGenero;
	}

	public void setVotesInfoGenero(VotesInfoGenero votesInfoGenero) {
		this.votesInfoGenero = votesInfoGenero;
	}

	public VotesInfoRangoEdad getVotesInfoRangoEdad() {
		return votesInfoRangoEdad;
	}

	public void setVotesInfoRangoEdad(VotesInfoRangoEdad votesInfoRangoEdad) {
		this.votesInfoRangoEdad = votesInfoRangoEdad;
	}

	public VotesInformation getVotesInformation() {
		return votesInformation;
	}

	public void setVotesInformation(VotesInformation votesInformation) {
		this.votesInformation = votesInformation;
	}

}
