package com.bartdebever.twetter.beans.local;

abstract class LocalBean {

    void checkForNull(Object object, String message) throws IllegalArgumentException {
        if (object == null) {
            throw new IllegalArgumentException(message);
        }
    }

    void checkId(int id) throws IllegalArgumentException {
        if (id < 1) {
            throw new IllegalArgumentException("Id greater than 0.");
        }
    }
}
