package com.bartdebever.twetter.services.interfaces;

import com.bartdebever.twetter.models.User;

public interface IUserService extends ICrudService<User> {
    /**
     * Adds a user to the other user's following list.
     * @param followerId the user who will be following the other.
     * @param followingId the user being followed.
     */
    void addFollow(int followerId, int followingId);

    /**
     * Searches the application for a user with the given name.
     * @param username the username wanting to be searched for.
     * @return an user object or null.
     */
    User searchByName(String username);
}
