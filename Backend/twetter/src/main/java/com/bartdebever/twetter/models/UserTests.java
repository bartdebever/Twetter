package com.bartdebever.twetter.models;

import com.bartdebever.twetter.resources.NewUser;
import org.junit.Assert;
import org.junit.Test;

public class UserTests {
    private final static String TEST_USERNAME = "TestUserName";
    private final static String TEST_PASSWORD = "TestPassword";
    private final static String TEST_EMAIL = "TestEmail";

    @Test
    public void createUserTest() {
        NewUser newUser = new NewUser();
        newUser.setUserName(TEST_USERNAME);
        newUser.setPassword(TEST_PASSWORD);
        newUser.setEmail(TEST_EMAIL);

        User user = User.CreateUserFromNew(newUser);
        
        Assert.assertNotNull(newUser);
        Assert.assertEquals(TEST_EMAIL, user.getEmail());
        Assert.assertEquals(TEST_PASSWORD, user.getPassword());
        Assert.assertEquals(TEST_USERNAME, user.getUserName());
    }
}
