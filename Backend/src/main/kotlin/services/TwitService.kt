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
        get() = session.createSQLQuery("SELECT * FROM TWITS").addEntity(Twit::class.java).list() as List<Twit>?;

    @Transactional
    override fun getById(id: Int): Twit {
        if (id <= 0) {
            throw IllegalArgumentException("id must be greater than 0")
        }

        return session.get<Twit>(Twit::class.java, id)
    }
}
