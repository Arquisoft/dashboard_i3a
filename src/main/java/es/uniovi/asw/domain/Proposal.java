package es.uniovi.asw.domain;

import java.util.List;
import java.util.Map;

public class Proposal {
	
	private Long id;
	private User user;
	
	private String title;
	private String description;
	
	private Map<User, List<Comment>> votes;
	
	
	

}
