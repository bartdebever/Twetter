package com.bartdebever.twetter.controllers;

import com.bartdebever.twetter.models.NewUser;
import com.bartdebever.twetter.models.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @ApiOperation(value = "Creates a new user based on the given body.")
    @PostMapping("/user/create/")
    public void createUser(@RequestBody NewUser user) {

    }

    @ApiOperation(value = "Updates the current user to have new information.")
    @PostMapping("/user/update")
    public void updateUser(@RequestBody User user) {

    }

    @ApiOperation(value = "Makes the current user follow someone else.")
    @PostMapping("/user/follow/{id}")
    public void followUser(@PathVariable String id) {

    }

    @ApiOperation(value = "Gets the user's public information.")
    @GetMapping("/user/{id}")
    public @ResponseBody User getUser(@PathVariable String id) {
        return null;
    }
}
