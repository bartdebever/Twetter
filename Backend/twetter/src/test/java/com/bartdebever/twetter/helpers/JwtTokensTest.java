package com.bartdebever.twetter.helpers;

import com.bartdebever.twetter.helpers.interfaces.IJwtTokenGenerator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class JwtTokensTest {
    private IJwtTokenGenerator tokenGenerator;

    @Before
    public void beforeTests() {
        tokenGenerator = new JwtTokenGenerator();
    }

    @Test
    public void generateToken() {
        String result = tokenGenerator.generateToken("Twetter", "Tests", 1000);
        Assert.assertNotNull(result);
        Assert.assertFalse(CSharp.isNullOrWhitespace(result));
    }
}
