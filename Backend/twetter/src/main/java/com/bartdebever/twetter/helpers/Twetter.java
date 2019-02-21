package com.bartdebever.twetter.helpers;

import com.bartdebever.twetter.logging.JLogger;
import com.bartdebever.twetter.logging.interfaces.ILogger;

public class Twetter {

    /**
     * Gets a logger object for the given name.
     * @param name the name for the logger object.
     * @return an instance of a logger object.
     */
    public static ILogger getLogger(String name) {
        return new JLogger(name);
    }
}
