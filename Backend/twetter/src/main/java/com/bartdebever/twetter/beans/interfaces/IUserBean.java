package com.bartdebever.twetter.beans.interfaces;

import com.bartdebever.twetter.resources.NewUser;
import com.bartdebever.twetter.models.User;

import java.util.List;

public interface IUserBean {
    User getUser(int id);

    List<User> GetAllUsers();

    void addUser(NewUser user);

    void updateUser(User user);

    void removeUser(User user);
}
