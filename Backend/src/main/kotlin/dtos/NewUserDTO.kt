package dtos

import java.io.Serializable

/**
 * Resource used to create new users.
 * Intended to only be used on the API end.
 */
class NewUserDTO : Serializable {
    /**
     * Gets the username for the new user.
     * @return the username of the new user.
     */
    /**
     * Sets the username for the new user.
     * @param userName the name wanting to be set.
     */
    var userName: String? = null
    /**
     * Gets the email for the new user.
     * @return the email for the user.
     */
    /**
     * Sets the email for the new user.
     * @param email the email wanting to be set.
     */
    var email: String? = null
    /**
     * Gets the password of the new user.
     * @return the password of the user.
     */
    /**
     * Sets the password for the new user.
     * @param password the password wanting to be set.
     */
    var password: String? = null
}
