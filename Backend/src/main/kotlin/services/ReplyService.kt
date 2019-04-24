package services

import models.Reply
import services.interfaces.IReplyService
import javax.enterprise.context.RequestScoped
import javax.enterprise.inject.Default
import javax.inject.Named

/**
 * Service to perform Crud actions for the Reply object.
 */
@Default
@RequestScoped
@Named("Reply")
open class ReplyService : CrudService<Reply>(), IReplyService {

    override val all: List<Reply>? = null

    override fun getById(id: Int): Reply {
        return entityManager!!.find(Reply::class.java, id)
    }
}
