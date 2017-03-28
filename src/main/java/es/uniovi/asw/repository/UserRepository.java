package es.uniovi.asw.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.uniovi.asw.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	User findByLogin(String login);

	User findByLoginAndPassword(String login, String password);

	User findById(Long id);
	
	List<User> findAll();
}