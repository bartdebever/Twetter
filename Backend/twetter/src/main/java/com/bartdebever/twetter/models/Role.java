package com.bartdebever.twetter.models;

import com.bartdebever.twetter.models.interfaces.IEntity;

/**
 * Class intended to be used to manage permissions.
 */
public class Role implements IEntity {
    private int id;
    private String name;

    /**
     * {@inheritDoc}
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets the name of the role.
     * @return the name of the role.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the role.
     * @param name the name wanting to be set.
     */
    public void setName(String name) {
        this.name = name;
    }
}
