package com.bartdebever.twetter.helpers.interfaces;

import com.bartdebever.twetter.models.User;

public interface IUserAuthHelper {
    User getUserByToken(String token);
}
