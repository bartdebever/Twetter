package com.bartdebever.twetter.helpers;

import com.bartdebever.twetter.helpers.interfaces.IEmailValidator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EmailValidationTests {

    private IEmailValidator emailValidator;

    @Before
    public void beforeTests() {
        emailValidator = new EmailValidator();
    }

    @Test
    public void nullTest() {
        Assert.assertFalse(emailValidator.validateEmail(null));
    }

    @Test
    public void randomString() {
        Assert.assertFalse(emailValidator.validateEmail("TestFakeEmail"));
    }

    @Test
    public void correctEmail() {
        Assert.assertTrue(emailValidator.validateEmail("Test@Test.nl"));
    }
}
