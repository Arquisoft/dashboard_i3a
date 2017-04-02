package es.uniovi.asw.logicInfo;

import java.util.List;

import es.uniovi.asw.domain.Vote;
import es.uniovi.asw.domain.VoteProposal;

public class VotesInformation {

	private List<VoteProposal> votes;
	private int total;
	private int totalYes;
	private int totalNo;
	private double perYes;
	private double perNo;

	public VotesInformation(List<VoteProposal> votes2) {

		this.votes = votes2;
		this.total = votes2.size();
		setInfoVotes();
	}

	private void setInfoVotes() {

		int y = 0;
		int n = 0;
		for (Vote each : votes) {
			if (each.isValue()) {
				y++;
			} else {
				n++;
			}
		}
		this.totalYes = y;
		this.totalNo = n;

		this.perNo = n > 0 ? (n / (double) (y + n)) * 100 : 0;
		this.perYes = y > 0 ? (y / (double) (y + n)) * 100 : 0;

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

	public int getPerYes() {
		return (int) perYes;
	}

	public int getPerNo() {
		return (int) perNo;
	}

	@Override
	public String toString() {
		return "With a participation of " + getTotal() + " citizens, there are the next results: \n\t Yes: "
				+ getPerYes() + "%\n\t No:" + getPerNo();
	}

	public String getInfo() {
		return "Votes: " + (int) total + " Yes:" + (int) perYes + "% No:" + (int) perNo + "%";
	}

}
