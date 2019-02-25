package com.bartdebever.twetter.services;

import com.bartdebever.twetter.models.User;
import com.bartdebever.twetter.services.interfaces.IUserService;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.transaction.Transactional;
import java.util.List;

/**
 * A service to perform CRUD actions for the User class.
 */
public class UserService extends CrudService<User> implements IUserService {
    public void addFollow(int followerId, int followingId) {
        Session session = getSession();
        User follower = session.get(User.class, followerId);
        User following = session.get(User.class, followingId);

        follower.addFollowing(following);
        session.beginTransaction();
        session.update(follower);
        session.getTransaction().commit();
    }

    @Override
    @Transactional
    public User getById(int id) {
        return getSession().get(User.class, id);
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public User searchByName(String username) {
        Session session = getSession();
        NativeQuery<User> query = session.createSQLQuery("SELECT * FROM USERS WHERE userName = ?");
        query.setParameter(1, username);
        query.addEntity(User.class);
        return query.getSingleResult();
    }
}
