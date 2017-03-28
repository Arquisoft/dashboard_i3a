package es.uniovi.asw.domain;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity(name = "Proposals")
public class Proposal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="id_owner")
	private User owner;
	
	private String title;
	private String description;
	
	@OneToMany(mappedBy = "proposal")
	private List<Vote> votes;
	
	public Proposal() {
	}
	
	public Proposal(Long id, User owner, String title, String description, List<Vote> votes) {
		super();
		this.id = id;
		this.owner = owner;
		this.title = title;
		this.description = description;
		this.votes = votes;
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

	public List<Vote> getVotes() {
		return votes;
	}

	public void setVotes(List<Vote> votes) {
		this.votes = votes;
	}

	@Override
	public String toString() {
		return "Proposal [id=" + id + ", owner=" + owner + ", title=" + title + ", description=" + description
				+ ", votes=" + votes + "]";
	}

}
