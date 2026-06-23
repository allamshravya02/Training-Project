package com.cvr.student;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepo ur;

    public UserService(UserRepo ur) {
        this.ur = ur;
    }

    public String register(User user) {

        User existing =
                ur.findByUsername(
                        user.getUsername());

        System.out.println("Username entered = "
                + user.getUsername());

        System.out.println("Found user = "
                + existing);

        if(existing != null) {
            return "FAILED";
        }

        ur.save(user);

        return "SUCCESS";
    }

    public boolean login(
            String username,
            String password) {

        User user =
                ur.findByUsernameAndPassword(
                        username,
                        password
                );

        return user != null;
    }
}