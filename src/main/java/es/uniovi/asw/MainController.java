package es.uniovi.asw;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.uniovi.asw.domain.User;
import es.uniovi.asw.dto.UserDto;
import es.uniovi.asw.dto.UserLogin;
import es.uniovi.asw.listeners.ProposalManager;
import es.uniovi.asw.services.Dashboard;

@Controller
public class MainController {
    
    @Autowired
    private Dashboard dashboard;
    
    
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = new ModelAndView("login");
		model.addObject("user", new UserLogin());
		return model;
	}

    @RequestMapping("/dashboard")
    public ModelAndView dashboard(@ModelAttribute("user") UserLogin userLogin, HttpServletRequest request, HttpServletResponse response) {
    	User user = dashboard.GetParticipant(userLogin.getLogin(), userLogin.getPassword());
    	//dashboard.listAll();

    	ModelAndView model = null;

		//If the user is not in the db, we throw an error
		if (user == null) {
			model = new ModelAndView("error");
			model.addObject("errorMessage", "That username is not in our database");
		}
		//Else, we navigate to /dashboard
		else {
			UserDto userDto = UserDto.transform(user);
			model = new ModelAndView("dashboard");
			model.addObject("userDto", userDto);
		
			model.addObject("proposals",ProposalManager.getProposals());
		}
		return model;
    }
}