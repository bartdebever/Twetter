package com.bartdebever.twetter.helpers;

import java.util.logging.Logger;

public class Twetter {
    public static Logger getLogger(String name) {
        return Logger.getLogger(String.format("%s.%s", "Twetter", name));
    }
}
