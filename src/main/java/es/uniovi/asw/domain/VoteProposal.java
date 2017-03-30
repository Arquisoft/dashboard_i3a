package es.uniovi.asw.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity(name = "Votesproposals")
@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property = "@id")
public class VoteProposal implements Vote {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_proposal")
	private Proposal proposal;

	@ManyToOne
	@JoinColumn(name = "id_user")
	private User user;

	private boolean value;

	public VoteProposal() {
	}

	public VoteProposal(Proposal proposal, User user, boolean value) {
		this.proposal = proposal;
		this.user = user;
		this.value = value;
	}

	@Override
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Proposal getProposal() {
		return proposal;
	}

	public void setProposal(Proposal proposal) {
		this.proposal = proposal;
	}

	@Override
	public boolean isValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "VoteProposal [id=" + id + ", proposal=" + proposal + ", user=" + user + ", value=" + value + "]";
	}

}
