package es.uniovi.asw.logicInfo;

import java.util.ArrayList;
import java.util.List;

import es.uniovi.asw.domain.Vote;
import es.uniovi.asw.domain.VoteProposal;

public class IntermedioProposal {

	private VotesInformation votesInformation;
	private VotesInfoGenero votesInfoGenero;
	private VotesInfoRangoEdad votesInfoRangoEdad;

	public IntermedioProposal(List<VoteProposal> lista) {
		List<Vote> aux = new ArrayList<>();
		for (VoteProposal each : lista) {
			aux.add(each);
		}
		initialize(aux);

	}

	private void initialize(List<Vote> aux) {
		votesInformation = new VotesInformation(aux);
		votesInfoRangoEdad = new VotesInfoRangoEdad(aux);
		votesInfoGenero = new VotesInfoGenero(aux);
	}

	public VotesInformation getVotesInformation() {
		return votesInformation;
	}

	public void setVotesInformation(VotesInformation votesInformation) {
		this.votesInformation = votesInformation;
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

}
