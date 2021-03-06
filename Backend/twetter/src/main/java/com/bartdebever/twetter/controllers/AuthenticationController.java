package com.bartdebever.twetter.controllers;

import com.bartdebever.twetter.ApplicationConstants;
import com.bartdebever.twetter.beans.interfaces.IUserBean;
import com.bartdebever.twetter.helpers.SpringTokenHelper;
import com.bartdebever.twetter.helpers.Twetter;
import com.bartdebever.twetter.helpers.interfaces.IJwtTokenGenerator;
import com.bartdebever.twetter.helpers.interfaces.IUserAuthHelper;
import com.bartdebever.twetter.models.User;
import com.bartdebever.twetter.resources.LoginResource;
import com.bartdebever.twetter.resources.UserResource;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

@Api("Endpoint used to authenticate an user and get your tokens.")
@RestController
public class AuthenticationController {
    @Autowired
    private IUserBean userBean;

    @Autowired
    private IJwtTokenGenerator jwtTokenGenerator;

    @Autowired
    private IUserAuthHelper authHelper;

    /**
     * Gets a token based on the provided username and password.
     * @param login the login resourced used to transfer the username and password.
     * @return a JWT token or a 400 when the user is not found.
     */
    @ApiOperation("Gets a token based on the username and password provided.")
    @PostMapping("auth/login")
    public ResponseEntity<String> login(@RequestBody LoginResource login) {
        User user = userBean.getUserByName(login.getUsername());

        if (!BCrypt.checkpw(login.getPassword(), user.getPassword())) {
            // Unauthorized exception.
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The user could not be found.");
        }


        // Generate and return JWT Token.
        return ResponseEntity.ok(jwtTokenGenerator.generateToken(ApplicationConstants.APPLICATION_NAME, String.valueOf(user.getId()), (long)1000000.0));
    }

    /**
     * Gets the information about the current user based on the set JWT token.
     * @param headers the headers in the request.
     * @return the information about the user.
     */
    @ApiOperation("Gets the information about the current user.")
    @GetMapping("auth/info")
    public ResponseEntity<UserResource> info(@RequestHeader HttpHeaders headers) {
        String token = SpringTokenHelper.getTokenFromHeader(headers);
        User user = authHelper.getUserByToken(token);

        ModelMapper mapper = Twetter.getMapper();
        return ResponseEntity.ok(mapper.map(user, UserResource.class));
    }
}
