package com.uep.wap.controller;

import com.uep.wap.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/userController")
public class UserContoller {

    private final UserService userService;

    public UserContoller(UserService userService) { this.userService = userService;}

    @GetMapping(path = "/getUsers")
    public Iterable<com.uep.wap.model.User> getAllUsers() {
        return userService.getAllUser();
    }

    @PostMapping(path = "/addUser")
    public String addUser(@RequestBody com.uep.wap.dto.UserDTO userDTO){
        userService.addUser(userDTO);
        return "User added!";
    }

}
