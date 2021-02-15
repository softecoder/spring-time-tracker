package timetracker.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import timetracker.demo.dao.ActivityRepository;
import timetracker.demo.entity.Activity;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    private final ActivityRepository activityRepository;

    @Autowired
    public AdminServiceImpl(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override
    public void saveActivity(Activity activity) {
        activityRepository.save(activity);
    }

    @Override
    public List<Activity> findAllActivities() {
        return (List<Activity>) activityRepository.findAll();
    }
}
