package es.uniovi.asw.domain;

import java.io.Serializable;
import java.util.ArrayList;
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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity(name = "Proposals")
@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class, property="@id")
public class Proposal implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="id_owner")
	private User owner;
	
	private String title;
	private String description;
	
	@OneToMany(mappedBy = "proposal", fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<VoteProposal> votes = new ArrayList<VoteProposal>();
	
	@OneToMany(mappedBy = "proposal", fetch=FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Comment> comments = new ArrayList<Comment>();
		
	public Proposal() {
	}
	
	public Proposal(User owner, String title, String description) {
		this.owner = owner;
		this.title = title;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<VoteProposal> getVotes() {
		return votes;
	}

	public void setVotes(List<VoteProposal> votes) {
		this.votes = votes;
	}
	
	public void addVote(VoteProposal vote){
		this.votes.add(vote);
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	
	public void addComment(Comment comment){
		this.comments.add(comment);
	}

	@Override
	public String toString() {
		return "Proposal [id=" + id + ", owner=" + owner + ", title=" + title + ", description=" + description
				+ "]";
	}

}
