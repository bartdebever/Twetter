package com.bartdebever.twetter.services.interfaces;

import com.bartdebever.twetter.models.User;

public interface IUserService extends ICrudService<User> {
    void addFollow(int followerId, int followingId);

    User searchByName(String username);
}
