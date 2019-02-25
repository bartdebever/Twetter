package com.bartdebever.twetter.controllers;

import com.bartdebever.twetter.beans.interfaces.IUserBean;
import com.bartdebever.twetter.helpers.SpringTokenHelper;
import com.bartdebever.twetter.helpers.interfaces.IUserAuthHelper;
import com.bartdebever.twetter.models.User;
import com.bartdebever.twetter.resources.NewUser;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

/**
 * A class to execute actions around the User object.
 */
@RestController
public class UserController {


    @Autowired
    private IUserBean _userBean;

    @Autowired
    private IUserAuthHelper authHelper;

    /**
     * Creates a new user based on the given username, email and password.
     * @param user the user wanting to be created.
     */
    @ApiOperation(value = "Creates a new user based on the given body.")
    @PostMapping("/user/create/")
    public void createUser(@RequestBody NewUser user) {
        User newUser = User.CreateUserFromNew(user);
        newUser.setPassword(BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt()));
        _userBean.addUser(newUser);
    }

    /**
     * Updates a user's profile with the given information.
     * @param user the user's updated profile.
     */
    @ApiOperation(value = "Updates the current user to have new information.")
    @PostMapping("/user/update")
    public void updateUser(@RequestBody User user, @RequestHeader HttpHeaders headers) {
        String token = SpringTokenHelper.getTokenFromHeader(headers);
        User oldUser = authHelper.getUserByToken(token);
        if (oldUser.getId() == user.getId()) {
            user.setPassword(oldUser.getPassword());
            _userBean.updateUser(user);
        }
    }

    /**
     * Follows a user from the current user.
     * @param id the id of the user wanting to follow.
     */
    @ApiOperation(value = "Makes the current user follow someone else.")
    @PostMapping("/user/follow/{id}")
    public void followUser(@PathVariable String id, @RequestHeader HttpHeaders headers) {
        String token = SpringTokenHelper.getTokenFromHeader(headers);
        User user = authHelper.getUserByToken(token);
        User following = _userBean.getUser(Integer.parseInt(id));
        _userBean.followUser(user, following);
    }

    /**
     * Gets the user's information based on his id.
     * @param id the id wanting to be looked for.
     * @return the user object.
     */
    @ApiOperation(value = "Gets the user's public information.")
    @GetMapping("/user/{id}")
    public @ResponseBody User getUser(@PathVariable String id) {
        int idInt = Integer.parseInt(id);
        return _userBean.getUser(idInt);
    }
}
