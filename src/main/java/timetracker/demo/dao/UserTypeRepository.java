package timetracker.demo.dao;

import org.springframework.data.repository.CrudRepository;
import timetracker.demo.entity.User;
import timetracker.demo.entity.UserType;

import java.util.List;
import java.util.Optional;

public interface UserTypeRepository extends CrudRepository<UserType, Long> {
}
