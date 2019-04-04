package services

import models.User
import services.interfaces.IUserService

import javax.transaction.Transactional

/**
 * A service to perform CRUD actions for the User class.
 */
class UserService : CrudService<User>(), IUserService {

    override val all: List<User>?
        get() = null

    override fun addFollow(followerId: Int, followingId: Int) {
        val session = session
        val follower = session.get<User>(User::class.java, followerId)
        val following = session.get<User>(User::class.java, followingId)

        follower.addFollowing(following)
        session.beginTransaction()
        session.update(follower)
        session.transaction.commit()
    }

    @Transactional
    override fun getById(id: Int): User {
        return session.get<User>(User::class.java, id)
    }

    override fun searchByName(username: String): User {
        val session = session
        val query = session.createSQLQuery("SELECT * FROM USERS WHERE userName = ?")
        query.setParameter(1, username)
        query.addEntity(User::class.java)
        return query.singleResult as User
    }
}
