package louis.live.client.controller;

import louis.live.client.service.UserService;
import louis.live.client.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/getAll")
    @ResponseBody
    public List<User> getAll(){
        return userService.getAll();
    }

    @RequestMapping("/getOne/{userId}")
    @ResponseBody
    public User getOne(@PathVariable("userId") String userId){
        return userService.getOne(userId);
    }

}
