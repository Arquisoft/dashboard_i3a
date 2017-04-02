package es.uniovi.asw.logicInfo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import es.uniovi.asw.domain.Vote;
import es.uniovi.asw.domain.VoteProposal;
import es.uniovi.asw.repository.ProposalRepository;

public class VotesInformation {

	private List<VoteProposal> votes;
	private int total;
	private int totalYes;
	private int totalNo;
	private double perYes;
	private double perNo;
	
	@Autowired
	ProposalRepository proposalRepository;

	public VotesInformation() {
		
	}
	
	public VotesInformation init(List<VoteProposal> votes){
		this.votes = votes;
		this.total = votes.size();
		setInfoVotes();
		return this;
	}

	private void setInfoVotes() {
		int y = 0, n = 0;
		for (Vote each : votes) {
			if (each.isValue()) {
				y++;
			} else {
				n++;
			}
		}
		this.totalYes = y;
		this.totalNo = n;
		this.perNo = (getTotalNo() / getTotal()) * 100;
		this.perYes = (getTotalYes() / getTotal()) * 100;

	}

	public List<VoteProposal> getVotes() {
		return votes;
	}

	public int getTotal() {
		return total;
	}

	public int getTotalYes() {
		return totalYes;
	}

	public int getTotalNo() {
		return totalNo;
	}

	public double getPerYes() {
		return perYes;
	}

	public double getPerNo() {
		return perNo;
	}

	@Override
	public String toString() {
		return "With a participation of " + getTotal() + " citizens, there are the next results: \n\t Yes: "
				+ getPerYes() + "%\n\t No:" + getPerNo();
	}

}
