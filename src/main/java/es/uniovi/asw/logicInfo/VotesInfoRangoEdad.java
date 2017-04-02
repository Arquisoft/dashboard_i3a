package es.uniovi.asw.logicInfo;

import java.util.List;

import es.uniovi.asw.domain.Vote;
import es.uniovi.asw.util.AgeCalculator;

public class VotesInfoRangoEdad extends VotesInformation {

	/**
	 * Young = 18-30 Adult = 30-55 Old = 55 ->>
	 */

	private int youngNumberYes;
	private int adultNumberYes;
	private int oldNumberYes;
	private int youngNumberNo;
	private int adultNumberNo;
	private int oldNumberNo;
	private double youngPerYes;
	private double oldPerYes;
	private double adultgPerYes;
	private double youngPerNo;
	private double oldPerNo;
	private double adultgPerNo;

	public VotesInfoRangoEdad(List<Vote> votes) {
		super(votes);
		setMoreInfo();
	}

	public int getYoungNumberYes() {
		return youngNumberYes;
	}

	public int getAdultNumberYes() {
		return adultNumberYes;
	}

	public int getOldNumberYes() {
		return oldNumberYes;
	}

	public int getYoungNumberNo() {
		return youngNumberNo;
	}

	public int getAdultNumberNo() {
		return adultNumberNo;
	}

	public int getOldNumberNo() {
		return oldNumberNo;
	}

	public double getYoungPerYes() {
		return youngPerYes;
	}

	public double getOldPerYes() {
		return oldPerYes;
	}

	public double getAdultgPerYes() {
		return adultgPerYes;
	}

	public double getYoungPerNo() {
		return youngPerNo;
	}

	public double getOldPerNo() {
		return oldPerNo;
	}

	public double getAdultgPerNo() {
		return adultgPerNo;
	}

	public void setMoreInfo() {
		setNumberOfVotes();
		setPercentages();
	}

	private void setNumberOfVotes() {
		List<Vote> aux = getVotes();
		int years;
		boolean vote;
		for (Vote each : aux) {
			years = AgeCalculator.calculateAge(each.getUser().getBirthday());
			vote = each.isValue();
			if (years >= 18 && years <= 30) {
				if (vote) {
					this.youngNumberYes++;
				} else {
					this.youngNumberNo++;
				}
			} else if (years > 30 && years <= 55) {
				if (vote) {
					this.adultgPerYes++;
				} else {
					this.adultNumberNo++;
				}
			} else if (years > 55) {
				if (vote) {
					this.oldNumberYes++;
				} else {
					this.oldNumberNo++;
				}
			}
		}

	}

	private void setPercentages() {
		this.youngPerYes = (getYoungNumberYes() / getTotal()) * 100;
		this.youngPerNo = (getYoungNumberNo() / getTotal()) * 100;
		this.adultgPerYes = (getAdultNumberYes() / getTotal()) * 100;
		this.adultgPerNo = (getAdultNumberNo() / getTotal()) * 100;
		this.oldPerYes = (getOldNumberYes() / getTotal()) * 100;
		this.oldPerNo = (getOldNumberNo() / getTotal()) * 100;

	}

	@Override
	public String toString() {
		return "With a participation of " + getTotal()
				+ " we have the next statistics looking to the years of the citizens: \n"
				+ "\t Between 18 and 30 years old: " + "\n\t\tYes-->" + getYoungPerYes() + "%" + "\n\t\tNo-->"
				+ getYoungPerNo() + "%" + "\t Between 30 and 55 years old: " + "\n\t\tYes-->" + getAdultgPerYes() + "%"
				+ "\n\t\tNo-->" + getAdultgPerNo() + "%" + "\t More tha 55 years old: " + "\n\t\tYes-->"
				+ getOldPerYes() + "%" + "\n\t\tNo-->" + getOldPerNo() + "%";

	}

}
