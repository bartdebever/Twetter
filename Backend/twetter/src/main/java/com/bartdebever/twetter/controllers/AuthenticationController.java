package com.bartdebever.twetter.controllers;

import com.bartdebever.twetter.beans.interfaces.IUserBean;
import com.bartdebever.twetter.beans.local.LocalUserBean;
import com.bartdebever.twetter.helpers.JwtTokenGenerator;
import com.bartdebever.twetter.models.User;
import com.bartdebever.twetter.resources.LoginResource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api("Endpoint used to authenticate an user and get your tokens.")
@RestController
public class AuthenticationController {
    private IUserBean userBean;

    public AuthenticationController() {
        userBean = new LocalUserBean();
    }

    @ApiOperation("Get's a token based on the username and password provided.")
    @PostMapping("auth/login")
    public String login(@RequestBody LoginResource login) {
        User user = userBean.getUserByName(login.getUsername());

        if (!BCrypt.checkpw(login.getPassword(), user.getPassword())) {
            // Unauthorized exception.
            return null;
        }


        // Generate and return JWT Token.
        return new JwtTokenGenerator().generateToken(String.valueOf(user.getId()), user.getUserName(), user.getEmail(), (long)1000000.0);
    }
}
