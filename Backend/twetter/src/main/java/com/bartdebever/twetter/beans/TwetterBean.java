package com.bartdebever.twetter.beans;

public class TwetterBean {
    void checkForNull(Object object) {
        if (object == null) {
            throw new IllegalArgumentException();
        }
    }
}
