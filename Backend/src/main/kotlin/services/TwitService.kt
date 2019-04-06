package services

import models.Twit
import services.interfaces.ITwitService
import javax.enterprise.context.RequestScoped
import javax.enterprise.inject.Default

import javax.transaction.Transactional

/**
 * A service to perform CRUD actions for the Twit class.
 */
@RequestScoped
@Default
open class TwitService : CrudService<Twit>(), ITwitService {

    override val all: List<Twit>?
        get() = entityManager!!.createQuery("FROM Twit", Twit::class.java).resultList;

    @Transactional
    override fun getById(id: Int): Twit {
        if (id <= 0) {
            throw IllegalArgumentException("id must be greater than 0")
        }

        return entityManager!!.find(Twit::class.java, id)
    }
}
