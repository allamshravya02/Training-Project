package com.cvr.student;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/users")
public class UserController {

    private UserService us;

    public UserController(UserService us) {
        this.us = us;
    }

    @PostMapping("/register")
    public String register(
            @RequestBody User user) {

        return us.register(user);
    }

    @PostMapping("/login")
    public String login(
            @RequestBody User user) {

        boolean valid =
                us.login(
                        user.getUsername(),
                        user.getPassword()
                );

        if(valid) {
            return "SUCCESS";
        }

        return "FAILED";
    }
}