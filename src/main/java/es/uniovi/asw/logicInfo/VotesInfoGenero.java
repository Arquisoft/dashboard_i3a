package es.uniovi.asw.logicInfo;

import java.util.List;

import es.uniovi.asw.domain.Vote;

public class VotesInfoGenero extends VotesInformation {

	private double malePerYes;
	private double femalePerYes;
	private double malePerNo;
	private double femalePerNo;
	private int maleNumberYes;
	private int femaleNumberYes;
	private int maleNumberNo;
	private int femaleNumberNo;

	public VotesInfoGenero(List<Vote> votes) {
		super(votes);
		setMoreInfo();
	}

	public double getMalePerYes() {
		return malePerYes;
	}

	public double getFemalePerYes() {
		return femalePerYes;
	}

	public double getMalePerNo() {
		return malePerNo;
	}

	public double getFemalePerNo() {
		return femalePerNo;
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
		this.femalePerNo = (getFemaleNumberNo() / getTotal()) * 100;
		this.femalePerYes = (getFemaleNumberYes() / getTotal()) * 100;
		this.malePerNo = (getMaleNumberNo() / getTotal()) * 100;
		this.malePerYes = (getMaleNumberYes() / getTotal()) * 100;

	}

	private void setNumberOfVotes() {
		List<Vote> aux = getVotes();
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