package com.bartdebever.twetter.services;

import com.bartdebever.twetter.models.User;
import com.bartdebever.twetter.services.interfaces.IUserService;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * A service to perform CRUD actions for the User class.
 */
public class UserService extends CrudService<User> implements IUserService {
    public void addFollow(int followerId, int followingId) {
        EntityManager entityManager = getEntityManager();
        User follower = entityManager.find(User.class, followerId);
        User following = entityManager.find(User.class, followingId);
        follower.addFollowing(following);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.merge(follower);
        transaction.commit();
    }

    @Override
    public User getById(int id) {
        return getEntityManager().find(User.class, id);
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User searchByName(String username) {
        return null;
    }
}
