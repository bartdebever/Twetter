package com.bartdebever.twetter.services;

import com.bartdebever.twetter.models.interfaces.IEntity;

import javax.persistence.EntityManager;

public abstract class CrudService<T extends IEntity> {

    private EntityManager entityManager;

    public void update(T entity) {
        entityManager.merge(entity);
    }

    public void delete(T entity) {
        entityManager.remove(entityManager.merge(entity));
    }

    public void insert(T entity) {
        entityManager.persist(entity);
    }
}
