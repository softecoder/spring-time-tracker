package timetracker.demo.dao;

import org.springframework.data.repository.CrudRepository;
import timetracker.demo.entity.Tracking;
import timetracker.demo.entity.User;

import java.util.List;

public interface TrackingRepository extends CrudRepository<Tracking, Long> {

    List<Tracking> findAllByUserId(Long id);
}
