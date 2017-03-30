package es.uniovi.asw.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uniovi.asw.domain.User;
import es.uniovi.asw.repository.CommentRepository;
import es.uniovi.asw.repository.ProposalRepository;
import es.uniovi.asw.repository.UserRepository;
import es.uniovi.asw.repository.VoteCommentRepository;
import es.uniovi.asw.repository.VoteProposalRepository;

@Service
public class Dashboard implements ShowInfo, SendAlarm{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	VoteCommentRepository voteCommentRepository;
	
	@Autowired
	VoteProposalRepository voteProposalRepository;
	
	@Autowired
	CommentRepository commentRepository;
	
	@Autowired
	ProposalRepository proposalRepository;
	
	public void listAll(){
		System.out.println(userRepository.findAll().stream().map(u -> u.toString()).reduce("", String::concat));
		System.out.println(proposalRepository.findAll().stream().map(p -> p.toString()).reduce("", String::concat));
		System.out.println(voteProposalRepository.findAll().stream().map(v -> v.toString()).reduce("", String::concat));
		System.out.println(commentRepository.findAll().stream().map(c -> c.toString()).reduce("", String::concat));
		System.out.println(voteCommentRepository.findAll().stream().map(v -> v.toString()).reduce("", String::concat));
		
	}
	
	/**
	 * Get the info of a participant passing as parameters its credentials
	 * @param login - login of the participant to retrieve
	 * @param password - password of the participant to retrieve
	 */
	public User getParticipant(String login, String password) {
		User user = userRepository.findByLoginAndPassword(login, password);
		return user;
	}

}
