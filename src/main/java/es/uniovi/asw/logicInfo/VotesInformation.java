package es.uniovi.asw.logicInfo;

import java.util.List;

import es.uniovi.asw.domain.Vote;

public class VotesInformation {

	private List<Vote> votes;
	private int total;
	private int totalYes;
	private int totalNo;
	private double perYes;
	private double perNo;

	public VotesInformation(List<Vote> votes) {
		this.votes = votes;
		this.total = votes.size();
		setInfoVotes();
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

	public List<Vote> getVotes() {
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
