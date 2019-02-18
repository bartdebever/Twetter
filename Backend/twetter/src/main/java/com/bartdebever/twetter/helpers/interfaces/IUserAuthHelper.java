package com.bartdebever.twetter.helpers.interfaces;

import com.bartdebever.twetter.models.User;

public interface IUserAuthHelper {
    /**
     * Gets the user object based on the given JWT token.
     * @param token the JWT token.
     * @return an user object or null.
     */
    User getUserByToken(String token);
}
