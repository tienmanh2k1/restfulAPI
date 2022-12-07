package spring.io.restfulAPI.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.io.restfulAPI.Model.User;
import spring.io.restfulAPI.Repository.UserRepository;
import spring.io.restfulAPI.Service.NotFoundException;

import java.util.List;


@RestController
@RequestMapping("/api/user/")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("list")
    public List<User> userList(){
        return userRepository.findAll();
    }

    @PostMapping("add")
    public User addUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @GetMapping("getId/{id}")
    public User getUserId(@PathVariable long id){
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found User id :"+id));
    }

    @PutMapping("update/{id}")
    public User updateUser(@RequestBody User newUser,@PathVariable long id){
        return userRepository.findById(id).map(p->{
            p.setUsername(newUser.getUsername());
            p.setPassword(newUser.getPassword());
            p.setEmail(newUser.getEmail());
            return userRepository.save(p);
        }).orElseGet(()->{newUser.setId(id);
            return userRepository.save(newUser);
        });
    }

    @DeleteMapping("delete/{id}")
    public void deleteUser(@PathVariable long id){
        userRepository.deleteById(id);
    }






}
