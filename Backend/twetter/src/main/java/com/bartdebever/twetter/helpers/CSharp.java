package com.bartdebever.twetter.helpers;

import com.bartdebever.twetter.models.interfaces.IEntity;

import java.util.List;

/**
 * Helper methods that will be used to basically get the C# features in java.
 */
public class CSharp {
    /**
     * Grabs the first entity that has an Id equal to the given id.
     * @param entityList the list of entities wanting to be searched.
     * @param id the id wanting to be searched for.
     * @return the entity or null.
     */
    public static <T extends IEntity> IEntity firstOrDefault(List<T> entityList, int id) {
        for (IEntity entity : entityList) {
            if (entity.getId() == id) {
                return entity;
            }
        }

        return null;
    }
}
