package timetracker.demo.services;

import org.springframework.ui.Model;
import timetracker.demo.entity.Activity;
import timetracker.demo.entity.Tracking;
import timetracker.demo.entity.User;

import java.util.List;
import java.util.Optional;

public interface AdminService {

    void saveActivity(Activity activity);

    List<Activity> findAllActivities();
}
