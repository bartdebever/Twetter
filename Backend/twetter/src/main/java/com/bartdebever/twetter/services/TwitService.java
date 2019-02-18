package com.bartdebever.twetter.services;

import com.bartdebever.twetter.models.Twit;
import com.bartdebever.twetter.services.interfaces.ITwitService;

import java.util.List;

/**
 * A service to perform CRUD actions for the Twit class.
 */
public class TwitService extends CrudService<Twit> implements ITwitService {
    @Override
    public Twit getById(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("id must be greater than 0");
        }

        return getEntityManager().find(Twit.class, id);
    }

    @Override
    public List<Twit> getAll() {
        return null;
    }
}
