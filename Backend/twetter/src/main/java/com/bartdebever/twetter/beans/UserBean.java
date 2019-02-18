package com.bartdebever.twetter.beans;

import com.bartdebever.twetter.beans.interfaces.IUserBean;
import com.bartdebever.twetter.models.User;
import com.bartdebever.twetter.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserBean implements IUserBean {

    @Autowired
    private IUserService userService;

    @Override
    public User getUser(int id) throws IllegalArgumentException {
        return userService.getById(id);
    }

    @Override
    public List<User> GetAllUsers() {
        return userService.getAll();
    }

    @Override
    public void addUser(User user) throws IllegalArgumentException {
        userService.insert(user);
    }

    @Override
    public void updateUser(User user) throws IllegalArgumentException {
        userService.update(user);
    }

    @Override
    public void removeUser(User user) throws IllegalArgumentException {
        userService.delete(user);
    }

    @Override
    public void followUser(User currentUser, User followedUser) throws IllegalArgumentException {
        userService.addFollow(currentUser.getId(), followedUser.getId());
    }

    @Override
    public User getUserByName(String username) throws IllegalArgumentException {
        return null;
    }
}
