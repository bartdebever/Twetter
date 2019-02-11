package com.bartdebever.twetter.controllers;

import com.bartdebever.twetter.beans.interfaces.IUserBean;
import com.bartdebever.twetter.beans.local.LocalUserBean;
import com.bartdebever.twetter.helpers.JwtTokenGenerator;
import com.bartdebever.twetter.models.User;
import com.bartdebever.twetter.resources.LoginResource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import javax.ejb.EJB;

@Api("Endpoint used to authenticate an user and get your tokens.")
@RestController
public class AuthenticationController {
    @Autowired
    private IUserBean userBean;

    @ApiOperation("Get's a token based on the username and password provided.")
    @PostMapping("auth/login")
    public ResponseEntity<String> login(@RequestBody LoginResource login) {
        User user = userBean.getUserByName(login.getUsername());

        if (!BCrypt.checkpw(login.getPassword(), user.getPassword())) {
            // Unauthorized exception.
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The user could not be found.");
        }


        // Generate and return JWT Token.
        return ResponseEntity.ok(new JwtTokenGenerator().generateToken("Twetter", String.valueOf(user.getId()), (long)1000000.0));
    }

    @ApiOperation("Gets the information about the current user.")
    @GetMapping("auth/info")
    public ResponseEntity<String> info(@RequestHeader HttpHeaders headers) {
        String token = headers.get("Authorization").toString();
        token = token.substring(1, token.length() - 1);
        System.out.println(token);
        String subject = new JwtTokenGenerator().verifyToken(token);
        return ResponseEntity.ok(subject);
    }
}
