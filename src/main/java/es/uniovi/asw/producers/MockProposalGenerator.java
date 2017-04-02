package es.uniovi.asw.producers;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.uniovi.asw.domain.Comment;
import es.uniovi.asw.domain.Proposal;
import es.uniovi.asw.domain.User;
import es.uniovi.asw.domain.VoteProposal;
import es.uniovi.asw.repository.CommentRepository;
import es.uniovi.asw.repository.ProposalRepository;
import es.uniovi.asw.repository.UserRepository;
import es.uniovi.asw.repository.VoteProposalRepository;

@Component
public class MockProposalGenerator {
	
	@Autowired
	private ProposalRepository proposalRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private VoteProposalRepository voteRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	public Proposal generate(){
		int posProposal = ThreadLocalRandom.current().nextInt(proposalRepository.findAll().size());
		User user = userRepository.findAll().get(ThreadLocalRandom.current().nextInt(userRepository.findAll().size()));
		int rVote = ThreadLocalRandom.current().nextInt(1);
		int option = ThreadLocalRandom.current().nextInt(100);
		Proposal proposal;
		
		switch (option%10){
		case 0: //
			proposal = new Proposal();
			proposal.setTitle("Propuesta de prueba generada");
			proposal.setDescription("Descripcion de proposal de prueba generada");
			proposal.setOwner(user);
			break;
		case 1:
			proposal =  proposalRepository.findAll().get(posProposal);
			Comment comment = new Comment();
			comment.setTitle("TestComment");
			comment.setText("TestCommentText");
			comment.setUser(user);
			comment = commentRepository.save(comment);
			proposal.addComment(comment); 
			break;
		default:
			proposal =  proposalRepository.findAll().get(posProposal);
			VoteProposal vote = new VoteProposal();
			vote.setValue(rVote==0);
			vote.setUser(user);
			vote = voteRepository.save(vote);
			proposal.addVote(vote); 
			break;
		}
		
		proposal = proposalRepository.save(proposal);
    	return proposal;
	}

}
