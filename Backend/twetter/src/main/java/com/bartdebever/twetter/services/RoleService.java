package com.bartdebever.twetter.services;

import com.bartdebever.twetter.models.Role;
import com.bartdebever.twetter.services.CrudService;
import com.bartdebever.twetter.services.interfaces.IRoleService;

import java.util.List;

/**
 * A service to perform CRUD actions for the Role class.
 */
public class RoleService extends CrudService<Role> implements IRoleService {
    @Override
    public Role getById(int id) {
        return getEntityManager().find(Role.class, id);
    }

    @Override
    public List<Role> getAll() {
        return null;
    }
}
