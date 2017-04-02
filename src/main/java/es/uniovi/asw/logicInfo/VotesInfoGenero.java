package es.uniovi.asw.logicInfo;

import java.util.List;

import es.uniovi.asw.domain.Vote;
import es.uniovi.asw.domain.VoteProposal;

public class VotesInfoGenero extends VotesInformation {

	private double malePerYes;
	private double femalePerYes;
	private double malePerNo;
	private double femalePerNo;
	private int maleNumberYes;
	private int femaleNumberYes;
	private int maleNumberNo;
	private int femaleNumberNo;

	public VotesInfoGenero(List<VoteProposal> votes) {
		super(votes);
		setMoreInfo();
	}

	public int getMalePerYes() {
		return (int) malePerYes;
	}

	public int getFemalePerYes() {
		return (int) femalePerYes;
	}

	public int getMalePerNo() {
		return (int) malePerNo;
	}

	public int getFemalePerNo() {
		return (int) femalePerNo;
	}

	public int getMaleNumberYes() {
		return maleNumberYes;
	}

	public int getFemaleNumberYes() {
		return femaleNumberYes;
	}

	public int getMaleNumberNo() {
		return maleNumberNo;
	}

	public int getFemaleNumberNo() {
		return femaleNumberNo;
	}

	public void setMoreInfo() {
		setNumberOfVotes();
		setPercentages();

	}

	private void setPercentages() {
		if (getTotal()!=0){
			this.femalePerNo = getFemaleNumberNo()>0 ? (getFemaleNumberNo() /(double) getTotal()) * 100 : 0;
			this.femalePerYes = getFemaleNumberYes()>0 ? (getFemaleNumberYes() / (double) getTotal()) * 100 : 0;
			this.malePerNo = getFemaleNumberYes() > 0 ? (getMaleNumberNo() / (double) getTotal()) * 100: 0;
			this.malePerYes = getMaleNumberYes() > 0? (getMaleNumberYes() / (double) getTotal()) * 100 : 0;
		}
	}

	private void setNumberOfVotes() {
		List<VoteProposal> aux = getVotes();
		for (Vote each : aux) {
			if (each.getUser().getGender().equals("male")) {
				if (each.isValue()) {
					this.maleNumberYes++;
				} else {
					this.maleNumberNo++;
				}

			} else if (each.getUser().getGender().equals("female")) {
				if (each.isValue()) {
					this.femaleNumberYes++;
				} else {
					this.femaleNumberNo++;
				}
			}
		}
	}

	@Override
	public String toString() {
		return "With a participation of " + getTotal()
				+ " we have the next statistics looking to the genre of the citizens: \n" + "\tMALES:\n\t\tYes: "
				+ getMalePerYes() + "%\n\t\tNo:" + getMalePerNo() + "%\n\tFEMALES:\n\t\tYes: " + getFemalePerYes()
				+ "%\n\t\tNo: " + getFemalePerNo() + "%";
	}

}