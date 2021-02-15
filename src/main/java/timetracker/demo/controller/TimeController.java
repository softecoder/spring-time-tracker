package timetracker.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import timetracker.demo.entity.Tracking;
import timetracker.demo.services.UserService;

@Slf4j
@Controller
@SessionAttributes(names = {"user", "trackingList"})
public class TimeController {

    private UserService userService;

    @Autowired
    public TimeController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/startTime")
    public String userPage(Tracking tracking) {
        return "user";
    }

}
