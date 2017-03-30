package es.uniovi.asw.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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

@Entity(name = "Comments")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_proposal")
	private Proposal proposal;

	private String title;
	private String text;

	@OneToMany(mappedBy = "comment", fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<VoteComment> votes;

	@ManyToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "id_commentparent")
	private Comment commentParent;

	@OneToMany(mappedBy = "commentParent")
	private List<Comment> commentChilds;

	private Date creationDate;

	public Comment() {
	}

	public Comment(Proposal proposal, String title, String text) {
		super();
		this.proposal = proposal;
		this.title = title;
		this.text = text;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Proposal getProposal() {
		return proposal;
	}

	public void setProposal(Proposal proposal) {
		this.proposal = proposal;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<VoteComment> getVotes() {
		return votes;
	}

	public void setVotes(List<VoteComment> votes) {
		this.votes = votes;
	}

	public Comment getCommentParent() {
		return commentParent;
	}

	public void setCommentParent(Comment commentParent) {
		this.commentParent = commentParent;
	}

	public List<Comment> getCommentChilds() {
		return commentChilds;
	}

	public void setCommentChilds(List<Comment> commentChilds) {
		this.commentChilds = commentChilds;
	}

	
	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", proposal=" + proposal + ", title=" + title + ", text=" + text
				+ ", commentParent=" + commentParent + "]";
	}

}
