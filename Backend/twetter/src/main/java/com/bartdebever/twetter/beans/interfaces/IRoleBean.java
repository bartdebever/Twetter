package com.bartdebever.twetter.beans.interfaces;

import com.bartdebever.twetter.models.Role;

import java.util.List;

public interface IRoleBean {
    /**
     * Adds a role to the application.
     * @param role the role wanting to be added.
     */
    void AddRole(Role role) throws IllegalArgumentException;

    /**
     * Gets a role based on it's id.
     * @param id the id wanting to be searched for.
     * @return a role object or null.
     */
    Role GetRole(int id) throws IllegalArgumentException;

    /**
     * Gets all roles known in the application.
     * @return a collection of role objects.
     */
    List<Role> GetAllRoles();
}
