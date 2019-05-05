package dtos

import java.io.Serializable

class LoginDTO : Serializable {
    /**
     * Gets the username used for the login.
     * @return the username.
     */
    /**
     * Sets the username for the login.
     * @param username the username wanting to be set.
     */
    var username: String = "";
    /**
     * Gets the password of the login.
     * @return the set password.
     */
    /**
     * Sets the password for the login.
     * @param password the password intending to be set.
     */
    var password: String = "";
}
