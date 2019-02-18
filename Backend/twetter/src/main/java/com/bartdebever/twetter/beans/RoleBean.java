package com.bartdebever.twetter.beans;

import com.bartdebever.twetter.beans.interfaces.IRoleBean;
import com.bartdebever.twetter.models.Role;
import com.bartdebever.twetter.services.interfaces.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RoleBean implements IRoleBean {

    private final IRoleService roleService;

    @Autowired
    public RoleBean(IRoleService roleService) {
        this.roleService = roleService;
    }

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
