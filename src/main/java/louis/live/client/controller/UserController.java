package louis.live.client.controller;

import louis.live.client.service.UserService;
import louis.live.client.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/")
    @ResponseBody
    public List<User> getAll() {
        return userService.getAll();
    }

    @RequestMapping("/{userId}")
    @ResponseBody
    public User getOne(@PathVariable("userId") String userId) {
        return userService.getOne(userId);
    }

    @RequestMapping("/findByName/{userName}")
    @ResponseBody
    public User getByName(@PathVariable("userName") String userName) {
        return userService.getByName(userName);
    }

    @RequestMapping("/add")
    @ResponseBody
    public void add(User user) {
        userService.addUser(user);
    }

    @RequestMapping("/checkName")
    @ResponseBody
    public void checkName(@RequestBody Map params) {
        userService.checkName(params);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public void delete(@RequestBody Map params) {
        userService.deleteUser(params);
    }

}
