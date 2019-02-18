package com.bartdebever.twetter.helpers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Twetter {
    public static Logger getLogger(String name) {
        return LogManager.getLogger(String.format("%s.%s", "Twetter", name));
    }
}
