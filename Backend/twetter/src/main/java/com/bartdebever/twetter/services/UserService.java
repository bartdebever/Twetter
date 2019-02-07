package com.bartdebever.twetter.services;

import com.bartdebever.twetter.models.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * A service to perform CRUD actions for the User class.
 */
public class UserService extends CrudService<User> {
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
}
