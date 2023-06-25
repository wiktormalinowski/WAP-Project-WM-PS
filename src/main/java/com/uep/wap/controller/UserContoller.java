package com.uep.wap.controller;

import com.uep.wap.Encoder;
import com.uep.wap.dto.UserDTO;
import com.uep.wap.model.User;
import com.uep.wap.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
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

    @GetMapping("/registerUser")
    public String registerUserForm( Model model ) {
        model.addAttribute("user", new User());
        return "registerForm";
    }

    @PostMapping("/registerUser")
    public String registerUser(@ModelAttribute UserDTO user) {
        if ( userService.loadUserByUsername( user.getUsername()) != null ) {
            return "redirect:/userController/registerUser";
        }

        user.setPassword(encoder.passwordEncoder().encode(user.getPassword()));
        userService.addUser(user);
        return "redirect:/auctionController/getAuctions";

    }

//        if ( userService.loadUserByUsername( user.getUsername()) != null ) {
//            return new ResponseEntity<>("Cannot register new user, email already in database", HttpStatus.BAD_REQUEST);
//        }
//
//            user.setPassword(encoder.passwordEncoder().encode(user.getPassword()));
////        user.setRole("USER");
//            userService.addUser(user);
//            return new ResponseEntity<>("Successfully registered", HttpStatus.OK);
//    }

}
