package spring.io.restfulAPI.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/user/",method = RequestMethod.GET)
@Controller
public class LuserController {

    @GetMapping("listUser")
    public String listUserRestAPi(){
        return "listUser";
    }

    @PostMapping("saveUser")
    public String saveUserRestAPi(){
        return "addUser";
    }

}
