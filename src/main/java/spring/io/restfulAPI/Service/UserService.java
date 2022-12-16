package spring.io.restfulAPI.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.io.restfulAPI.Model.User;
import spring.io.restfulAPI.Repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(){}

    public UserService(UserRepository userRepository){this.userRepository = userRepository;}

    public List<User> searchUserByKeyword(String keyword){
        return userRepository.searchAll(keyword);
    }
}
