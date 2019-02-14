package com.bartdebever.twetter.beans.local;

import com.bartdebever.twetter.beans.interfaces.IRoleBean;
import com.bartdebever.twetter.helpers.CSharp;
import com.bartdebever.twetter.models.Role;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@RequestMapping
public class LocalRoleBean extends LocalBean implements IRoleBean {
    private List<Role> roleList;

    public LocalRoleBean() {
        roleList = new ArrayList<>();
    }

    @Override
    public void AddRole(Role role) throws IllegalArgumentException {
        checkForNull(role, "Role can not be null.");
        roleList.add(role);
    }

    @Override
    public Role GetRole(int id) throws IllegalArgumentException {
        checkId(id);
        return CSharp.firstOrDefault(roleList, id);
    }

    @Override
    public List<Role> GetAllRoles() throws IllegalArgumentException {
        return roleList;
    }
}
