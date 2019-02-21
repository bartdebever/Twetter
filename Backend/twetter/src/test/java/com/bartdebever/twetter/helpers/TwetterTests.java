package com.bartdebever.twetter.helpers;

import com.bartdebever.twetter.logging.interfaces.ILogger;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

public class TwetterTests {

    @Test
    public void loggerIsNotNull() {
        Assert.assertNotNull(Twetter.getLogger("test"));
    }

    @Test
    public void loggerContainsName() {
        ILogger logger = Twetter.getLogger("test");
        Assert.assertTrue(logger.getName().contains("test"));
    }
}
