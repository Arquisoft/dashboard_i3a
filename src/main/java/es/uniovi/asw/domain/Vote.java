package es.uniovi.asw.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "Votes")
public class Vote {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="id_proposal")
	private Proposal proposal;
	
	@ManyToOne
	@JoinColumn(name="id_user")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="id_comment")
	private Comment comment;

	public Vote() {
	}

	public Vote(Long id, Proposal proposal, User user, Comment comment) {
		super();
		this.user = user;
		this.comment = comment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Vote [user=" + user + ", comment=" + comment + "]";
	}

}
