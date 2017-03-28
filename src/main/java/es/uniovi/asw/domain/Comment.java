package es.uniovi.asw.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "Comments")
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String comments;

	public Comment() {
	}

	public Comment(Long id, String title, String comments) {
		super();
		this.title = title;
		this.comments = comments;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", title=" + title + ", comments=" + comments + "]";
	}

}
