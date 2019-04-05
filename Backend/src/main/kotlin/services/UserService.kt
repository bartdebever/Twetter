package services

import models.User
import services.interfaces.IUserService
import javax.enterprise.context.RequestScoped
import javax.enterprise.inject.Default

import javax.transaction.Transactional

/**
 * A service to perform CRUD actions for the User class.
 */
@RequestScoped
@Default
open class UserService : CrudService<User>(), IUserService {

    override val all: List<User>?
        get() = null

    override fun addFollow(followerId: Int, followingId: Int) {
        val follower = entityManager!!.find(User::class.java, followerId)
        val following = entityManager.find(User::class.java, followingId)

        follower.addFollowing(following)
        transaction!!.begin()
        entityManager.merge(follower)
        transaction.commit()
    }

    @Transactional
    override fun getById(id: Int): User {
        return entityManager!!.find(User::class.java, id)
    }

    override fun searchByName(username: String): User {
        val query = entityManager!!.createQuery("SELECT * FROM USERS WHERE userName = ?", User::class.java)
        query.setParameter(1, username)
        return query.singleResult as User
    }
}
