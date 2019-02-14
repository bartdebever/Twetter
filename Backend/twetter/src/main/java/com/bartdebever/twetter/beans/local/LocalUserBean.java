package com.bartdebever.twetter.beans.local;

import com.bartdebever.twetter.beans.interfaces.IUserBean;
import com.bartdebever.twetter.helpers.CSharp;
import com.bartdebever.twetter.interceptors.interfaces.ILogPerformanceInterceptor;
import com.bartdebever.twetter.models.User;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 * A local implementation of the IUserBean interface that uses an ArrayList.
 * This is intended to be just for testing.
 */
@Stateless
public class LocalUserBean extends LocalBean implements IUserBean {

    private static List<User> users;
    private static int idCounter = 1;

    public LocalUserBean(){
        if (users == null) {
            users = new ArrayList<>();
        }
    }

    public void Reset() {
        idCounter = 1;
        users = new ArrayList<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User getUser(int id) throws IllegalArgumentException {
        checkId(id);

        return CSharp.firstOrDefault(users, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> GetAllUsers() {
        return users;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addUser(User user) throws IllegalArgumentException {
        checkForNull(user, "User can not be null.");

        user.setId(idCounter++);
        users.add(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateUser(User user) throws IllegalArgumentException {
        checkForNull(user, "User can not be null.");

        User oldUser = CSharp.firstOrDefault(users, user.getId());
        users.remove(oldUser);
        users.add(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeUser(User user) throws IllegalArgumentException {
        checkForNull(user, "User can not be null.");

        User oldUser = CSharp.firstOrDefault(users, user.getId());
        users.remove(oldUser);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void followUser(User currentUser, User followedUser) throws IllegalArgumentException {
        checkForNull(currentUser, "CurrentUser can not be null");
        checkForNull(followedUser, "FollowedUser can not be null.");
        User user = CSharp.firstOrDefault(users, currentUser.getId());
        if (user == null) {
            return;
        }

        user.addFollowing(CSharp.firstOrDefault(users, followedUser.getId()));
    }

    @Override
    @ILogPerformanceInterceptor
    public User getUserByName(String username) throws IllegalArgumentException {
        if (CSharp.isNullOrWhitespace(username)) {
            throw new IllegalArgumentException("username is null or empty.");
        }

        for (User user : users) {
            if (user.getUserName().equals(username)){
                return user;
            }
        }

        return null;
    }
}