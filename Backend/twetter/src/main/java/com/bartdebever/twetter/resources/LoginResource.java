package com.bartdebever.twetter.resources;

public class LoginResource {
    private String username;
    private String password;

    /**
     * Gets the password of the login.
     * @return the set password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password for the login.
     * @param password the password intending to be set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the username used for the login.
     * @return the username.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username for the login.
     * @param username the username wanting to be set.
     */
    public void setUsername(String username) {
        this.username = username;
    }
}
