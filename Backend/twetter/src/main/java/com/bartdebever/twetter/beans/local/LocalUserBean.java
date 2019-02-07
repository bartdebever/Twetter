package com.bartdebever.twetter.beans.local;

import com.bartdebever.twetter.beans.interfaces.IUserBean;
import com.bartdebever.twetter.models.User;
import com.bartdebever.twetter.services.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * A local implementation of the IUserBean interface that uses an ArrayList.
 * This is intended to be just for testing.
 */
public class LocalUserBean implements IUserBean {

    //@Inject
    public UserService userService;
    private List<User> users;
    private static int idCounter = 1;

    public LocalUserBean(){
        users = new ArrayList<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User getUser(int id) {
        return firstOrDefault(id);
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
    public void addUser(User user) {
        user.setId(idCounter++);
        users.add(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateUser(User user) {
        User oldUser = firstOrDefault(user.getId());
        users.remove(oldUser);
        users.add(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeUser(User user) {
        User oldUser = firstOrDefault(user.getId());
        users.remove(oldUser);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void followUser(User currentUser, User followedUser) {
        User user = firstOrDefault(currentUser.getId());
        if (user == null) {
            return;
        }

        user.addFollowing(firstOrDefault(followedUser.getId()));
    }

    private User firstOrDefault(int id) {
        for (User user : users){
            if(user.getId() == id){
                return user;
            }
        }

        return null;
    }
}