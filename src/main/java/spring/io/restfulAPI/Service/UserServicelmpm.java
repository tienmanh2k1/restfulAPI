package spring.io.restfulAPI.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.io.restfulAPI.Model.User;
import spring.io.restfulAPI.Repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServicelmpm implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User addUser(User user) {
        return null;
    }

    @Override
    public User getUserId(long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        User user = null;
        if (optionalUser.isPresent()){
            user = optionalUser.get();
        }else {
            throw new RuntimeException("Not found id: "+id);
        }
        return user;
    }

    @Override
    public User findByUsername(String username) {
        return null;
    }

    @Override
    public void deleteUserById(long id) {

    }
}
