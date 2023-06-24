package com.uep.wap.controller;

import com.uep.wap.Encoder;
import com.uep.wap.dto.UserDTO;
import com.uep.wap.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/userController")
public class UserContoller {

    private final UserService userService;
    private final Encoder encoder;


    public UserContoller(UserService userService, Encoder encoder)
    {
        this.userService = userService;
        this.encoder = encoder;
    }

    @GetMapping(path = "/getUsers")
    public Iterable<com.uep.wap.model.User> getAllUsers() {
        return userService.getAllUser();
    }

    @PostMapping("/registerUser")
    public ResponseEntity registerUser(@RequestBody @Validated UserDTO user) {

        if ( userService.loadUserByUsername( user.getUsername()) != null ) {
            return new ResponseEntity<>("Cannot register new user, email already in database", HttpStatus.BAD_REQUEST);
        }

            user.setPassword(encoder.passwordEncoder().encode(user.getPassword()));
//        user.setRole("USER");
            userService.addUser(user);
            return new ResponseEntity<>("Successfully registered", HttpStatus.OK);



    }

}
