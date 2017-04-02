package es.uniovi.asw;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.uniovi.asw.domain.User;
import es.uniovi.asw.repository.UserRepository;

@RestController
public class APIController {
    
    @Autowired
    private UserRepository userRepository;
    
    @RequestMapping("/users")
    public List<User> user() {
        return null;
    }

}