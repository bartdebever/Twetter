package com.bartdebever.twetter.services.Local;

import com.bartdebever.twetter.models.User;
import com.bartdebever.twetter.services.interfaces.IUserService;

public class LocalUserService extends LocalCrudService<User> implements IUserService {
    public void addFollow(int followerId, int followingId) {

    }
}
