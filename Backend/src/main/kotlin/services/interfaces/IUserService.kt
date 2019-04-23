package services.interfaces

import models.User

interface IUserService : ICrudService<User> {
    /**
     * Adds a user to the other user's following list.
     * @param followerId the user who will be following the other.
     * @param followingId the user being followed.
     */
    fun addFollow(followerId: Int, followingId: Int)

    /**
     * Searches the application for a user with the given name.
     * @param username the username wanting to be searched for.
     * @return an user object or null.
     */
    fun searchByName(username: String): User?

    /**
     * Gets the user by the given username and password.
     * @param username the username that the user has given.
     * @param password the password that the user has given.
     * @return an user object or null.
     */
    fun validateUser(username: String, password: String): User?
}