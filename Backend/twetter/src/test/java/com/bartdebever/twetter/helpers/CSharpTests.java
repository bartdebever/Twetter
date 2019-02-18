package com.bartdebever.twetter.helpers;

import org.junit.Assert;
import org.junit.Test;

public class CSharpTests {
    @Test
    public void nullString() {
        Assert.assertTrue(CSharp.isNullOrWhitespace(null));
    }

    @Test
    public void emptyString() {
        Assert.assertTrue(CSharp.isNullOrWhitespace(""));
    }

    @Test
    public void whitespaceString() {
        Assert.assertTrue(CSharp.isNullOrWhitespace(" "));
    }

    @Test
    public void stringWithContent() {
        Assert.assertFalse(CSharp.isNullOrWhitespace("TestString."));
    }
}
