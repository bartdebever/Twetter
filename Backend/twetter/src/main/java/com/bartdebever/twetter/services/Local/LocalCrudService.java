package com.bartdebever.twetter.services.Local;

import com.bartdebever.twetter.helpers.CSharp;
import com.bartdebever.twetter.models.interfaces.IEntity;
import com.bartdebever.twetter.services.interfaces.ICrudService;

import java.util.List;

public abstract class LocalCrudService <T extends IEntity> implements ICrudService<T> {
    private List<T> entityList;

    @Override
    public void update(T entity) {
        checkForNull(entity);
        T existingEntity = CSharp.firstOrDefault(entityList, entity.getId());
        entityList.set(entityList.indexOf(existingEntity), entity);
    }

    @Override
    public void delete(T entity) {
        checkForNull(entity);
        T existingEntity = CSharp.firstOrDefault(entityList, entity.getId());
        entityList.remove(existingEntity);
    }

    @Override
    public void insert(T entity) {
        checkForNull(entity);
        entityList.add(entity);
    }

    private void checkForNull(T entity) throws IllegalArgumentException {
        if (entity == null) {
            throw new IllegalArgumentException("entity can not be null");
        }
    }
}
