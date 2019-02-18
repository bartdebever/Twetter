package com.bartdebever.twetter.beans;

public class TwetterBean {
    /**
     * Checks if the given object is null and throws an exception when it is null.
     * @param object the object wanting to be checked.
     */
    void checkForNull(Object object) throws IllegalArgumentException {
        if (object == null) {
            throw new IllegalArgumentException();
        }
    }
}
