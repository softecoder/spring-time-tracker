package timetracker.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import timetracker.demo.entity.Activity;
import timetracker.demo.entity.User;

@Slf4j
@Controller
@SessionAttributes(names = {"user","activity"})
public class LoginController {
    @ModelAttribute(name = "activity")
    public Activity activity() {
        return new Activity();
    }

    @ModelAttribute(name = "user")
    public User user() {
        return new User();
    }

    @GetMapping("/")
    public String startPage() {
        return "login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/internationalLog")
    public String international() {
        return "login";
    }


}
