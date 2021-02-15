package timetracker.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import timetracker.demo.dao.ActivityRepository;
import timetracker.demo.dao.TrackingRepository;
import timetracker.demo.dao.UserRepository;
import timetracker.demo.entity.Activity;
import timetracker.demo.entity.Tracking;
import timetracker.demo.entity.User;
import timetracker.demo.entity.UserType;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private static final String ADMIN = "admin";
    private final UserRepository userRepository;
    private final TrackingRepository trackingRepository;
    private final ActivityRepository activityRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, TrackingRepository trackingRepository, ActivityRepository activityRepository) {
        this.userRepository = userRepository;
        this.trackingRepository = trackingRepository;
        this.activityRepository=activityRepository;
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public Optional<User> chekIfUserPresentInDb(User user) {
        Optional<User> result = userRepository.findByLoginAndPassword(user.getLogin(), user.getPassword());
        return result;
    }

    @Override
    public List<Tracking> findAllTrackingActivityByUserId(User user) {
        return trackingRepository.findAllByUserId(user.getId());
    }

    @Override
    public String checkClientOrAdmin(User user, Model model) {
        Optional<User> currentUser = chekIfUserPresentInDb(user);
        if (currentUser.isPresent()) {
            List<User> userList = userRepository.findAllByUserType(new UserType(2L, "client"));
            List<Tracking> trackingList = findAllTrackingActivityByUserId(currentUser.get());
            List<Activity>activityList= (List<Activity>) activityRepository.findAll();
            model.addAttribute("trackingList", trackingList);
            model.addAttribute("user", currentUser.get());
            model.addAttribute("userList", userList);
            model.addAttribute("activityList", activityList);

            if (currentUser.get().getUserType().getUserType().equals(ADMIN)) {
                return "admin";
            }
            return "user";
        }
        model.addAttribute("errorMessage", "Incorrect login or password");
        return "login";
    }
}
