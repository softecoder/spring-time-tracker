package timetracker.demo.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import timetracker.demo.entity.User;
import timetracker.demo.entity.UserType;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByLoginAndPassword(String login, String password);
    List<User> findAllByUserType(UserType userType);
}
