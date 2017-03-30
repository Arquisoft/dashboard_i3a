package es.uniovi.asw;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import es.uniovi.asw.domain.User;
import es.uniovi.asw.dto.UserDto;
import es.uniovi.asw.dto.UserLogin;
import es.uniovi.asw.services.Dashboard;

@Controller
public class MainController {

    private static final Logger logger = Logger.getLogger(MainController.class);
    private List<SseEmitter> sseEmitters = Collections.synchronizedList(new ArrayList<>());
    
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
    	User user = dashboard.getParticipant(userLogin.getLogin(), userLogin.getPassword());
    	dashboard.listAll();

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
		}
		return model;
    }
}