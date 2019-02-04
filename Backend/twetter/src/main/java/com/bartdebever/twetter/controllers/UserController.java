package com.bartdebever.twetter.controllers;

import com.bartdebever.twetter.models.NewUser;
import com.bartdebever.twetter.models.User;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @PostMapping("/user/create/")
    public void createUser(@RequestBody NewUser user) {

    }

    @PostMapping("/user/update")
    public void updateUser(@RequestBody User user) {

    }

    @PostMapping("/user/follow/{id}")
    public void followUser(@PathVariable String id) {

    }

    @GetMapping("/user/{id}")
    public @ResponseBody User getUser(@PathVariable String id) {
        return null;
    }
}
