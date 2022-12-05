package spring.io.restfulAPI.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.io.restfulAPI.Model.User;
import spring.io.restfulAPI.Repository.UserRepository;
import spring.io.restfulAPI.Service.UserNotFoundException;
import spring.io.restfulAPI.Service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/admin/user")
public class UserController {

    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    public UserController(){}
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/list")
    public List<User> getAll(){
        return userService.getAllUser();
    }

    @GetMapping("get/{id}")
    User getById(@PathVariable long id){
        return userService.getUserId(id);
    }

    @PostMapping("/add")
    public User addNew(@RequestBody User user){
        return userService.addUser(user);
    }

    @PutMapping("/edit/{id}")
    User updateById(@PathVariable long id,@RequestBody User newUser){
        User user;
        return user = userRepository.findUserById(id).map(p ->{
            p.setUsername(newUser.getUsername());
            p.setEmail(newUser.getEmail());
            p.setPassword(newUser.getPassword());
            return userService.addUser(p);
        }).orElseGet(()->{newUser.setId(id);
            return userService.addUser(newUser);
        });
    }

    @DeleteMapping("/delete/{id}")
    void deleteById(@PathVariable long id){
        userService.deleteUserById(id);
    }
}
