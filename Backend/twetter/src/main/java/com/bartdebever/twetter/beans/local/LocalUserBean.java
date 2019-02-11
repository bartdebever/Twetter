package com.bartdebever.twetter.beans.local;

import com.bartdebever.twetter.beans.interfaces.IUserBean;
import com.bartdebever.twetter.helpers.CSharp;
import com.bartdebever.twetter.models.User;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 * A local implementation of the IUserBean interface that uses an ArrayList.
 * This is intended to be just for testing.
 */
@Stateless
public class LocalUserBean implements IUserBean {

    private static List<User> users;
    private static int idCounter = 1;

    public LocalUserBean(){
        users = new ArrayList<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User getUser(int id) {
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
    public void addUser(User user) {
        user.setId(idCounter++);
        users.add(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateUser(User user) {
        User oldUser = CSharp.firstOrDefault(users, user.getId());
        users.remove(oldUser);
        users.add(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeUser(User user) {
        User oldUser = CSharp.firstOrDefault(users, user.getId());
        users.remove(oldUser);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void followUser(User currentUser, User followedUser) {
        User user = CSharp.firstOrDefault(users, currentUser.getId());
        if (user == null) {
            return;
        }

        user.addFollowing(CSharp.firstOrDefault(users, followedUser.getId()));
    }

    @Override
    public User getUserByName(String username) {
        for (User user : users) {
            if (user.getUserName().equals(username)){
                return user;
            }
        }

        return null;
    }
}