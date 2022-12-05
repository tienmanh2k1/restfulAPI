package spring.io.restfulAPI.Service;

import org.springframework.web.bind.annotation.PathVariable;
import spring.io.restfulAPI.Model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUser();
    User addUser(User user);
    User getUserId(long id);
    User findByUsername(String username);
    void deleteUserById(long id);
}
