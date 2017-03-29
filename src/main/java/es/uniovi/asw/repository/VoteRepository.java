package es.uniovi.asw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.uniovi.asw.domain.Vote;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
	
	Vote findById(Long id);
	
	List<Vote> findAll();


}
