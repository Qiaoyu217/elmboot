package team.tjusw.elmboot.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import team.tjusw.elmboot.service.UserService;

@RestController
public class HelloController {
    UserService userService;
    @RequestMapping("/hello")
    @ResponseBody
    public int hello(){
        return userService.getUserById("123");
    }
}
