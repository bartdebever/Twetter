package services

import models.Twit
import services.interfaces.ITwitService
import java.util.*
import javax.enterprise.context.RequestScoped
import javax.enterprise.inject.Default
import javax.inject.Named

import javax.transaction.Transactional

/**
 * A service to perform CRUD actions for the Twit class.
 */
@RequestScoped
@Default
@Named("Twit")
open class TwitService : CrudService<Twit>(), ITwitService {
    private val pageLimit = 50

    override val all: List<Twit>?
        get() = entityManager!!.createQuery("FROM Twit", Twit::class.java).resultList

    @Transactional
    override fun getById(id: Int): Twit {
        if (id <= 0) {
            throw IllegalArgumentException("id must be greater than 0")
        }

        return entityManager!!.find(Twit::class.java, id)
    }

    open fun getTimelineByUser(id: Int, page: Int): List<Twit> {
        val query = entityManager!!.createQuery(
                "SELECT t.*\n" +
                "FROM Twit t\n" +
                "WHERE t.authorId IN\n" +
                "(\n" +
                "    SELECT u.followingId\n" +
                "    FROM USERS_USERS u\n" +
                "    WHERE u.userId = ?userId\n" +
                ")\n" +
                "OR t.authorId = ?userId\n" +
                "LIMIT ?pageLimit\n" +
                "OFFSET ?pageOffset", Twit::class.java)

        query.setParameter("userId", id)
        query.setParameter("pageLimit", pageLimit)
        query.setParameter("pageOffset", page * pageLimit)

        return query.resultList
    }
}
