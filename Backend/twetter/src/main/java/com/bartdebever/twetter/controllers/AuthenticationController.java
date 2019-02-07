package com.bartdebever.twetter.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api("Endpoint used to authenticate an user and get your tokens.")
@RestController
public class AuthenticationController {
    @ApiOperation("Get's a token based on the username and password provided.")
    @GetMapping("auth/login")
    public String login(@RequestBody String username, @RequestBody String password){
        return null;
    }
}
