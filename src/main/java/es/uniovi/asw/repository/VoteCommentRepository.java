package es.uniovi.asw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.uniovi.asw.domain.VoteComment;

@Repository
public interface VoteCommentRepository extends JpaRepository<VoteComment, Long> {
	
}
