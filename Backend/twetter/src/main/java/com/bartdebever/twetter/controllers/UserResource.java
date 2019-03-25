package com.bartdebever.twetter.controllers;

import com.bartdebever.twetter.beans.interfaces.IUserBean;
import com.bartdebever.twetter.helpers.SpringTokenHelper;
import com.bartdebever.twetter.helpers.Twetter;
import com.bartdebever.twetter.helpers.interfaces.IUserAuthHelper;
import com.bartdebever.twetter.models.User;
import com.bartdebever.twetter.resources.NewUser;
import com.bartdebever.twetter.resources.UserResource;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCrypt;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

/**
 * A class to execute actions around the User object.
 */
//@Produces({"application/json"})
@Path("user")
public class UserController {


    @EJB
    private IUserBean _userBean;

    @EJB
    private IUserAuthHelper authHelper;

    /**
     * Creates a new user based on the given username, email and password.
     * @param user the user wanting to be created.
     */
    //@ApiOperation(value = "Creates a new user based on the given body.")
    @POST
    @Path("/user/create/")
    public void createUser(NewUser user) {
        User newUser = User.CreateUserFromNew(user);
        newUser.setPassword(BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt()));
        _userBean.addUser(newUser);
    }

    /**
     * Updates a user's profile with the given information.
     * @param user the user's updated profile.
     */
    //@ApiOperation(value = "Updates the current user to have new information.")
    @POST
    @Path("/user/update")
    public void updateUser(User user, @Context HttpHeaders headers) {
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
    //@ApiOperation(value = "Makes the current user follow someone else.")

    @POST
    @Path("/user/follow/{id}")
    public void followUser(@PathParam("id") String id, @Context HttpHeaders headers) {
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
    //@ApiOperation(value = "Gets the user's public information.")
    @GET
    @Path("/{id}")
    public UserResource getUser(@PathParam("id") String id) {
        int idInt = Integer.parseInt(id);
        ModelMapper mapper = Twetter.getMapper();
        User user = _userBean.getUser(idInt);
        return mapper.map(user, UserResource.class);
    }
}
