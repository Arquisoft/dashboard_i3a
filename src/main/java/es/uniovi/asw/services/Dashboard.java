package es.uniovi.asw.services;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.uniovi.asw.domain.Comment;
import es.uniovi.asw.domain.Proposal;
import es.uniovi.asw.domain.User;
import es.uniovi.asw.domain.Vote;
import es.uniovi.asw.repository.CommentRepository;
import es.uniovi.asw.repository.ProposalRepository;
import es.uniovi.asw.repository.UserRepository;
import es.uniovi.asw.repository.VoteRepository;

@Service
public class Dashboard implements ShowInfo, SendAlarm{
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	VoteRepository voteRepository;
	
	@Autowired
	CommentRepository commentRepository;
	
	@Autowired
	ProposalRepository proposalRepository;
	
	public void listAll(){
		System.out.println(userRepository.findAll().stream().map(u -> u.toString()).reduce("", String::concat));
		System.out.println(voteRepository.findAll().stream().map(v -> v.toString()).reduce("", String::concat));
		System.out.println(commentRepository.findAll().stream().map(c -> c.toString()).reduce("", String::concat));
		System.out.println(proposalRepository.findAll().stream().map(p -> p.toString()).reduce("", String::concat));;
	}
	
	/**
	 * Get the info of a participant passing as parameters its credentials
	 * @param login - login of the participant to retrieve
	 * @param password - password of the participant to retrieve
	 */
	public User GetParticipant(String login, String password) {
		User user = userRepository.findByLoginAndPassword(login, password);
		return user;
	}

}
