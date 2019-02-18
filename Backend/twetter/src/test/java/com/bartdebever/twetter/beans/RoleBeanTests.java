package com.bartdebever.twetter.beans;

import com.bartdebever.twetter.beans.interfaces.IRoleBean;
import org.junit.Before;
import org.junit.Test;

public class RoleBeanTests {

    private IRoleBean roleBean;

    @Before
    public void beforeTests() {
        roleBean = new RoleBean();
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
