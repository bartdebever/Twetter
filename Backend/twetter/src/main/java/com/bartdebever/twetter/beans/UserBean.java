package com.bartdebever.twetter.beans;

import com.bartdebever.twetter.beans.interfaces.IUserBean;
import com.bartdebever.twetter.resources.NewUser;
import com.bartdebever.twetter.models.User;
import com.bartdebever.twetter.services.UserService;

import java.util.List;

public class UserBean implements IUserBean {

    //@Inject
    public UserService userService;

    @Override
    public User getUser(int id) {
        return null;
    }

    @Override
    public List<User> GetAllUsers() {
        return null;
    }

    @Override
    public void addUser(NewUser user) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void removeUser(User user) {

    }
}