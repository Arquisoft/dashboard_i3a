package es.uniovi.asw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.uniovi.asw.domain.VoteProposal;

public interface VoteProposalRepository extends JpaRepository<VoteProposal, Long> {

}
