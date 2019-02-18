package com.bartdebever.twetter.beans;

import com.bartdebever.twetter.beans.interfaces.IUserBean;
import com.bartdebever.twetter.beans.local.LocalUserBean;
import com.bartdebever.twetter.models.User;
import com.bartdebever.twetter.services.Local.LocalUserService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class UserBeanTests {

    private IUserBean userBean;
    private int idCounter = 1;

    //region Setup
    @Before
    public void beforeTests()
    {
        userBean = new UserBean(new LocalUserService());
    }

    private User createDummy() {
        User user = new User();
        user.setUserName("Dummy");
        user.setPassword("Password123");
        user.setId(idCounter++);

        return user;
    }
    //endregion

    //region Insert tests
    @Test
    public void insertTest() {
        userBean.addUser(createDummy());
        List<User> allUsers = userBean.GetAllUsers();

        Assert.assertNotNull(allUsers);
        Assert.assertFalse(allUsers.isEmpty());
        Assert.assertEquals(allUsers.size(), 1);

        User user = userBean.getUser(idCounter - 1);

        Assert.assertNotNull(user);
    }

    @Test(expected = IllegalArgumentException.class)
    public void insertNull() {
        userBean.addUser(null);
    }
    //endregion

    //region Search tests
    @Test
    public void searchTestCapsSensitive() {
        userBean.addUser(createDummy());

        User user = userBean.getUserByName("Dummy");
        Assert.assertNotNull(user);

        user = userBean.getUserByName("dummy");
        Assert.assertNull(user);
    }

    @Test(expected = IllegalArgumentException.class)
    public void searchEmpty() {
        userBean.getUserByName("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void searchNull() {
        userBean.getUserByName(null);
    }

    //endregion


}
