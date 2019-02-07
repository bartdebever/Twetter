package com.bartdebever.twetter.controllers;

import com.bartdebever.twetter.beans.interfaces.IUserBean;
import com.bartdebever.twetter.models.User;
import com.bartdebever.twetter.resources.LoginResource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api("Endpoint used to authenticate an user and get your tokens.")
@RestController
public class AuthenticationController {
    private IUserBean userBean;

    @ApiOperation("Get's a token based on the username and password provided.")
    @GetMapping("auth/login")
    public String login(@RequestBody LoginResource login) {
        User user = userBean.getUserByName(login.getUsername());

        if (!BCrypt.checkpw(login.getPassword(), user.getPassword())) {
            // Unauthorized exception.
        }

        // Generate and return JWT Token.
        return null;
    }
}
