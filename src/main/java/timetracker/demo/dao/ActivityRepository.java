package timetracker.demo.dao;

import org.springframework.data.repository.CrudRepository;
import timetracker.demo.entity.Activity;

public interface ActivityRepository extends CrudRepository<Activity, Long> {

}
