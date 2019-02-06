package com.bartdebever.twetter.resources;

/**
 * Resource used to create new users.
 * Intended to only be used on the API end.
 */
public class NewUser {
    private String userName;
    private String email;
    private String password;

    /**
     * Gets the username for the new user.
     * @return the username of the new user.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * Sets the username for the new user.
     * @param userName the name wanting to be set.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * Gets the password of the new user.
     * @return the password of the user.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password for the new user.
     * @param password the password wanting to be set.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the email for the new user.
     * @return the email for the user.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email for the new user.
     * @param email the email wanting to be set.
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
