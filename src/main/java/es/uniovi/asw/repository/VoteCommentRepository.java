package es.uniovi.asw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uniovi.asw.domain.VoteComment;

public interface VoteCommentRepository extends JpaRepository<VoteComment, Long>  {

}
