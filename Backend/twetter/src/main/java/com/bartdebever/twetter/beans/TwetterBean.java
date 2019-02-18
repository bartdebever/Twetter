package com.bartdebever.twetter.beans;

public class TwetterBean {
    public void checkForNull(Object object) {
        if (object == null) {
            throw new IllegalArgumentException();
        }
    }
}
