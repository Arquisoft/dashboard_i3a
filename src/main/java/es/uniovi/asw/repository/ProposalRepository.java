package es.uniovi.asw.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.uniovi.asw.domain.Proposal;

@Repository
public interface ProposalRepository extends JpaRepository<Proposal, Long> {
	
	Proposal findById(Long id);
	
}
