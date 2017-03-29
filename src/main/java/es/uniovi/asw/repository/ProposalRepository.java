package es.uniovi.asw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.uniovi.asw.domain.Comment;
import es.uniovi.asw.domain.Proposal;

@Repository
public interface ProposalRepository extends JpaRepository<Proposal, Long> {
	
	Comment findById(Long id);
	
	List<Proposal> findAll();


}
