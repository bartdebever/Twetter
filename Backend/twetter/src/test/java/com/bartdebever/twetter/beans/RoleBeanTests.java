package com.bartdebever.twetter.beans;

import com.bartdebever.twetter.beans.interfaces.IRoleBean;
import com.bartdebever.twetter.services.Local.LocalRoleService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleBeanTests {

    @Autowired
    private IRoleBean roleBean;

    @Before
    public void beforeTests() {
        roleBean = new RoleBean(new LocalRoleService());
    }

    @Test(expected = IllegalArgumentException.class)
    public void getInvalid() {
        roleBean.GetRole(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addNull() {
        roleBean.AddRole(null);
    }
}
