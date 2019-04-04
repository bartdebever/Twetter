package services

import models.Reply
import services.interfaces.IReplyService

/**
 * Service to perform Crud actions for the Reply object.
 */
class ReplyService : CrudService<Reply>(), IReplyService {

    override val all: List<Reply>? = null

    override fun getById(id: Int): Reply {
        return session.get<Reply>(Reply::class.java, id)
    }
}
