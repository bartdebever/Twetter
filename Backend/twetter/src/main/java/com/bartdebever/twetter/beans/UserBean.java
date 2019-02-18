package com.bartdebever.twetter.beans;

import com.bartdebever.twetter.beans.interfaces.IUserBean;
import com.bartdebever.twetter.helpers.CSharp;
import com.bartdebever.twetter.models.User;
import com.bartdebever.twetter.services.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserBean implements IUserBean {

    private final IUserService userService;

    @Autowired
    public UserBean(IUserService userService) {
        this.userService = userService;
    }

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
        checkForNull(currentUser);
        checkForNull(followedUser);
        userService.addFollow(currentUser.getId(), followedUser.getId());
    }

    @Override
    public User getUserByName(String username) throws IllegalArgumentException {
        if (CSharp.isNullOrWhitespace(username)) {
            throw new IllegalArgumentException("Username can not be null or whitespace.");
        }

        return userService.searchByName(username);
    }

    private void checkForNull(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User can not be null");
        }
    }
}
