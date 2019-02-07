package com.bartdebever.twetter.services;

import com.bartdebever.twetter.models.interfaces.IEntity;

import javax.persistence.EntityManager;

/**
 * An abstract class used to perform some CRUD actions (Create, Read, Update, Delete)
 * @param <T> the type that the entity is wanting to perform these actions on.
 */
public abstract class CrudService<T extends IEntity> {

    private EntityManager entityManager;

    /**
     * Updates an entity in the underlying database.
     * @param entity the entity wanting to be updated.
     */
    public void update(T entity) {
        entityManager.merge(entity);
    }

    /**
     * Deletes an entity from the underlying database.
     * @param entity the entity wanting to be removed.
     */
    public void delete(T entity) {
        entityManager.remove(entityManager.merge(entity));
    }

    /**
     * Inserts an entity into the underlying database.
     * @param entity the entity wanting to be inserted.
     */
    public void insert(T entity) {
        entityManager.persist(entity);
    }

    /**
     * Gets the entity manager which is used by the Crud services.
     * @return the entity manager.
     */
    public EntityManager getEntityManager() {
        return entityManager;
    }
}
