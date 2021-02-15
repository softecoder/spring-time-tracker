package timetracker.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import timetracker.demo.dao.UserRepository;
import timetracker.demo.entity.User;

@Slf4j
@Controller
@SessionAttributes(names = {"user"})
public class ClientController {

    private final UserRepository userRepository;

    @Autowired
    public ClientController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @ModelAttribute(name = "user")
    public User user() {
        return new User();
    }

    @GetMapping("/client")
    public String client() {
        return "client";
    }

    @GetMapping("/internationalClient")
    public String international() {
        return "client";
    }


}
