package com.bartdebever.twetter.beans.interfaces;

import com.bartdebever.twetter.helpers.CSharp;
import com.bartdebever.twetter.models.Role;

import java.util.ArrayList;
import java.util.List;

public class LocalRoleBean implements IRoleBean {
    private List<Role> roleList;

    public LocalRoleBean() {
        roleList = new ArrayList<>();
    }
    @Override
    public void AddRole(Role role) {
        roleList.add(role);
    }

    @Override
    public Role GetRole(int id) {
        return (Role)CSharp.firstOrDefault(roleList, id);
    }

    @Override
    public List<Role> GetAllRoles() {
        return roleList;
    }

    private Role firstOrDefault(int id) {
        for (Role role : roleList) {
            if (role.getId() == id) {
                return role;
            }
        }

        return null;
    }
}
