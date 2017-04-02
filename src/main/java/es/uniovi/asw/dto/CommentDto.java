package es.uniovi.asw.dto;

import es.uniovi.asw.domain.Comment;
import es.uniovi.asw.logicInfo.VotesInfoGenero;
import es.uniovi.asw.logicInfo.VotesInfoRangoEdad;
import es.uniovi.asw.logicInfo.VotesInformation;

public class CommentDto {
	
	private Comment comment;
	private VotesInfoGenero votesInfoGenero;
	private VotesInfoRangoEdad votesInfoRangoEdad;
	private VotesInformation votesInformation;
	
	public CommentDto (Comment comment){
		setComment(comment);
		setVotesInformation(new VotesInformation(comment.getVotes()));
		setVotesInfoRangoEdad(new VotesInfoRangoEdad(comment.getVotes()));
		setVotesInfoGenero(new VotesInfoGenero(comment.getVotes()));
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public VotesInfoGenero getVotesInfoGenero() {
		return votesInfoGenero;
	}

	public void setVotesInfoGenero(VotesInfoGenero votesInfoGenero) {
		this.votesInfoGenero = votesInfoGenero;
	}

	public VotesInfoRangoEdad getVotesInfoRangoEdad() {
		return votesInfoRangoEdad;
	}

	public void setVotesInfoRangoEdad(VotesInfoRangoEdad votesInfoRangoEdad) {
		this.votesInfoRangoEdad = votesInfoRangoEdad;
	}

	public VotesInformation getVotesInformation() {
		return votesInformation;
	}

	public void setVotesInformation(VotesInformation votesInformation) {
		this.votesInformation = votesInformation;
	}

}
