package com.bartdebever.twetter.beans.interfaces;

import com.bartdebever.twetter.resources.NewUser;
import com.bartdebever.twetter.models.User;

import java.util.List;

public interface IUserBean {
    /**
     * Gets a user object based on the given id.
     * @param id the id wanting to be looked for.
     * @return null or a user object.
     */
    User getUser(int id);

    /**
     * Gets all users known to the application.
     * @return A collection of user objects.
     */
    List<User> GetAllUsers();

    /**
     * Adds an user to the application.
     * @param user the user wanting to be added.
     */
    void addUser(User user);

    /**
     * Updates an user's information.
     * @param user the user's new information.
     */
    void updateUser(User user);

    /**
     * Removes an user from the application.
     * @param user the user wanting to be removed.
     */
    void removeUser(User user);

    /**
     * Follows an user based on the current user.
     * @param currentUser the user that will give the follow.
     * @param followedUser the user that is being followed.
     */
    void followUser(User currentUser, User followedUser);
}
