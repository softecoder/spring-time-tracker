package timetracker.demo.services;

import org.springframework.ui.Model;
import timetracker.demo.entity.Tracking;
import timetracker.demo.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void save(User user);

    Optional<User> chekIfUserPresentInDb(User user);

    List<Tracking> findAllTrackingActivityByUserId(User user);

    String checkClientOrAdmin(User user, Model model);

}
