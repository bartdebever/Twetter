package com.bartdebever.twetter.services;

import com.bartdebever.twetter.models.Twit;
import com.bartdebever.twetter.services.interfaces.ITwitService;

import javax.transaction.Transactional;
import java.util.List;

/**
 * A service to perform CRUD actions for the Twit class.
 */
public class TwitService extends CrudService<Twit> implements ITwitService {
    @Override
    @Transactional
    public Twit getById(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("id must be greater than 0");
        }

        return getSession().get(Twit.class, id);
    }

    @Override
    public List<Twit> getAll() {
        return getSession().createSQLQuery("SELECT * FROM TWITS").addEntity(Twit.class).list();
    }
}
