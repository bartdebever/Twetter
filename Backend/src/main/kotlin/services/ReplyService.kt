package services

import models.Reply
import services.interfaces.IReplyService
import javax.enterprise.context.RequestScoped
import javax.enterprise.inject.Default

/**
 * Service to perform Crud actions for the Reply object.
 */
@RequestScoped
@Default
open class ReplyService : CrudService<Reply>(), IReplyService {

    override val all: List<Reply>? = null

    override fun getById(id: Int): Reply {
        return entityManager!!.find(Reply::class.java, id)
    }
}
