package com.bartdebever.twetter.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Twetter {

    /**
     * Gets a logger object for the given name.
     * @param name the name for the logger object.
     * @return an instance of a logger object.
     */
    public static Logger getLogger(String name) {
        return LogManager.getLogger(String.format("%s.%s", "Twetter", name));
    }
}
