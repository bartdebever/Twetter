package com.bartdebever.twetter.services.interfaces;

import com.bartdebever.twetter.models.interfaces.IEntity;

import java.util.List;

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

    /**
     * Gets a entity by it's id.
     * @param id the id of the entity.
     * @return the instance of the entity or null.
     */
    T getById(int id);

    /**
     * Gets all the entities in the application.
     * @return a list of all entities.
     */
    List<T> getAll();
}
