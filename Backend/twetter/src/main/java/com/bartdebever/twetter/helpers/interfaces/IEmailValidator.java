package com.bartdebever.twetter.helpers.interfaces;

public interface IEmailValidator {
    /**
     * Validates if the given String is a valid email.
     * Null or empty will also return false.
     * @param email the string wanting to be checked.
     * @return a boolean to indicate if the email is valid.
     */
    boolean validateEmail(String email);
}
