package com.bartdebever.twetter.services.interfaces;

import com.bartdebever.twetter.models.interfaces.IEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public interface ICrudService <T extends IEntity> {
    /**
     * Updates an entity in the underlying database.
     * @param entity the entity wanting to be updated.
     */
    void update(T entity);

    /**
     * Deletes an entity from the underlying database.
     * @param entity the entity wanting to be removed.
     */
    void delete(T entity);

    /**
     * Inserts an entity into the underlying database.
     * @param entity the entity wanting to be inserted.
     */
    void insert(T entity);
}
