package services

import models.User
import org.springframework.security.crypto.bcrypt.BCrypt
import services.interfaces.IUserService
import javax.enterprise.context.RequestScoped
import javax.enterprise.inject.Default
import javax.inject.Named

import javax.transaction.Transactional

/**
 * A service to perform CRUD actions for the User class.
 */
@RequestScoped
@Default
@Named("User")
open class UserService : CrudService<User>(), IUserService {
    override fun validateUser(username: String, password: String): User? {
        val user = searchByName(username)
        if (BCrypt.checkpw(password, user.password)) {
            return user;
        }

        return null;
    }

    override val all: List<User>?
        get() = entityManager!!.createQuery("FROM User", User::class.java).resultList

    override fun addFollow(followerId: Int, followingId: Int) {
        val follower = entityManager!!.find(User::class.java, followerId)
        val following = entityManager.find(User::class.java, followingId)

        follower.addFollowing(following)
        transaction!!.begin()
        entityManager.merge(follower)
        transaction.commit()
    }

    override fun insert(entity: User) {
        entity.password = BCrypt.hashpw(entity.password, BCrypt.gensalt())
        transaction!!.begin()
        entityManager!!.persist(entity)
        transaction.commit()
    }

    @Transactional
    override fun getById(id: Int): User {
        return entityManager!!.find(User::class.java, id)
    }

    override fun searchByName(username: String): User {
        val query = entityManager!!.createQuery("FROM User WHERE userName = :username", User::class.java)
        query.setParameter("username", username)
        return query.singleResult as User
    }
}
