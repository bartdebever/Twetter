package com.bartdebever.twetter.beans;

import com.bartdebever.twetter.beans.interfaces.IRoleBean;
import com.bartdebever.twetter.models.Role;
import com.bartdebever.twetter.services.interfaces.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoleBean implements IRoleBean {

    @Autowired
    private IRoleService roleService;
    @Override
    public void AddRole(Role role) throws IllegalArgumentException {
        roleService.insert(role);
    }

    @Override
    public Role GetRole(int id) throws IllegalArgumentException {
        return roleService.getById(id);
    }

    @Override
    public List<Role> GetAllRoles() {
        return roleService.getAll();
    }
}
