package calendar.repository;

import calendar.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserRepository extends CrudRepository<User, Long>{
    List<User> findByName(String lastName);
}