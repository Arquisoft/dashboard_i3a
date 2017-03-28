package es.uniovi.asw.services;

import org.springframework.beans.factory.annotation.Autowired;

import es.uniovi.asw.repository.UserRepository;

public class Dashboard implements ShowInfo, SendAlarm{
	
	@Autowired
	UserRepository userRepository;

}
