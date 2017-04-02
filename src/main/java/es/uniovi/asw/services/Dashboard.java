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
public class Dashboard{
	
	@Autowired
	UserRepository userRepository;
	
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
