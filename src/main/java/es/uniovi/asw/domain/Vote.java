package es.uniovi.asw.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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
	
	@OneToMany(mappedBy = "vote" , fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Comment> comments;

	private boolean value; 
	
	public Vote() {
	}

	public Vote(Proposal proposal, User user, boolean value) {
		super();
		this.proposal = proposal;
		this.user = user;
		this.value = value;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Vote [user=" + user + ", comments=" + comments + "]";
	}

	public boolean isValue() {
		return value;
	}

	public void setValue(boolean value) {
		this.value = value;
	}

}
