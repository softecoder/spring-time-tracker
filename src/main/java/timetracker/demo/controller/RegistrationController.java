package timetracker.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import timetracker.demo.dao.UserRepository;
import timetracker.demo.entity.User;
import timetracker.demo.entity.UserType;
import timetracker.demo.services.UserService;

import javax.validation.Valid;

@Slf4j
@Controller
@SessionAttributes(names = {"user"})
public class RegistrationController {

    private final UserService userService;

    @Autowired
    public RegistrationController(UserService userService) {
        this.userService=userService;
    }

    @ModelAttribute(name = "user")
    public User user() {
        return new User();
    }

    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }

    @PostMapping("/registration")
    public String saveUser(@Valid User user, Errors errors) throws CloneNotSupportedException {
        if (errors.hasErrors()) {
            return "registration";
        }
        user.setUserType(new UserType(2L,"client"));
        user.setId(null);
        User newUser = user.clone();
        userService.save(newUser);
        return "login";
    }

    @GetMapping("/internationalReg")
    public String international() {
        return "registration";
    }
}
